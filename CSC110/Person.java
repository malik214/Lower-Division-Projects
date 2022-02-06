/* Malik Teague
 * Lab 9 
 * Declaring class methods and calling from the main method
 * CSC 110
 * 1 hr completion time
 */
public class Person {

	private String firstName;
	private String lastName;
	private int birthYear = 0;

	public String getFirstName(String f) {
		firstName = f;

		return firstName;
	}

	public String getLastName(String l) {
		lastName = l;

		return lastName;
	}

	public int getAge(int currentYear, int b) {
		birthYear = b;
		int age = 0;

		age = age + (currentYear - birthYear);

		return age;

	}
}
