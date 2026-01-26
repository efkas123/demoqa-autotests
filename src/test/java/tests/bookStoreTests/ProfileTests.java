package tests.bookStoreTests;

import io.restassured.response.Response;
import models.AddListOfBooksModel;
import models.DeleteBookModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.TestData.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BookStoreSpecs.baseRequestSpec;
import static specs.BookStoreSpecs.baseResponseSpec;

@Tag("uiapi")
@DisplayName("Гибридные UI+API тесты на demoqa/bookstore")
public class ProfileTests extends TestBase {

    @Test
    @DisplayName("Удаление товара из списка через RestAPI")
    void successfulApiBookDeleteTest() {
        Response authResponse = step("Отправка запроса на авторизацию", () ->
                given(baseRequestSpec)
                        .body(AUTH_DATA)
                        .when()
                        .post("Account/v1/Login")
                        .then()
                        .spec(baseResponseSpec(200))
                        .extract().response());

        String
                token = authResponse.path("token"),
                expires = authResponse.path("expires"),
                userId = authResponse.path("userId");

        step("Отправить запрос на добавление книги в коллекцию", () ->
                given(baseRequestSpec)
                        .header("authorization", "Basic " + token)
                        .body(new AddListOfBooksModel(userId, BOOK_LIST))
                        .when()
                        .post("/BookStore/v1/Books")
                        .then()
                        .spec(baseResponseSpec(201))
                        .extract().response());

        step("Отправка запроса на удаление книги \"Speaking JavaScript\"из коллекции", () ->
                given(baseRequestSpec)
                .header("authorization", "Basic " + token)
                        .body(new DeleteBookModel(userId, JS_BOOK_ISBN))
                        .when()
                        .delete("BookStore/v1/Book")
                        .then()
                        .spec(baseResponseSpec(204)));

        profilePage
                .cookieAuth(userId, expires, token)
                .openProfilePage()
                .profileUsernameVerification(AUTH_DATA.getUserName())
                .emptyUserCollectionVerification(JS_BOOK_NAME)
                .bookRemovalFromCollection();


    }
}
