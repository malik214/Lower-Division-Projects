
/* Malik Teague
 * Lab5
 * Program that creates an array of numbers and returns the sum
 * CSC110
 * About 2.5 hrs
 */
import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		double currentElement = 0;
		int counter = 0;
		double sum = 0; 

		System.out.print("How many elements in the array? ");
		int arrayLength = in.nextInt(); 

		double[] values = new double[arrayLength];
		// Filling in the elements of the array
		for (int i = 0; i < arrayLength; i++) {
			System.out.print("Please enter the next value: ");
			currentElement = in.nextDouble();
			values[i] = currentElement;
		}
		// Displaying the array's elements starting with the last one entered
		for (int i = values.length - 1; i >= 0; i--) {
			System.out.printf("%.3f" + "	", (values[i]));
			counter++;
			
			// setting the values to start a new line past the 8th spot
			if (counter % 8 == 0) { 
				System.out.printf("\n");
			}
				
			
			
			sum = sum + values[i];
		}
		
		System.out.printf("\nThe sum of the array's elements is: %.3f",sum);

		in.close();

	}

}