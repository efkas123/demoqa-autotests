package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.SubmitResultsComponent;

import static utils.RandomTestDataUtils.*;

public class RandomTestDataTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    SubmitResultsComponent registrationResults = new SubmitResultsComponent();


    String
            firstName = getFirstName(),
            lastName = getLastName(),
            userEmail = getUserEmail(),
            gender = getGender(),
            userNumber = getUserNumber(),
            dateOfBirth[] = getBirthDateParts(14, 99),
            subjects = getSubjects(),
            hobbies = getHobbies(),
            profilePicture = getPicture(),
            address = getUserAddress(),
            state = getState(),
            city = getCity(state);

    @Test
    void fullFillFormTest() {
        registrationPage
                .openPage()
                .deleteAdds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(dateOfBirth[0], dateOfBirth[1], dateOfBirth[2])
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setProfilePicture(profilePicture)
                .setAddress(address)
                .setStateAndCity(state,city)
                .clickSubmit();

        //Проверка значений
        registrationResults
                .checkFormVisible("Thanks for submitting the form")
                .checkFormResults("Student Name", firstName)
                .checkFormResults("Student Email", userEmail)
                .checkFormResults("Gender", gender)
                .checkFormResults("Mobile", userNumber)
                .checkFormResults("Date of Birth", (dateOfBirth[0] + " " + dateOfBirth[1] + "," + dateOfBirth[2]))
                .checkFormResults("Subjects", subjects)
                .checkFormResults("Hobbies", hobbies)
                .checkFormResults("Picture", profilePicture)
                .checkFormResults("Address", address)
                .checkFormResults("State and City", (state + " " + city));
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
