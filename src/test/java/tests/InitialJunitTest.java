import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class InitialJunitTest {

    @Test
    void firstTest() {
        System.out.println("first test");
        Assertions.assertTrue(3>2);
    }

    @Test
    void secondTest() {
        System.out.println("second test");
        Assertions.assertTrue(3>2);
    }

    @Test
    void thirdTest() {
        System.out.println("third test");
        Assertions.assertTrue(3>2);
    }
}
