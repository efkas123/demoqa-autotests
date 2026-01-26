package data;

import models.IsbnModel;
import models.LoginBodyModel;

import java.util.List;

public class TestData {

    protected static String userName = System.getProperty("userName", "filippkotov6669"); //todo
    protected static String password = System.getProperty("password", "Filippkotov6669%"); //todo


    public static final LoginBodyModel AUTH_DATA = new LoginBodyModel(userName, password);

    public static final String
        JS_BOOK_ISBN = "9781449365035",
        JS_BOOK_NAME = "Speaking JavaScript";

    public static final List<IsbnModel> BOOK_LIST = List.of(new IsbnModel(JS_BOOK_ISBN));
}
