
// Malik Teague
// This application will calculate interest earned in a simple savings account 
import java.util.Scanner;

public class Savings {

	public static void main(String[] args) {

		double initialSavings, rate, profit;
		int time;

		Scanner in = new Scanner(System.in);

			System.out.println("Simple Interest - M. Teague");

			System.out.print("What is the inital savings amount?: ");
		initialSavings = in.nextDouble();

			System.out.print("What is the number of months to save?: ");
		time = in.nextInt();

			System.out.print("What is the annual interest rate?: ");
		rate = in.nextDouble();

		profit = initialSavings * Math.pow(1.0 + rate / 100.0 / 12.0, time); // The future value will be calculated on
																				// monthly interest

			System.out.printf("$%.2f, saved for %d months at %.2f%% will be valued at $%.2f\n", initialSavings, time, rate,
				profit);

		in.close();

	}

}
