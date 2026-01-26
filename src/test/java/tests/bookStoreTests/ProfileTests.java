package tests.bookStoreTests;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.TestData.AUTH_DATA;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BookStoreSpecs.baseRequestSpec;
import static specs.BookStoreSpecs.baseResponseSpec;

@Tag("upapi")
@DisplayName("Гибридные UI+API тесты на demoqa/bookstore")
public class ProfileTests {

    @Test
    @DisplayName("Удаление товара из списка через RestAPI")
    @Tag("uiapi")
    void successfulApiBookDeleteTest() {
        Response authResponse = step("Отправка запроса на авторизацию", () ->
                given(baseRequestSpec)
                        .body(AUTH_DATA)
                        .when()
                        .post("Account/v1/GenerateToken")
                        .then()
                        .spec(baseResponseSpec(100))
                        .extract().response());
    }
}
