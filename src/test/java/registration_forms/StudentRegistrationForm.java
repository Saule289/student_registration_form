package registration_forms;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("remote")

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void fillRegistrationForm() {

        String name = "Saule";
        String surName = "Zhan";
        String email = "test@mail.ru";
        String phoneNumber = "9999999999";
        String currentAddress = "Times Square Street, Block D, 175 apartment";
        File file = new File("src/test/resources/test.png");

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
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
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
        $(".modal-body").shouldHave(text("Computer Science"));
        $(".modal-body").shouldHave(text("28 September,1986"));
        $(".modal-body").shouldHave(text("test.png"));
        $(".modal-body").shouldHave(text(currentAddress));
        $(".modal-body").shouldHave(text("Haryana"));
        $(".modal-body").shouldHave(text("Karnal"));

    }
}


