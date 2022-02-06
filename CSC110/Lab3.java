/* Malik Teague
 * Lab#3
 * CSC110
 * Program that calculates students total grade and advises if they passed or failed the class.
 * About 30 minutes
 */
import java.util.Scanner;
public class Lab3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter homework grade: ");
		double homeworkGrade = in.nextDouble();
		System.out.print("Enter the midterm grade: ");
		double midtermGrade = in.nextDouble();
		System.out.print("Enter the final grade: ");
		double finalGrade = in.nextDouble();
		
		 // Algorithm used to calculate the grade for the semester
		double finalScore = ((finalGrade/200)*50)+((midtermGrade/100)*25)+((homeworkGrade/100)*25);
		char letterGrade = ' ';
		
		if (homeworkGrade>100 || homeworkGrade<0) {
			System.out.print("Invalid input. Homework and midterm grades should be between 0 and 100 and the final grade should be between 0 and 200");
			System.exit(0);
		}
		if (midtermGrade>100 || midtermGrade<0) {
			System.out.print("Invalid Input. Homework and midterm grades should be between 0 and 100 and the final grade should be between 0 and 200");
			System.exit(0);
		}	
		// Processing the letter grade
		if (finalScore>=50) {
			letterGrade='P';	
		} else {
			letterGrade='F';
		}
		
		if (letterGrade == 'P') {
			System.out.print("Student passed the class");
		} else {
			System.out.print("Student failed the class");
		}
		
		in.close();
		
	
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
