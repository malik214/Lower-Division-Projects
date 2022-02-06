
import java.util.Scanner;

public class GradeConverter {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String letter;

		System.out.print("What is your final number grade? ");
		double grade = in.nextDouble();
		if (grade < 1.0) {
			grade = grade * 100.0;
			System.out.println("Assuming " + grade + "%");
		}

		grade = (int) (grade + 0.5);

		if (grade >= 98.0) {
			letter = "A+";
		} else if (grade >= 90) {
			letter = "A";
		} else if (grade >= 88) {
			letter = "B+";
		} else if (grade >= 80) {
			letter = "B";
		} else if (grade >= 78) {
			letter = "C+";
		} else if (grade >= 70) {
			letter = "C";
		} else if (grade >= 60) {
			letter = "D";
		} else {
			letter = "E";
		}

		System.out.println("Final Grade: " + letter);
		in.close();
	}
}