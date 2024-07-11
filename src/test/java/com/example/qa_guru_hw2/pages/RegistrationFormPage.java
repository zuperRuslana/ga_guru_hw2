package com.example.qa_guru_hw2.pages;
import com.codeborne.selenide.SelenideElement;
import com.example.qa_guru_hw2.pages.Components.CalendarComponents;
import com.example.qa_guru_hw2.pages.Components.ResultTable;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationFormPage {
    //Elements
    private CalendarComponents calendarComponents = new CalendarComponents();
    private ResultTable resultTable = new ResultTable();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderRadio = $("genterWrapper"),
            userNumber=$("#userNumber"),
            dateOfBirthInput=$("#dateOfBirthInput"),
            currentAddres= $("#currentAddress"),
            subjectsInput=$("subjectsInput");

    private final static String titleText = "Thanks for submitting the form";

    //Actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");

        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //  executeJavaScript("$('.ns-2xion-l-bannerA.ns-2xion-v-4').remove()");
        //executeJavaScript("$('#bannerA').remove()");
        executeJavaScript("document.getElementById('google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0').remove();");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
       firstNameInput.setValue(value);
        return this;
    }

    public void clearFirstName() {
        firstNameInput.clear();

    }

    public void clearLN() {
        lastNameInput.clear();
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
       genderRadio.$(byText(value)).click();
        return this;

    }

    public RegistrationFormPage setNumber(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthday(String day, String month, String year) {
        closeAdIfPresent();
        dateOfBirthInput.click();
        calendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setAddress(String value){
        currentAddres.setValue(value);
        return this;
    }

    public RegistrationFormPage setSubject(String value){
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();
        return this;
    }
    public RegistrationFormPage setHobby(String value){
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage uploadPic(String path){
        $("#uploadPicture").uploadFromClasspath(path);
        return this;

    }

    public RegistrationFormPage setLocation(String state, String city){
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }


    public RegistrationFormPage resultTableCheck() {
        resultTable.isVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultTable.checkResult(key, value);
        return this;
    }
    private void closeAdIfPresent() {
        // Switch to the iframe and close it if present
        if ($(byCssSelector("iframe[id^='google_ads_iframe']")).exists()) {
            switchTo().frame($(byCssSelector("iframe[id^='google_ads_iframe']")));
            // Add the logic to close the ad if possible, for example:
            if ($("button.close-ad").exists()) {
                $("button.close-ad").click();
            }
            switchTo().defaultContent(); // Switch back to the main content
        }
    }
}

