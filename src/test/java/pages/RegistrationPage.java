package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement
            firstName = $("#firstName"),
            lastName  = $("#lastName"),
            userEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            calendarInput = $("#dateOfBirthIbput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("uploadPicture"),
            currentAddress = $("currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submit = $("#submit");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage deleteAdds(){
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String gender){
        genderWrapper.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String number){
        userNumber.setValue(number);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year){
        calendarInput.click();
        CalendarComponent calendar = new CalendarComponent();
        calendar.setDate(day,month,year);
        return this;
    }

    public RegistrationPage setSubjects(String subjects){
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbiesOne, String hobbiesTwo,  String hobbiesThree){
        hobbiesWrapper.$(byText(hobbiesOne)).click();
        hobbiesWrapper.$(byText(hobbiesTwo)).click();
        hobbiesWrapper.$(byText(hobbiesThree)).click();
        return this;
    }

    public RegistrationPage setProfilePicture(String fileName){
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage setAddress(String adress){
        currentAddress.setValue(adress);
        return this;
    }

    public RegistrationPage setStateAndCity(String state, String city){
        stateInput.setValue(state).pressEnter();
        cityInput.setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage clickSubmit(){
        submit.click();
        return this;
    }



}
