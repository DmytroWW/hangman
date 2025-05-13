package main;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.logging.*;
import java.util.Scanner;

public class Main {
    // Змінні
    public static String selectedWord = "";
    public static int wordLength = 5;

    public static List<String> words = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    //  Основна функція яка запускає інші функції відправляє println, отримує скани.
    public static void main(String[] args) {
        getWordsFromFile();
        getRandomWordFromList();
    }


    //  Функція яка добуває слова із файлу і формує масив слів.
    public static void getWordsFromFile() {
        String pathToWords = "src/resources/words.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathToWords))){
            words = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + pathToWords);
            logger.log(Level.SEVERE, "Помилка при читанні файлу: " + pathToWords, e);
        }

    }

    //
    public static void getRandomWordFromList() {
        if (words.isEmpty()) {
            System.out.println("Words list is empty");
            return;
        }

        Random random = new Random();
        String resultWord = "";
        int attempts = 0;
        while (resultWord.length() < wordLength) {
            int randomNumber = random.nextInt(words.size());
            resultWord = words.get(randomNumber);
            attempts++;
            if (attempts > 1000) {
                return;
            }
        }

         selectedWord = resultWord.replaceAll("\\s", "");
         System.out.println("Random word: " + selectedWord);

    }
    //  Функція яка отримує із вводу букву і перевіряє чи коректний ввід.
    //  Функція яка створює дві змінні : слово яке відгадуємо та слово яке повертаємо користувачу(заштриховане).
    //  Функція яка отримує букву, передає її в масив букв.
    //  Функція перевіряє, чи є ця буква в слові, якщо є, то в змінну із заштрихованим словом відкриваємо цю букву,
    //  якщо ні, то кількість помилок +1, слово не змінюється.
    //  Функція яка перевіряє чи закінчена гра(скільки помилок, заштрихованих букв).

}