package com.javarush.cryptanalyzer.goncharov.view;

import com.javarush.cryptanalyzer.goncharov.exception.ApplicationException;

import java.io.*;

import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.MESSAGE_ERROR_ENCODE;
import static com.javarush.cryptanalyzer.goncharov.constants.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptanalyzer.goncharov.services.PathUtilsFunc.*;
import static com.javarush.cryptanalyzer.goncharov.services.UtilsFunc.getShiftKey;

public class Decode {
    public static void decode(){
        int key = getShiftKey(MESSAGE_KEY);
        String inputFile = getInputFileDecode(MESSAGE_OUT);
        String outputFileFile = getOutputFileDecode(MESSAGEIN_ENCODED);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileFile))){

            while (reader.ready()){
                writer.write(encodeText(reader.readLine(), key));
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            throw new ApplicationException(MESSAGE_ERROR_DECODE, e);
        }
        System.out.println(SUCCESS);
    }

    private static String encodeText(String string, int shift){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            builder.append(symbolDecode(string.charAt(i), shift));
        }
        return builder.toString();
    }

    private static char symbolDecode(char symbol, int shift) {
        if (ALPHABET.indexOf(symbol) != -1) {
            if (ALPHABET.indexOf(symbol) - shift >= 0) {
                return ALPHABET.charAt((ALPHABET.indexOf(symbol) - shift) % ALPHABET.length());
            } else {
                return ALPHABET.charAt(ALPHABET.length() + (ALPHABET.indexOf(symbol) - shift) % ALPHABET.length());
            }
        } else {
            return symbol;
        }
    }
}
