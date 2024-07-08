package com.example.qa_guru_hw2.tests;

import com.codeborne.selenide.Configuration;
import com.example.qa_guru_hw2.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class textBoxTestswObjects {
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
                    .setFirstName("Ruslana")
                    .setLastName("Sigalova")
                    .setEmail("lanasigalova@gmail.com")
                    .setGender("Female")
                    .setNumber("8906789090")
                    .setBirthday("26", "November", "1998")
                    .setAddress("This addy")
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
