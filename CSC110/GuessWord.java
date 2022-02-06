import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;

public class GuessWord {

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> words = readWords();
		String word = pickWord(words);
		String guesses = "";

		Scanner console = new Scanner(System.in);

		System.out.println("Guess-a-Word - Malik Teague\n");

		// Continues to print the word while the word hasn't been solved
		do {
			printWord(word, guesses);
			guesses += getUniqueGuess(console, guesses);
		} while (!wordGuessed(word, guesses));

		printWord(word, guesses);
		System.out.print("You guessed it in " + guesses.length() + " tries.");

		console.close();

	}

	// Reading words from a file
	public static ArrayList<String> readWords() throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<String>();
		File inputFile = new File("words.txt");
		Scanner in = new Scanner(inputFile);
		while (in.hasNext()) {
			words.add(in.next());
		}
		in.close();
		return words;
	}

	// Chooses a word at random
	public static String pickWord(ArrayList<String> list) {
		int choice = (int) (Math.random() * list.size());
		System.out.print("I know " + list.size() + " words. Shall we play a game?\n");
		return list.get(choice).toUpperCase();
	}

	public static void printWord(String word, String guesses) {
		for (int i = 0; i < word.length(); i++) {
			if (guesses.indexOf(word.charAt(i)) != -1) {
				System.out.print(word.charAt(i) + " ");
			} else
				System.out.print("_ ");
		}
		System.out.println("	Used Letters: " + "{" + guesses + "}");

	}

	// Users guesses will consist of unique letters only
	public static String getUniqueGuess(Scanner in, String guesses) {
		System.out.print("\nEnter a letter: ");

		String uniqueGuess = in.next().toUpperCase();

		if (guesses.contains(uniqueGuess)) {
			uniqueGuess = "";
		}

		return uniqueGuess;

	}

	public static boolean wordGuessed(String word, String guesses) {
		for (int i = 0; i < word.length(); i++) {
			if (guesses.indexOf(word.charAt(i)) == -1) {
				return false;
			}
		}
		return true;

	}

}
