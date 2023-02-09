package registration_forms;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.components.CityChoiceAsPerState;

import java.util.Optional;

import static pages.components.CityChoiceAsPerState.cityList;

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

        registrationPage
                .openPage()
                .setFirstName(name)
                .setLastName(surName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobby)
                .upLoadPicture()
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit()
                .verifyResultsModalAppears()
                .verifyResults("Student Name", name + " " + surName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", day + " " + month + "," + year)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", "test.png")
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city);

    }


}