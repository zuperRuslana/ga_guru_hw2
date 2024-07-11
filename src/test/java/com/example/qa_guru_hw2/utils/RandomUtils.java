package com.example.qa_guru_hw2.utils;

import java.util.Random;

public class RandomUtils {
    public static String getRandomString(int length){
        String SALTCHAR="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result= new StringBuilder();
        Random rand= new Random();
        while (result.length()<length){
            int index=(int)(rand.nextFloat()+SALTCHAR.length());
            result.append(SALTCHAR.charAt(index));
        }
return result.toString();
    }
    public static String getRandomEmail(){
        return getRandomString(10)+"gmail.com";
    }
}
