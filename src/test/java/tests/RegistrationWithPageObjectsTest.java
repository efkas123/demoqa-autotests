package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitResultsComponent;

public class RegistrationWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitResultsComponent registrationResults = new SubmitResultsComponent();

    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName("Filipp")
                .setLastName("Kotov")
                .setEmail("hello@yandex.ru")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("13","January","2002")
                .setSubjects("Arts")
                .setHobbies("Sports","Reading","Music")
                .setProfilePicture("YoshiSittingThere.jpg")
                .setAddress("Krasnodar")
                .setStateAndCity("Haryana","Karnal")
                .clickSubmit();

        //Проверка значений
        registrationResults
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", "Filipp Kotov")
                .checkFormResults("Student Email", "hello@yandex.ru")
                .checkFormResults("Gender", "Male")
                .checkFormResults("Mobile", "1234567890")
                .checkFormResults("Date of Birth", "13 January,2002")
                .checkFormResults("Subjects", "Arts")
                .checkFormResults("Hobbies", "Sports, Reading, Music")
                .checkFormResults("Picture", "YoshiSittingThere.jpg")
                .checkFormResults("Address", "Krasnodar")
                .checkFormResults("State and City", "Haryana Karnal");
    }

    @Test
    void minimalFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName("Filipp")
                .setLastName("Kotov")
                .setGender("Male")
                .setUserNumber("1234567890")
                .clickSubmit();

        registrationResults
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", "Filipp Kotov")
                .checkFormResults("Gender", "Male")
                .checkFormResults("Mobile", "1234567890");
    }

    @Test
    void negativeFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .clickSubmit();

        registrationResults
                .checkFormNotVisible();
    }

}
