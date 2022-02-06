
/* Malik Teague
 * Lab3
 * Sorting a user created array and then shifting and removing a desired element
 * CSC110
 * 1.5 hours completion time
 */
import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int currentElement = 0;
		
		System.out.print("How many elements in the array?: ");
		int arraySize = in.nextInt();

		int[] integerArray = new int[arraySize];
		// filling the values in the array
		for (int i = 0; i < arraySize; i++) {
			System.out.print("Please enter the next value: ");
			currentElement = in.nextInt();
			integerArray[i] = currentElement;
		}

		System.out.print("The array after sorting\n");

		// Sorting the array's elements in numerical order
		for (int i = 0; i < arraySize; i++) {
			for (int j = i + 1; j < arraySize; j++) {
				if (integerArray[i] > integerArray[j]) {
					int exchange = integerArray[i];
					integerArray[i] = integerArray[j];
					integerArray[j] = exchange;
				}
			}
		}

		for (int k = 0; k < arraySize; k++) {
			System.out.print(integerArray[k] + ", ");

		}

		System.out.print("\n");
		 // Shifting the array to the left by removing the lowest value
		for (int i = 0; i < integerArray.length - 1; i++) {
			integerArray[i] = integerArray[i + 1];
		}

		integerArray[integerArray.length - 1] = 0;
		System.out.print("The array after shifting to the left\n");

		for (int k = 0; k < arraySize; k++) {
			System.out.print(integerArray[k] + ", ");
		}

		System.out.print("\n");
		// If the element is found in the array it will be removed
		System.out.print("Enter the element to search in the array: ");
		int search_element = in.nextInt();
		boolean element_found_flag = false;

		for (int i = 0; i < integerArray.length; i++) {
			if (integerArray[i] == search_element) {
				element_found_flag = true;
			}
			if (element_found_flag && i < integerArray.length - 1) {
				integerArray[i] = integerArray[i + 1];
			}
		}
		if (element_found_flag) {
			integerArray[integerArray.length - 1] = 0;
			System.out.println("Search element found");
		}

		System.out.print("Final Array: ");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(integerArray[i] + ", ");
		}

		in.close();

	}
}
