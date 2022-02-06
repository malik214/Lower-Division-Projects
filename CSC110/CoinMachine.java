/* Malik Teague
	CSC 110
	Change Return
	Program that will indicate how many dollars, quarters, dimes, nickles and cents are returned to the customer
	This one took a long time */
	
import java.util.Scanner;

public class CoinMachine {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Coin Machine - Malik Teague");
		System.out.println("");
		System.out.print("Enter the Amount owed: ");
		double amountOwed = in.nextDouble();
		System.out.print("Enter the Amount recieved: ");
		double amountRecieved = in.nextDouble();	
		
		// Algorithm used to determine which coins to use, with the least amount of coins needed
		double changeDue = (amountRecieved-amountOwed);
		int dollars = (int) changeDue/1;
		changeDue = changeDue%dollars;
		int quarters = (int) ((changeDue/25)*100);
		changeDue = changeDue-quarters*.25;
		int dimes = (int) ((changeDue/10)*100);
		changeDue = changeDue-dimes*.10;
		int nickles = (int) ((changeDue/5)*100);
		changeDue = changeDue-nickles*.05;
		int pennies = (int) Math.round((changeDue)*100);
		
		// If money owed is greater than what is recieved program will terminate
		if (amountRecieved < amountOwed) {
			System.out.printf("***You did not provide enough money. You are $%.2f short.***",
					amountOwed - amountRecieved);
			System.exit(0);
		} else {
			System.out.printf("Your change today is $%.2f\n", amountRecieved - amountOwed);
			System.out.print("");
			System.out.println("Dollars: " + dollars);
			System.out.println("Quarters: " + quarters);
			System.out.println("Dimes: " + dimes);
			System.out.println("Nickles: " + nickles);
			System.out.println("Pennies: " + pennies);
		
			
			
			
				
		}

		in.close(); 
		
	}
}

	
	


