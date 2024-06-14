package com.javarush.cryptanalyzer.goncharov.services;

import static com.javarush.cryptanalyzer.goncharov.constants.FunctionCodeConstants.*;
import static com.javarush.cryptanalyzer.goncharov.services.UtilsFunc.*;

public class PathUtilsFunc {

    public static String getInputFileEncode(String message){
        System.out.println(message);
        String inputFileEncode = in.nextLine();
        if (inputFileEncode.equals("")){
            inputFileEncode = INPUT;
        }
        return inputFileEncode;
    }

    public static String getOutputFileEncode(String message){
        System.out.println(message);
        String outputFileEncode = in.nextLine();
        if (outputFileEncode.equals("")){
            outputFileEncode = OUTPUT;
        }
        return outputFileEncode;
    }

    public static String getInputFileDecode(String message){
        System.out.println(message);
        String inputFileDecode = in.nextLine();
        if (inputFileDecode.equals("")){
            inputFileDecode = OUTPUT;
        }
        return inputFileDecode;
    }

    public static String getOutputFileDecode(String message){
        System.out.println(message);
        String outputFileDecode = in.nextLine();
        if (outputFileDecode.equals("")){
            outputFileDecode = ENCODED;
        }
        return outputFileDecode;
    }
}
