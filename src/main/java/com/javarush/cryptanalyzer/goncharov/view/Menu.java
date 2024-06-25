package com.javarush.cryptanalyzer.goncharov.view;

import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptanalyzer.goncharov.services.UtilsFunc.getInputMode;
import static com.javarush.cryptanalyzer.goncharov.view.BruteForce.brute;
import static com.javarush.cryptanalyzer.goncharov.view.Decode.decode;
import static com.javarush.cryptanalyzer.goncharov.view.Encode.encode;

public class Menu {
    public static void run(){
        printMainMenu();
        int startValue = getInputMode(INPUT_MODE);
        switch (startValue){
            case 1 -> encode();
            case 2 -> decode();
            case 3 -> brute();
        }
    }

    private static void printMainMenu(){
        System.out.println(DESCRIPTION_SERVICE);
    }
}