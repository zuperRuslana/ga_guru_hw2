package com.example.qa_guru_hw2.pages.Components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTable {
    private final static String titleText="Thanks for submitting the form";

    public ResultTable isVisible(){
        $(".modal-content").should(appear);
        $(".modal-content").shouldHave(text(titleText));
    return this;

    }
    public ResultTable checkResult(String key, String value){
        $(".table-responsive table").$(byText(key))
                .parent().shouldHave(text(value));
    return this;
    }
}
