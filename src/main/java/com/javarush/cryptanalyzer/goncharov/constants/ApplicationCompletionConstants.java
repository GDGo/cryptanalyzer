package com.javarush.cryptanalyzer.goncharov.constants;

public class ApplicationCompletionConstants {

    public static final String SUCCESS = "Выполнение приложения завершилось успешно";
    public static final String MESSAGE_IN =
            "Введите путь к исходному файлу или нажмите Enter, чтобы воспользоваться демонстрационным файлом :\n" +
                    "(input.txt - используется для последующего  шифрования)";
    public static final String MESSAGE_OUT = "Введите путь к конечному файлу или нажмите Enter, чтобы воспользоваться демонстрационным файлом :\n" +
            "(output.txt - сохраниться расшифрованный текст)";
    public static final String MESSAGE_IN_ENCODED = "Введите путь к исходному файлу или нажмите Enter, чтобы воспользоваться демонстрационным файлом :\n" +
            "(encoded.txt - используется для последующей  расшифровки)";
    public static final String MESSAGE_KEY_GENERATED = "Сгенерирован ключ под номером: ";
    public static final String MESSAGE_KEY = "Введите ключ в целочисленном диапазоне : ";
    public static final String INPUT_MODE = """
            Выберете режим работы:\s
               Чтобы зашифровать текстовый файл, введите - 1
               Чтобы расшифровать текстовый файл, введите - 2
               Чтобы расшифровать текстовый файл (подбор ключа методом перебора всех возможных вариантов), введите - 3: """;
    public static final String DESCRIPTION_SERVICE = """
            Добро пожаловать в сервис шифр Цезаря!
            """;
    public static final String MESSAGE_ERROR_ENCODE = "Операция кодирования завершилась ошибкой - ";
    public static final String MESSAGE_ERROR_DECODE = "Операция декодирования завершилась ошибкой - ";
    public static final String MESSAGE_REPEAT = "Некорректный режим работы. Допустимые значения : \"1\" - для шифрования, " +
            "\"2\" - для расшифровки, \"3\" - bruteforce (подбор ключа методом перебора всех возможных вариантов) \"end\" - для завершения работы!";
}
