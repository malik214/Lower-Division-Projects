
import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Palindrome Checker - M. Teague\n");
		String phrase = "";
		// program will continue to loop until "done" is input
		while (phrase != "done") {
			System.out.print("\nEnter a phrase: ");
			phrase = in.nextLine();

			if (phrase.equals("done")) {
				System.exit(0);
			}
			if (palindromeChecker(phrase) == true) {
				System.out.print("That is a Palidrome\n");
			}
			if (palindromeChecker(phrase) == false) {
				System.out.print("That is NOT a Palidrome\n");
			}

		}

		in.close();

	}

	// checks each letter in the string to verify if palindrome
	public static boolean palindromeChecker(String phrase) {

		phrase = removePunctuation(phrase);
		// 'i' is the first letter and 'j' is the last letter
		int i = 0;
		int j = phrase.length() - 1;
		// 'i' will always be less than 'j'
		while (i < j) {
			if (phrase.charAt(i) != phrase.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	// Removes all the punctuation and spaces from given string
	public static String removePunctuation(String str) {
		str = str.toLowerCase();
		str = str.replaceAll("\\p{Punct}", "");
		str = str.replaceAll("\\s", "");

		return str;

	}
}
