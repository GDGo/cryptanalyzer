package com.javarush.cryptanalyzer.goncharov.services;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptanalyzer.goncharov.constants.CryptoAlphabet.*;

public class UtilsFunc {

    static Scanner in = new Scanner(System.in);

    public static int getInputMode(String message){
        String input;
        while (true){
            System.out.println(message);
            input = in.nextLine();
            if (input.equals("1") || input.equals("2")){
                return Integer.parseInt(input);
            } else if (input.equals("End".toLowerCase())) {
                close();
            } else {
                System.out.println(MESSAGE_REPEAT);
            }
        }
    }

    public static void close(){
        System.exit(0);
    }

    public static int getRandomKey(){
        int key = ThreadLocalRandom.current().nextInt(0, ALPHABET_LENGTH + 1);
        System.out.println(MESSAGE_KEY_GENERATED + key);
        return key;
    }

    public static int getShiftKey(String message){
        String input;
        while (true){
            System.out.println(message);
            input = in.nextLine();
            if (input.equals("")){
                return getRandomKey();
            } else if (Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= ALPHABET_LENGTH) {
                return Integer.parseInt(input);
            } else {
                System.out.printf("Вы можете использовать числа от 1 до %d. \n", ALPHABET_LENGTH);
            }
        }
    }
}
