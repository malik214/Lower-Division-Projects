
/* Malik Teague
 * TextSlang Program
 * CSC110
 * Program will repeatedly ask user for text slang term and give it's meaning
 * About an hour
 */
import java.util.Scanner;

public class TextSlang {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String slangTerm = ("");

		System.out.println("TextSlang - Malik Teague\n");

		// program will loop continuously until "TTFN" is entered
		while (!slangTerm.equals("TTFN")) {

			System.out.print("Enter a slangTerm term, TTFN to stop: ");
			slangTerm = in.next();
			// converts all possible entries to uppercase
			slangTerm = slangTerm.toUpperCase();

			// Checking to see if input is one of these possible strings
			switch (slangTerm) {
			case "BRB":
				System.out.print(slangTerm + " means Be Right Back\n");
				break;
			case "FOMO":
				System.out.print(slangTerm + " means Fear of Missing Out\n");
				break;
			case "IDK":
				System.out.print(slangTerm + " means I Don't Know\n");
				break;
			case "IRL":
				System.out.print(slangTerm + " means In Real Life\n");
				break;
			case "JK":
				System.out.print(slangTerm + " means Just Kidding\n");
				break;
			case "J/K":
				System.out.print(slangTerm + " means Just Kidding\n");
				break;
			case "TTFN":
				System.out.print(slangTerm + " means Ta-Ta For Now\n");
				System.exit(0);
				break;
			case "TTYL":
				System.out.print(slangTerm + " means Talk To You Later\n");
				break;
			case "YOLO":
				System.out.print(slangTerm + " means You Only Live Once\n");
				break;
			default:
				System.out.print(slangTerm + " means something I don't know\n");

			}
		}

		in.close();

	}

}
