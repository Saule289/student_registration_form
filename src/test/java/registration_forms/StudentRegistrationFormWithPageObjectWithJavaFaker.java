package registration_forms;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static io.qameta.allure.Allure.step;
import static pages.components.CityChoiceAsPerState.cityList;

@Tag("remote")
public class StudentRegistrationFormWithPageObjectWithJavaFaker extends TestBase {


    @Test
    void fillRegistrationForm() {

        Faker faker = new Faker();

        String name = faker.name().firstName();
        String surName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = faker.demographic().sex();
        String phoneNumber = faker.phoneNumber().subscriberNumber(10);
        String day = String.format("%02d", faker.number().numberBetween(1, 28));
        String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        String year = faker.number().numberBetween(1900, 2015) + "";
        String subject = faker.options().option("Computer Science", "Civics", "Math", "Physics",
                "Hindi", "Accounting", "Arts", "Social Studies", "Biology", "Chemistry", "History",
                "English", "Economics", "Commerce");
        String hobby = faker.options().option("Reading", "Sports", "Music");
        String currentAddress = faker.address().streetAddress();
        String state = faker.options().option("NCR", "Haryana", "Uttar Pradesh", "Rajasthan");
        String city = cityList(state);

         step("Открываем главную страницу", () -> {
            registrationPage.openPage();
        });

        step("Вводим имя", () -> {
                registrationPage.setFirstName(name);
        });

        step("Вводим фамилию", () -> {
            registrationPage.setLastName(surName);
        });

        step("Вводим email", () -> {
            registrationPage.setEmail(email);
        });

        step("Выбираем пол", () -> {
            registrationPage.setGender(gender);
        });

        step("Вводим номер телефона", () -> {
            registrationPage.setPhoneNumber(phoneNumber);
        });

        step("Указываем даты рождения", () -> {
            registrationPage.setBirthDate(day, month, year);
        });
        step("Выбираем предмет изучения", () -> {
            registrationPage.setSubjects(subject);
        });
        step("Выбираем хобби", () -> {
            registrationPage.setHobbies(hobby);
        });
        step("Загружаем фото", () -> {
            registrationPage.upLoadPicture();
        });

        step("Указаываем адрес", () -> {
            registrationPage.setAddress(currentAddress);
        });

        step("Выбираем штат", () -> {
            registrationPage.setState(state);
        });

        step("Выбираем город", () -> {
            registrationPage.setCity(city);
        });

        step("Отправляем форму регистрации", () -> {
            registrationPage.submit();
        });

        step("Проверяем появление модального окна с данными студента", () -> {
            registrationPage.verifyResultsModalAppears();
        });

        step("Проверяем имя и фамилию студента", () -> {
            registrationPage.verifyResults("Student Name", name + " " + surName);
        });

        step("Проверяем  email", () -> {
            registrationPage.verifyResults("Student Email", email);
        });

        step("Проверяем  пол", () -> {
            registrationPage.verifyResults("Gender", gender);
        });

        step("Проверяем  номер телефона", () -> {
            registrationPage.verifyResults("Mobile", phoneNumber);
        });

        step("Проверяем  даты рождения", () -> {
            registrationPage.verifyResults("Date of Birth", day + " " + month + "," + year);
        });
        step("Проверяем  предмет изучения", () -> {
            registrationPage.verifyResults("Subjects", subject);
        });
        step("Проверяем  хобби", () -> {
            registrationPage .verifyResults("Hobbies", hobby);
        });
        step("Проверяем  фото", () -> {
            registrationPage.verifyResults("Picture", "test.png");
        });

        step("Проверяем адрес", () -> {
            registrationPage.verifyResults("Address", currentAddress);
        });

        step("Проверяем выбранный штат и город", () -> {
            registrationPage.verifyResults("State and City", state + " " + city);
        });
    }

}