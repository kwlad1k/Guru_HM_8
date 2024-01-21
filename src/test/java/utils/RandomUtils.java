package utils;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;


public class RandomUtils {
    Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomSubjects() {
        String[] genders = {"English", "Chemistry", "Computer Science",
                "Commerce", "Economics", "Social Studies", "Arts", "History",
                "Maths", "Accounting", "Social Studies"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomHobbies() {
        String[] genders = {"Sports", "Reading", "Music"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomMonth() {
        String[] genders = {"Januaray", "February", "March",
                "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int index = getRandomInt(0, state.length - 1);
        return state[index];
    }

    public String getRandomCity(String value) {
        String city = new String();
        switch (value) {
            case "NCR":
                city = faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                city = faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                city = faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                city = faker.options().option("Jaipur", "Jaiselmer");
        }
        return city;
    }

}