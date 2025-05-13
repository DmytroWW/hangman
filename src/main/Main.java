package main;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        getWordsFromFile();
    }

    // Змінні

    //  Основна функція яка запускає інші функції відправляє println, отримує скани.

    //  Функція яка добуває слова із файлу і формує масив слів.
    public static List<String> getWordsFromFile() {
        String pathToWords = "src/resources/words.txt";
        List<String> words = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathToWords));){
            words = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(words.size());
        return words;
    }

    //
    public static String getRandomWordFromFile() {
        return "hello world";
    }
    //  Функція яка отримує із вводу букву і перевіряє чи коректний ввід.
    //  Функція яка створює дві змінні : слово яке відгадуємо та слово яке повертаємо користувачу(заштриховане).
    //  Функція яка отримує букву, передає її в масив букв.
    //  Функція перевіряє, чи є ця буква в слові, якщо є, то в змінну із заштрихованим словом відкриваємо цю букву,
    //  якщо ні, то кількість помилок +1, слово не змінюється.
    //  Функція яка перевіряє чи закінчена гра(скільки помилок, заштрихованих букв).

}