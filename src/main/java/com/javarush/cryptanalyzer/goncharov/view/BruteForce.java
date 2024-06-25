package com.javarush.cryptanalyzer.goncharov.view;

import com.javarush.cryptanalyzer.goncharov.exception.ApplicationException;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptanalyzer.goncharov.constants.ApplicationCompletionConstants.SUCCESS;
import static com.javarush.cryptanalyzer.goncharov.constants.CryptoAlphabet.ALPHABET_LENGTH;
import static com.javarush.cryptanalyzer.goncharov.services.PathUtilsFunc.getInputFileDecode;
import static com.javarush.cryptanalyzer.goncharov.services.PathUtilsFunc.getOutputFileDecode;

public class BruteForce{

    private static final String REGEX = "^([а-яА-Я]+(\\s|,\\s|:\\s|;\\s|-\\s)){2,}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    private static int key;
    private static boolean find;

    public static void brute(){
        String inputFile = getInputFileDecode(MESSAGE_OUT);
        String outputFileFile = getOutputFileDecode(MESSAGE_IN_ENCODED);

        for (int i = 0; i < ALPHABET_LENGTH; i++) {
            if (find){
                break;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileFile))) {
                while (reader.ready()) {
                    String result = bruteForce(reader.readLine(), i);
                    if (find) {
                        writer.write(result);
                        writer.newLine();
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                throw new ApplicationException(MESSAGE_ERROR_DECODE, e);
            }
        }
        System.out.println(SUCCESS);
        System.out.printf("Key used for decryption: %d%n", getKey());
    }

    public static String bruteForce(String textInput, int key) {
        StringBuilder textOutput = new StringBuilder();
        textOutput.delete(0, textOutput.length());
        textOutput.append(Decode.encodeText(textInput, key));
        Matcher matcher = PATTERN.matcher(textOutput);
        if (matcher.find()) {
            BruteForce.key = key;
            BruteForce.find = true;
        }
        return textOutput.toString();
    }

    public static int getKey() {
        return key;
    }
}
