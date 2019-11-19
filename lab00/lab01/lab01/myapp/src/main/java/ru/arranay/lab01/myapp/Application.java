package ru.arranay.lab01.myapp;

import ru.liverfluke.lab01.mylib.Greetings;
import ru.liverfluke.lab01.mylib.GreetingsBuilder;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Основной класс приложения
 */
public class Application {
    public static final String DEFAULT_CONSOLE_ENCODING = "UTF-8";
    public static final String CONSOLE_ENCODING_PROPERTY = "consoleEncoding";

    public static void main(String[] args) {
        // создаём класс приложения
        Application app = new Application();

        // запускаем выполнение
        app.run();
    }


    public void run() {
        // установить кодировку консоли
        setConsoleEncoding();

        // создание построителя приветствий
        GreetingsBuilder greetings = new GreetingsBuilder();

        // вывод приветствия в консоль
        System.out.println(
                greetings.to("World")
                        .withLanguage(Greetings.LANGUAGE_EN)
                        .withStyle(Greetings.STYLE_FRIENDLY)
                        .build()
        );
    }

    private static void setConsoleEncoding() {
        // чтение системной переменной
        String consoleEncoding = System.getProperty(CONSOLE_ENCODING_PROPERTY, DEFAULT_CONSOLE_ENCODING);

        try {
            // установить кодировку стандартной консоли вывода
            System.setOut(new PrintStream(System.out, true, consoleEncoding));
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Unsupported encoding set for console: " + consoleEncoding);
        }
    }
}
