import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"programming", "java", "computer", "algorithm", "variable", "class", "method", "inheritance"};
        String wordToGuess = words[random.nextInt(words.length)];
        
        ArrayList<Character> guessedLetters = new ArrayList<>();
        int maxAttempts = 6;
        int attempts = 0;
        
        System.out.println("Welcome to Hangman!");

        while (attempts < maxAttempts) {
            printGameState(wordToGuess, guessedLetters);
            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            System.out.print("Guess a letter: ");
            
            String input = scanner.nextLine().toLowerCase();
            
            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            
            char guess = input.charAt(0);
            
            if (guessedLetters.contains(guess)) {
                System.out.println("You already guessed that letter.");
                continue;
            }
            
            guessedLetters.add(guess);
            
            if (wordToGuess.indexOf(guess) >= 0) {
                System.out.println("Good guess!");
                if (isWordGuessed(wordToGuess, guessedLetters)) {
                    printGameState(wordToGuess, guessedLetters);
                    System.out.println("Congratulations! You won! The word was: " + wordToGuess);
                    break;
                }
            } else {
                System.out.println("Wrong guess!");
                attempts++;
            }
        }
        
        if (attempts == maxAttempts) {
            System.out.println("Game over! You ran out of attempts. The word was: " + wordToGuess);
        }
        
        scanner.close();
    }

    private static void printGameState(String word, ArrayList<Character> guessedLetters) {
        StringBuilder display = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (guessedLetters.contains(c)) {
                display.append(c).append(" ");
            } else {
                display.append("_ ");
            }
        }
        System.out.println("Word: " + display.toString());
    }

    private static boolean isWordGuessed(String word, ArrayList<Character> guessedLetters) {
        for (char c : word.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
