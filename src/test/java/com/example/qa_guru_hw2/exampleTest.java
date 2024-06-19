package com.example.qa_guru_hw2;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

public class exampleTest {
    @BeforeAll
    static void beforeAllTests() {
        //open ("ya.ru");
        System.out.println("### @BeforeAll");
    }
    @AfterAll
    static void afterAllTests(){
        System.out.println("### @AfterAll");
    }
    @Test
    void simpTest() {
        System.out.println("### @Test simpTest");

    }

}
