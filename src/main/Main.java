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
    public static int maxErrors = 6;

    public static Scanner scanner = new Scanner(System.in);
    public static List<String> words = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    //  Стартове меню.
    public static void main(String[] args) {
        while (true) {
            System.out.println("For start enter 1\nFor exit enter 2 ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                startGame();
            } else if (choice.equals("2")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Enter 1 or 2 please.");
            }

        }
    }

    //  Метод startGame. В ньому створюємо секретне слово та запускаємо ігровий цикл.
    public static void startGame() {
        getWordsFromFile();
        getRandomWordFromList();
        gameLoop();
    }

    //  Метод gameLoop. В ньому цикл гри поки вона не завершиться : показуємо заштриховане слово,
    //  запитуємо у користувача букву, перевіряємо введення, перевіряємо стан гри.
    public static void gameLoop() {

        List<Character> enteredLetters = new ArrayList<>();
        String maskedWord = selectedWord.replaceAll("[a-z]", "_");
        int errorCount = 0;

        while (true) {
            System.out.println("Current word: " + maskedWord);

            // Перевірка на поразку.
            if (errorCount >= maxErrors) {
                System.out.println("Sorry! You Lose! Secret Word - " + selectedWord);
                break;
            }

            // Перевірка на перемогу.
            if (!maskedWord.contains("_")) {
                System.out.println("Congratulation! You Win Secret Word - !" + selectedWord);
                break;
            }

            // Запитуємо букву.
            System.out.println("Enter a-z letter");
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Enter only one letter.");
                continue;
            }
            char enteredLetter = input.charAt(0);

            // Перевірка чи не повторюється буква.
            if (isLetterAlreadyEntered(enteredLetters, enteredLetter)) {
                System.out.println("You already enter that letter.");
                continue;
            }

            // Додаємо букву до списку введених букв.
            enteredLetters.add(enteredLetter);

            if (selectedWord.contains(String.valueOf(enteredLetter))) {
                System.out.println("That`s right! The letter is in the word.");
                maskedWord = updateMaskedWord(selectedWord,maskedWord,enteredLetter);
            } else {
                errorCount++;
                System.out.println("Error! The letter isn`t in the word. Error counter " + errorCount);
            }

        }

    }

    //  Метод який добуває слова із файлу і формує список слів.
    public static void getWordsFromFile() {
        String pathToWords = "src/resources/words.txt";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(pathToWords))){
            words = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Помилка при читанні файлу: " + pathToWords);
            logger.log(Level.SEVERE, "Помилка при читанні файлу: " + pathToWords, e);
        }

    }

    // Метод який добуває випадкове слово зі списку слів.
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

         selectedWord = resultWord.replaceAll("\\s", "").toLowerCase();

    }

    //  Метод яка оновлює заштриховане слово.
    public static String updateMaskedWord(String selectedWord, String maskedWord, char enteredLetter) {
        StringBuilder updated = new StringBuilder(maskedWord);
        for (int i = 0; i <selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == enteredLetter){
                updated.setCharAt(i, enteredLetter);
            }
        }
        return updated.toString();
    }

    // Метод який перевіряє чи вже введена буква.
    public static boolean isLetterAlreadyEntered(List<Character> enteredLetters, char enteredLetter) {
        if (enteredLetters.contains(enteredLetter)) {
            return true;
        }
        return false;
    }
}