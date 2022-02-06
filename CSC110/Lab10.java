
/* Malik Teague
 * CSC110
 * Lab10
 * Working with Constructors
 * 1.5 hr completion time
 */
import java.util.Scanner;

public class Lab10 {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int row = 0;
		int stars = 0;
		String name = "";

		System.out.print("Name of the builder: ");
		name = console.next();

		// The name of the builder is defined by the user
		Builder myBuilder = new Builder(name);

		System.out.println("The name of the builder is: " + myBuilder.getName());

		System.out.print("Enter a positive interger: ");
		// User input will determine the legnth of this string pattern
		row = console.nextInt();
		System.out.println(myBuilder.makeRow(row, "=") + myBuilder.makeRow(row, "*") + myBuilder.makeRow(row, "="));

		System.out.print("Enter a positive odd interger, \n representing number of stars in the base of a pyramid: ");
		// User input will control the size of the pyramid created
		stars = console.nextInt();
		myBuilder.makePyramid(stars, "*");

		console.close();

	}

}
