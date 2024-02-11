package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormWithJavaFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setPhoneNumber(testData.userPhoneNumber)
                .setDateOfBirth(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .setUserSubjects(testData.usersubjects)
                .setUserHobbies(testData.userHobbies)
                .uploadPicture("kek.png")
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.randomState)
                .setCity(testData.randomCity)
                .clickSubmitButton();

        registrationPage.checkResultResponsive("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultResponsive("Student Email", testData.userEmail)
                .checkResultResponsive("Gender", testData.userGender)
                .checkResultResponsive("Mobile", testData.userPhoneNumber)
                .checkResultResponsive("Date of Birth", testData.setDayRandom + " " + testData.monthRandom + "," + testData.yearRandom)
                .checkResultResponsive("Subjects", testData.usersubjects)
                .checkResultResponsive("Hobbies", testData.userHobbies)
                .checkResultResponsive("Picture", "kek.png")
                .checkResultResponsive("Address", testData.currentAddress)
                .checkResultResponsive("State and City", testData.randomState + " " + testData.randomCity);
    }

    @Test
    void minimalDataforRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setPhoneNumber(testData.userPhoneNumber)
                .clickSubmitButton();

        registrationPage.checkResultResponsive("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultResponsive("Gender", testData.userGender)
                .checkResultResponsive("Mobile", testData.userPhoneNumber);
    }

    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .clickSubmitButton()
                .validationMatching("border-color", "rgb(220, 53, 69)");
    }
}


