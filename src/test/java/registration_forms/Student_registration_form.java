package registration_forms;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Student_registration_form {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillRegistrationForm() {

        String name = "Saule";
        String surName = "Zhan";
        String email = "test@mail.ru";
        String phoneNumber = "9999999999";
        String currentAddress = "Times Square Street, Block D, 175 apartment";
        File file = new File("src/test.png");

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("h5").shouldHave(text("Student Registration Form"));
        $("#firstName").setValue(name);
        $("#lastName").setValue(surName);
        $("#userEmail").setValue(email);
        $(byText("Female")).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1986");
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__day--028").click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText("Haryana")).click();
        $("#city").click();
        $("#city").$(byText("Karnal")).click();
        $("#submit").click();
        $(".modal-content").shouldBe(visible);
        $(".modal-body").shouldHave(text(name));
        $(".modal-body").shouldHave(text(surName));
        $(".modal-body").shouldHave(text(email));
        $(".modal-body").shouldHave(text("female"));
        $(".modal-body").shouldHave(text(phoneNumber));
        $(".modal-body").shouldHave(text("Sports, Reading, Music"));





        sleep(5000);
    }
}


