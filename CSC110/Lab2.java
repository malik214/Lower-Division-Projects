
/*	Malik Teague
	Lab2
	Program that reads users name and counts number of characters in a string and then compares them
	CSC110 Lab#2
	About an hour 
*/
import java.util.Scanner;

public class Lab2 {

	public static void main(String[] args) {
		String firstName;
		String lastName;
		String fullName;

		int nameLength = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Please enter first name: ");
		firstName = in.nextLine();
		System.out.print("Please enter last name: ");
		lastName = in.nextLine();
		fullName = firstName + " " + lastName; // Concatenates the two names together
		System.out.println("Full name (in capitals): " + fullName.toUpperCase()); // converts the string to show in uppercase letters
		nameLength = fullName.length();
		System.out.println("Length of full name: " + (nameLength));

		if (firstName == lastName) {
			System.out.println("String comparison using \"==\" sign works."); // The "==" sign will never work comparing strings

		} else {
			System.out.println("String comparison using \"==\" sign does not work.");
		}

		if (firstName.equals(lastName)) {
			System.out.println("String comparision using \"equals\" method works." + " The names are identical.");
		} else {
			System.out.println("String comparision using \"equals\" method works." + " The names are not identical.");
		}

		in.close();
	}

}
