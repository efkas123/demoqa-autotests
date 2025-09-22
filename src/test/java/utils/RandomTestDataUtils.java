package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomTestDataUtils {

    public static Faker faker = new Faker();

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getUserEmail(){
        return faker.internet().emailAddress();
    }

    public static String getGender(){
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getUserNumber(){
        return faker.number().digits(10);
    }

    //Генерируем массив с нужными нам значениями даты через Faker
    public static String[] getBirthDateParts(int minAge, int maxAge){
        Date d = faker.date().birthday(minAge,maxAge);
        String day = new SimpleDateFormat("d", Locale.ENGLISH).format(d);
        String month = new SimpleDateFormat("MMMM", Locale.ENGLISH).format(d);
        String year = new SimpleDateFormat("yyyy", Locale.ENGLISH).format(d);
        return new String[] { day, month, year };
    }

    public static String getSubjects(){
        return faker.options().option("Maths","Accounting","Arts","Social Studies","Physics","Chemistry",
                "Computer Science","Commerce","Economics","Civics","English","Hindi","Biology","History");
    }

    public static String getHobbies(){
        return faker.options().option("Sports", "Reading","Music");
    }

    public static String getPicture(){
        return faker.options().option(
            "YoshiSittingThere.jpg",
                    "F1.jpg",
                    "5090.png");
    }

    public static String getUserAddress(){
        return faker.address().streetAddress();
    }

    public static String getState(){
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public static String getCity(String state){
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon","Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow","Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException(state);
        };
    }


}
