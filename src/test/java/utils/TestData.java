package utils;


import static utils.RandomTestDataUtils.*;

public class TestData {

    public String firstName = getFirstName();
    public String lastName = getLastName();
    public String userEmail = getUserEmail();
    public String gender = getGender();
    public String userNumber = getUserNumber();
    public String dateOfBirth[] = getBirthDateParts(14, 99);
    public String subjects = getSubjects();
    public String hobbies = getHobbies();
    public String profilePicture = getPicture();
    public String address = getUserAddress();
    public String state = getState();
    public String city = getCity(state);

}
