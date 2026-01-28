package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ProfilePage {
    SelenideElement
        userName = $("#userName-value"),
        booksTable = $(".rt-table"),
        deleteBook = $("#delete-record-undefined"),
        okDeleteBookButton = $("#closeSmallModal-ok"),
        deleteAllBooksButton = $$("button#submit").findBy(text("Delete All Books"));

    @Step("Авторизация через Cookie")
    public ProfilePage cookieAuth(String userId, String expires, String token) {
        open("/images/Toolsqa.jpg");
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
        getWebDriver().manage().addCookie(new Cookie("expires", expires));
        getWebDriver().manage().addCookie(new Cookie("token", token));
        return this;
    }

    @Step("Открытие страницы профиля пользователя")
    public ProfilePage openProfilePage() {
        open("/profile");
        return this;
    }

    @Step("Верификация завяленного пользователя")
    public ProfilePage profileUsernameVerification(String user){
        userName.shouldHave(text(user));
        return this;
    }

    @Step("Верификация отсутствия книг в коллекции пользователя")
    public ProfilePage emptyUserCollectionVerification(String title){
        booksTable.shouldNotBe(text(title));
        return this;
    }

    @Step("Удаление книги из коллекции пользователя")
    public ProfilePage bookRemovalFromCollection(){
        deleteBook.click();
        okDeleteBookButton.click();
        return this;
    }

    @Step("Удаление всех книг из коллекции")
    public ProfilePage deleteAllBooksFromCollection(){
        deleteAllBooksButton.click();
        return  this;
    }




}
