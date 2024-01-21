package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.DataPickerComponent;
import pages.components.ModalResponviseComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNubmerInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressForm = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            submitButton = $("#submit"),
            calenderInput = $("#dateOfBirthInput"),
            tableResponsive = $(".table-responsive");

    DataPickerComponent dataPickerComponent = new DataPickerComponent();
    ModalResponviseComponent modalResponviseComponent = new ModalResponviseComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNubmer(String value) {
        userNubmerInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        subjectInput.setValue(value).sendKeys(Keys.ENTER);

        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAddress(String valeu) {
        currentAddressForm.setValue(valeu);

        return this;
    }

    public RegistrationPage setState(String value) {
        selectState.setValue(value).sendKeys(Keys.ENTER);

        return this;
    }

    public RegistrationPage setCity(String value) {
        selectCity.setValue(value).sendKeys(Keys.ENTER);

        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calenderInput.click();
        dataPickerComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkResultResponsive(String key, String valeu) {
        tableResponsive.shouldBe(visible);
        modalResponviseComponent.checkResult(key, valeu);

        return this;
    }

    public RegistrationPage validationMatching(String key, String valeu) {
        firstNameInput.shouldBe(cssValue(key, valeu));
        lastNameInput.shouldBe(cssValue(key, valeu));
        userNubmerInput.shouldBe(cssValue(key, valeu));
        $("label[for='gender-radio-1']").shouldBe(cssValue(key, valeu));
        $("label[for='gender-radio-2']").shouldBe(cssValue(key, valeu));
        $("label[for='gender-radio-1']").shouldBe(cssValue(key, valeu));

        return this;
    }
}

