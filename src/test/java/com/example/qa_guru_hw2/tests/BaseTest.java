package com.example.qa_guru_hw2.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
     String firstName="Lana", lastName="Sigalova", email="lanasig@gmail.com", day="26", month="11", year="1998",phone="6892337339";

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen= true;
        Configuration.browserSize="1920x1808";
    }
}
