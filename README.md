# Hangman Game

This is a simple text-based Hangman game in Java. The goal of the game is to guess a hidden word by suggesting letters
one at a time. If you guess a letter correctly, it will be revealed in the word. If you guess incorrectly,
the number of allowed mistakes decreases. The game ends when either the word is fully guessed or the number of
mistakes exceeds the limit.

## Features

- Load words from a file.
- Select a random word for the game.
- Track entered letters and check for duplicates.
- Allow the player to make a certain number of mistakes.
- Display the current state of the word with guessed letters.
- Show a message upon win or loss.

## Requirements

- Java 8 or later.

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/DmytroWW/hangman.git
````

2. Navigate to the project directory:

   ```bash
   cd hangman-game
   ```

3. Compile and run the program:

   ```bash
   javac Main.java
   java Main
   ```

## How to Play

1. Start the game by entering `1` when prompted.
2. The game will show the word with `_` characters for hidden letters.
3. Enter a single letter at a time to guess a letter in the word.
4. If you guess the letter correctly, it will be revealed in the word.
5. If the letter is incorrect, the number of remaining attempts will decrease.
6. The game will end when:

   * You guess all the letters correctly, and win.
   * Or you run out of allowed mistakes, and lose.

## File Structure

```
hangman/
├── src/
│   ├── resources/
│   │   └── words.txt  # Word list for the game.
│   └── main/
│       └── Main.java   # Main class to run the game.
├── README.md          # This file.
└── build.gradle       # Gradle build file (optional for building and packaging).
```

