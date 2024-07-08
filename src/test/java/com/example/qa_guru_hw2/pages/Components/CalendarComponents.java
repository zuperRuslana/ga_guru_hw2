package com.example.qa_guru_hw2.pages.Components;

import com.example.qa_guru_hw2.pages.RegistrationFormPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
        public CalendarComponents setDate(String day, String month, String year){
            $( ".react-datepicker__month-select").selectOption(month);
            $( ".react-datepicker__year-select").selectOption(year);
            $(byText(day)).click();
            //     $( ".react-datepicker__day--026"+day).click();
            return this;
        }
    }
