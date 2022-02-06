
/* Malik Teague
 * Lab 7 
 * Creating 2D Array and giving sum of each row
 * CSC 110
 * 45 minute completion time
 */
import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numRows = 0;
		int numCols = 0;
		int sum;

		System.out.print("Enter the number of rows in the array: ");
		numRows = in.nextInt();
		System.out.print("Enter the number of columns in the array: ");
		numCols = in.nextInt();

		int[][] intArray = new int[numRows][numCols];

		// Filling in the array
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.print("Please enter a value: ");
				intArray[i][j] = in.nextInt();
			}

		}

		// Displaying the array back to the user, newline created after each row
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				System.out.print(intArray[i][j] + "	");
			}
			System.out.print("\n");
		}

		// Displaying the sum of each row in the array
		for (int i = 0; i < numRows; i++) {
			sum = 0;
			for (int j = 0; j < numCols; j++) {
				sum = sum + intArray[i][j];
			}
			System.out.print("Sum of elements in row " + i + " is: " + sum + "\n");
		}

		in.close();

	}

}
