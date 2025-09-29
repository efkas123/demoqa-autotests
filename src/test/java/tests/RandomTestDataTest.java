package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitResultsComponent;
import utils.TestData;

import static utils.RandomTestDataUtils.*;

public class RandomTestDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitResultsComponent registrationResults = new SubmitResultsComponent();
    TestData random = new TestData();



    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.userEmail)
                .setGender(random.gender)
                .setUserNumber(random.userNumber)
                .setDateOfBirth(random.dateOfBirth[0], random.dateOfBirth[1], random.dateOfBirth[2])
                .setSubjects(random.subjects)
                .setHobbies(random.hobbies)
                .setProfilePicture(random.profilePicture)
                .setAddress(random.address)
                .setStateAndCity(random.state,random.city)
                .clickSubmit();

        //Проверка значений
        registrationResults
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", random.firstName +  " " + random.lastName)
                .checkFormResults("Student Email", random.userEmail)
                .checkFormResults("Gender", random.gender)
                .checkFormResults("Mobile", random.userNumber)
                .checkFormResults("Date of Birth", (random.dateOfBirth[0] + " " + random.dateOfBirth[1] + "," + random.dateOfBirth[2]))
                .checkFormResults("Subjects", random.subjects)
                .checkFormResults("Hobbies", random.hobbies)
                .checkFormResults("Picture", random.profilePicture)
                .checkFormResults("Address", random.address)
                .checkFormResults("State and City", (random.state + " " + random.city));
    }

    @Test
    void minimalFillFormTest(){
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setGender(random.gender)
                .setUserNumber(random.userNumber)
                .clickSubmit();

        registrationResults
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", random.firstName +  " " + random.lastName)
                .checkFormResults("Gender", random.gender)
                .checkFormResults("Mobile", random.userNumber);
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
