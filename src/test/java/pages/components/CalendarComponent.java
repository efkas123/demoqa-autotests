package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private final SelenideElement
            reactMonthSelect = $(".react-datepicker__month-select"),
            reactYearSelect = $(".react-datepicker__year-select");

    public void setDate (String day, String month, String year) {
        reactMonthSelect.$(byText(month)).click();

        reactYearSelect.$(byText(year)).click();


        String dd = String.format("%02d", Integer.parseInt(day));

        $$(".react-datepicker__day--0" + dd + ":not(.react-datepicker__day--outside-month)")
                .first()
                .click();

    }
}
