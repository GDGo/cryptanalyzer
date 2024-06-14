package com.javarush.cryptanalyzer.goncharov.view;

import com.javarush.cryptanalyzer.goncharov.exception.ApplicationException;

import java.io.*;

import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptanalyzer.goncharov.constants.CryptoAlphabet.ALPHABET;
import static com.javarush.cryptanalyzer.goncharov.services.PathUtilsFunc.*;
import static com.javarush.cryptanalyzer.goncharov.services.UtilsFunc.*;

public class Encode {
    public static void encode(){
        int key = getShiftKey(MESSAGE_KEY);
        String inputFile = getInputFileEncode(MESSAGE_IN);
        String outputFileFile = getOutputFileEncode(MESSAGE_OUT);

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileFile))){

            while (reader.ready()){
                writer.write(encodeText(reader.readLine(), key));
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            throw new ApplicationException(MESSAGE_ERROR_ENCODE, e);
        }
        System.out.println(SUCCESS);
    }

    private static String encodeText(String string, int shift){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            builder.append(symbolRightShift(string.charAt(i), shift));
        }
        return builder.toString();
    }

    private static char symbolRightShift(char symbol, int shift){
        if (ALPHABET.indexOf(symbol) != -1){
            return ALPHABET.charAt((ALPHABET.indexOf(symbol) + shift) % ALPHABET.length());
        } else {
            return symbol;
        }
    }
}
