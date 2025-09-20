package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubmitResultsComponent {
    private SelenideElement
            resultTitle = $("#example-modal-sizes-title-lg"),
            tableResponsive = $(".table-responsive");

    public SubmitResultsComponent checkFormVisible(String title){
        resultTitle.shouldBe(visible).shouldHave(text(title));
        tableResponsive.scrollTo();
        return this;
    }

    public SubmitResultsComponent checkFormResults(String key, String value){
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public SubmitResultsComponent checkFormNotVisible(){
        resultTitle.shouldNotBe(visible);
        return this;
    }
}

