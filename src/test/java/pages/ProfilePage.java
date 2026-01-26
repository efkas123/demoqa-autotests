package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    SelenideElement
        userName = $("#userName-value"),
        booksTable = $(".rt-body"),
        deleteBook = $("#delete-record-undefined"),
        okDeleteBookButton = $("#closeSmallModal-ok");



}
