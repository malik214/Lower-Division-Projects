/* Malik Teague
 * Lab 11 
 * Classes, Objects and Constructors 
 * CSC110
 * 30 minute completion time
 */
import java.util.Scanner;

public class Lab11 {

	public static void main(String[] args) {
		String studentMajor = "";
		String firstName = "";
		String lastName = "";
		int studentCredits = 0;

		Scanner in = new Scanner(System.in);

		System.out.println("ENTER FIRST STUDENT'S INFORMATION");
		System.out.print(" Enter first name: ");
		firstName = in.next();
		System.out.print(" Enter last name: ");
		lastName = in.next();
		System.out.print(" Enter your major: ");
		studentMajor = in.next();
		System.out.print(" Enter your total credits: ");
		studentCredits = in.nextInt();

		Student student1 = new Student(firstName, lastName, studentMajor, studentCredits);

		System.out.println("\nENTER SECOND STUDENT'S INFORMATION");
		System.out.print(" Enter first name: ");
		firstName = in.next();
		System.out.print(" Enter last name: ");
		lastName = in.next();

		Student student2 = new Student(firstName, lastName);

		System.out.print("\nFIRST STUDENT'S INFORMATION: ");
		System.out.print("\n The name of the student is: " + student1.getFullName() + "\n Major is: "
				+ student1.getMajor() + "\n Number of earned credits: " + student1.getCredits() + "\n");
		
		System.out.print("\nSECOND STUDENT'S INFORMATION: ");
		System.out.print("\n The name of the student is: " + student2.getFullName() + "\n Major is: "
				+ student2.getMajor() + "\n Number of earned credits: " + student2.getCredits() + "\n\n");

		student1.changeMajor("International Affairs");
		
		in.close();
	}

}
