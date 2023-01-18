package pages;

import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Student Registration Form";

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("h5").shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies() {
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        return this;
    }

     public RegistrationPage upLoadPicture() {
         $("#uploadPicture").uploadFromClasspath("test.png");

        return this;
    }

    public RegistrationPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }

    public RegistrationPage setState() {
        $("#state").click();
        $("#state").$(byText("Haryana")).click();

        return this;
    }

    public RegistrationPage setCity() {
        $("#city").click();
        $("#city").$(byText("Karnal")).click();

        return this;
    }

    public RegistrationPage submit() {
        $("#submit").click();

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
      registrationResultsModal.verifyModalVisible();

        return this;
    }
    public RegistrationPage verifyResults(String key, String value) {
        registrationResultsModal.verifyResults(key, value);

        return this;
    }
}
