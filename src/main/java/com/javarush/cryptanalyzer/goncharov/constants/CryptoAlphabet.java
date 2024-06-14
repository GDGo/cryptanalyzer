package com.javarush.cryptanalyzer.goncharov.constants;

public class CryptoAlphabet {
    public static final String lettersUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    public static final String lettersLowerCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String numbers = "0123456789";
    public static final String symbols = ".,\"^-!& ";
    public static final String ALPHABET = lettersUpperCase + lettersLowerCase + numbers + symbols;
    public static final int ALPHABET_LENGTH = ALPHABET.length();
}