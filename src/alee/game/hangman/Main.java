package alee.game.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// A simple Hangman game programmed in Java for local co-op play
// AUTHOR: Andy Lee

public class Main {

	public static void main(String[] args) {
			
		boolean isWinner = false;
		boolean correctGuess = false;
		int numberofGuesses = 6;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter word for other player to guess:");	
		String answer = scanner.nextLine().toUpperCase();
		
		String[] guessWord = answer.split("(?!^)");
		String[] displayWord = new String[answer.length()];
		ArrayList<String> trackGuesses = new ArrayList<String>();
		
		for (int i = 0;  i < displayWord.length; ++i) {
			displayWord[i] = "_";
		}
		
			
		// "Clear" console
		for (int i = 0; i < 100; i++) System.out.println();
		
		
		while (!isWinner && numberofGuesses > 0) {
			System.out.println("Guess a character:");
			String guess = scanner.nextLine().toUpperCase();
			
			// Accept single characters only
			if (guess.length() == 1 ) {
				if (!trackGuesses.contains(guess)) {
					
					trackGuesses.add(guess);
					
					for (int i = 0; i < guessWord.length; ++i) {
						if (guess.equals(guessWord[i])) {
							displayWord[i] = guess;
							correctGuess = true;
							System.out.println("Correct! You've filled in a slot.");
						}
					}
					
					System.out.println("Hangman: " + Arrays.toString(displayWord));
					
					if (correctGuess) {
						correctGuess = false;
					} else {
						--numberofGuesses;
						System.out.println("Wrong! Remaining Guesses: " + numberofGuesses);
					}
					
					if (Arrays.equals(guessWord, displayWord)) {
						isWinner = true;
					}
					
				} else {
					System.out.println("You've already guessed this character!");
					System.out.println("Characters guessed so far: " + trackGuesses + "\n");
				}
				
			} else {
				System.out.println("Invalid input. You may only input one character at a time. Try again.");
			}	
		}
		
		
		
		if (isWinner) {
			System.out.println("\n!!!-----------------------------------------------------------------------------------------!!!");
			System.out.println("Congratulations! You've won! The answer was: " + answer);
			System.out.println("!!!-----------------------------------------------------------------------------------------!!!");
		} else {
			System.out.println("\n-----------------------------------------------------------------------------------------------");
			System.out.println("You lose! Better luck next time. The correct answer was: " + answer);
			System.out.println("-----------------------------------------------------------------------------------------------");
		}
		
		
		scanner.close();
		
	}
}
