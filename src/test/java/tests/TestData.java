package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import static utils.RandomUtils.*;

public class TestData {


    Faker faker = new Faker();
    RandomUtils randomUtils = new RandomUtils();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = getRandomGender(),
            userPhoneNubmer = faker.phoneNumber().subscriberNumber(10),
            dayRandom = Integer.toString(getRandomInt(10, 20)),
            monthRandom = getRandomMonth(),
            yearRandom = Integer.toString((getRandomInt(1940, 2005))),
            usersubjects = getRandomSubjects(),
            userHobbies = getRandomHobbies(),
            currentAddress = faker.address().fullAddress(),
            randomState = getRandomState(),
            randomCity = randomUtils.getRandomCity(getRandomState());
}

