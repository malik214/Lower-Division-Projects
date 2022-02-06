
/*  Malik Teague
 *  Lab 1
 *  Reading 3 test grades and then calculating the average.
 *  For CSC110 - Lab#1
 *  30-45 minutes of work
 */
import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		int test1, test2, test3;
		final int NUM_TEST = 3;
		int averageGrade; // No value set, average will be calculated after all 3 test scores have been
								// added

		Scanner in = new Scanner(System.in);

		System.out.print("Enter your first test Score: ");
		test1 = in.nextInt();

		System.out.print("Enter your second test score: ");
		test2 = in.nextInt();

		System.out.print("Enter your third test score: ");
		test3 = in.nextInt();
		// Users data has been input and stored, average can now be calculated
		in.close();
		averageGrade = (test1 + test2 + test3) /  NUM_TEST;

		System.out.printf("Your average test score is %d\n", averageGrade); // Showing only 2 decimal places

	}

}
