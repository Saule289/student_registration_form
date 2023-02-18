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
import static io.qameta.allure.Allure.step;

@Tag("remote")

public class StudentRegistrationForm extends TestBase {

    @Test
    void fillRegistrationForm() {

        String name = "Saule";
        String surName = "Zhan";
        String email = "test@mail.ru";
        String phoneNumber = "9999999999";
        String currentAddress = "Times Square Street, Block D, 175 apartment";
        File file = new File("src/test/resources/test.png");

        step("Открываем главную страницу", () -> {
            open("/automation-practice-form");

            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Проверяем название страницы", () -> {
            $("h5").shouldHave(text("Student Registration Form"));
        });

        step("Вводим имя", () -> {
            $("#firstName").setValue(name);
        });

        step("Вводим фамилию", () -> {
            $("#lastName").setValue(surName);
        });

        step("Вводим email", () -> {
            $("#userEmail").setValue(email);
        });

        step("Выбираем пол", () -> {
            $(byText("Female")).click();
        });

        step("Вводим номер телефона", () -> {
            $("#userNumber").setValue(phoneNumber);
        });

        step("Указываем даты рождения", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__year-select").selectOption("1986");
            $(".react-datepicker__month-select").selectOption("September");
            $(".react-datepicker__day--028").click();
        });

        step("Выбираем предмет изучения", () -> {
            $("#subjectsContainer").click();

            $("#subjectsInput").setValue("Computer Science").pressEnter();
        });

        step("Выбираем хобби", () -> {
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            $("#hobbiesWrapper").$(byText("Music")).click();
        });
        step("Загружаем фото", () -> {
            $("#uploadPicture").uploadFile(file);
        });

        step("Указаываем адрес", () -> {
            $("#currentAddress").setValue(currentAddress);
        });

        step("Выбираем штат", () -> {
            $("#state").click();
            $("#state").$(byText("Haryana")).click();
        });

        step("Выбираем город", () -> {
            $("#city").click();
            $("#city").$(byText("Karnal")).click();
        });
        step("Отправляем форму регистрации", () -> {
            $("#submit").click();
        });

        step("Проверяем имя и фамилию студента", () -> {
            $(".modal-content").shouldBe(visible);
        });

        step("Проверяем имя и фамилию студента", () ->

        {
            $(".modal-body").shouldHave(text(name));
            $(".modal-body").shouldHave(text(surName));

        });
        step("Проверяем  email", () -> {

            $(".modal-body").shouldHave(text(email));
        });

        step("Проверяем  пол", () -> {
            $(".modal-body").shouldHave(text("female"));
        });
        step("Проверяем  номер телефона", () -> {
            $(".modal-body").shouldHave(text(phoneNumber));
        });
        step("Проверяем  предмет изучения", () -> {
            $(".modal-body").shouldHave(text("Sports, Reading, Music"));

        });
        step("Проверяем  хобби", () -> {
            $(".modal-body").shouldHave(text("Computer Science"));
        });

        step("Проверяем  даты рождения", () -> {
            $(".modal-body").shouldHave(text("28 September,1986"));
        });

        step("Проверяем  фото", () -> {
            $(".modal-body").shouldHave(text("test.png"));
        });
        step("Проверяем адрес", () -> {
            $(".modal-body").shouldHave(text(currentAddress));
        });
        step("Проверяем выбранный штат и город", () -> {
            $(".modal-body").shouldHave(text("Haryana"));
            $(".modal-body").shouldHave(text("Karnal"));
        });
    }
}


