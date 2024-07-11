package com.example.qa_guru_hw2.tests;

import com.codeborne.selenide.Configuration;
import com.example.qa_guru_hw2.pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.example.qa_guru_hw2.utils.RandomUtils.getRandomEmail;
import static com.example.qa_guru_hw2.utils.RandomUtils.getRandomString;

public class registrationFormWithFakerDataTest {
    Faker faker= new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
    addy=faker.address().fullAddress(),
    phone=faker.phoneNumber().phoneNumber();

    String day="26";
    String month="11";
    String year="1998";
    //String phone="6892337339";

        RegistrationFormPage registrationFormPage= new RegistrationFormPage();

        @BeforeAll
        static void setUp(){
            Configuration.baseUrl="https://demoqa.com";
            Configuration.holdBrowserOpen= true;
            Configuration.browserSize="1920x1808";
        }
        @Test
        void fillFormTest() {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender("Female")
                    .setNumber(phone)
                    .setBirthday("26", "November", "1998")
                    .setAddress(addy)
                    .setSubject("Computer Science")
                    .setHobby("Reading")
                    .uploadPic("img/1.png")
                    .setLocation("NCR", "Noida");
            $("#submit").click();

            registrationFormPage.resultTableCheck()
                    .checkResult("Student Name", "Ruslana Sigalova")
                    .checkResult("Student Email", "lanasigalova@gmail.com")
                    .checkResult("Date of Birth", "26 November,1998")
                    .checkResult("Subjects", "Computer Science")
                    .checkResult("Hobbies", "Reading")
                    .checkResult("Picture", "1.png")
                    .checkResult("Address", "This addy")
                    .checkResult("State and City", "NCR Noida");
        }
    }
