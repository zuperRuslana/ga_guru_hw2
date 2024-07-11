package com.example.qa_guru_hw2.tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.internal.shadowed.jackson.databind.ser.Serializers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.example.qa_guru_hw2.tests.TestData.*;

public class registartionFormWithBaseTestTeast extends BaseTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen= true;
        Configuration.browserSize="1920x1808";
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        //$("practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //executeJavaScript("$('.ns-2xion-l-bannerA.ns-2xion-v-4').remove()");
        //executeJavaScript("$('#bannerA').remove()");

        // closePopUps();
        $("#firstName").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=userNumber]").setValue(phone);
        $(By.xpath("//label[@for='gender-radio-2']")).click();
        //driver.findElement(By.xpath("//div[@aria-label='Choose Thursday, November 26th, 1998']")).click();

        //$(By.xpath("//label[@for='Choose Thursday, November 26th, 1998']")).click();//idk
        //$("#dateOfBirthInput").scrollIntoView(false);
        //$("#dateOfBirthInput").sendKeys(Keys.BACK_SPACE);
        $("#dateOfBirthInput").click();
       $( ".react-datepicker__month-select").selectOption(month);
        $( ".react-datepicker__year-select").selectOption(year);
        $( ".react-datepicker__day--026"+ day).click();

        //$("#dateOfBirthInput").sendKeys("26 Nov 1998");
        //$(".subjects-auto-complete__control.css-yk16xz-control input").setValue("Computer Science");
        $("#subjectsInput").sendKeys("Computer Science");
        $("#subjectsInput").pressEnter();

        $(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
        //File file = new File("com/example/qa_guru_hw2/shiba.jpg");
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("[id=currentAddress]").setValue("This addy");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("[id=submit]").click();


       // $(".table-responsive table").shouldHave(text(firstName)), text(lastName),text((email)),text(day+" "+month+"," +year),
       // text(phone);

//                .shouldHave(text("Female"))
//                .shouldHave(text("6892337339"))
//                .shouldHave(text("26 November,1998"))
//                .shouldHave(text("Computer science"))
//                .shouldHave(text("Reading"))
//                .shouldHave(text("shiba.jpg"))
//                .shouldHave(text("Female"))
//                .shouldHave(text("This addy"))
//                .shouldHave(text("NCR Noida"));













        //private void closePopUps(){
        //    $("path[d='M0,0l15,0l0,15l-15,0Z']").click();
        // }
    }
}
