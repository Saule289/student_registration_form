package registration_forms;


import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationFormWithPageObject extends TestBase {

    @Test
    void fillRegistrationForm() {

        String name = "Saule";
        String surName = "Zhan";
        String email = "test@mail.ru";
        String gender = "Female";
        String phoneNumber = "9999999999";
        String currentAddress = "Times Square Street, Block D, 175 apartment";
        String subject = "Computer Science";

        registrationPage
                .openPage()
                .setFirstName(name)
                .setLastName(surName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate("28", "September", "1986")
                .setSubjects(subject)
                .setHobbies()
                .upLoadPicture()
                .setAddress(currentAddress)
                .setState()
                .setCity()
                .submit()
                .verifyResultsModalAppears()
                .verifyResults("Student Name", name + " " + surName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", "28 September,1986")
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", "Sports, Reading, Music")
                .verifyResults("Picture", "test.png")
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", "Haryana" + " " + "Karnal");

    }
}


