
/* Malik Teague
 * Lab 9 
 * Declaring class methods and calling from the main method
 * CSC 110
 * 1 hr completion time
 */
import java.util.Scanner;

public class Lab9 {

	public static void main(String[] args) {

		String firstName = "";
		String lastName = "";
		int birthYear = 0;
		Scanner console = new Scanner(System.in);

		System.out.print("Enter the name of the person: ");
		firstName = console.next();

		System.out.print("Enter the last name of the person: ");
		lastName = console.next();

		System.out.print("Enter the birth year of the person: ");
		birthYear = console.nextInt();

		Person user = new Person();

		System.out.print(
				user.getFirstName(firstName) + " " + user.getLastName(lastName) + " is " + user.getAge(2020, birthYear)
						+ " years old and will be " + user.getAge(2030, birthYear) + " in ten years.");

		console.close();

	}

}
