package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    public void setDate (String day, String month, String year) {
        $(".react-datepicker__month-select").$(byText(month)).click();

        $(".react-datepicker__year-select").$(byText(year)).click();

        String dd = String.format("%02d", Integer.parseInt(day));

        $$(".react-datepicker__day--0" + dd + ":not(.react-datepicker__day--outside-month)")
                .first()
                .click();

    }
}
