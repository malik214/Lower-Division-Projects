import java.util.Scanner;

public class HWMult {

	public static void main(String[] args) {
		int multiplier;
		long multiplicand;
		long product;

		Scanner in = new Scanner(System.in);

		System.out.print("Hardware Multiply - Malik Teague\n");
		System.out.print("Multiplier?");
		multiplier = in.nextInt();

		System.out.print("Multiplicant?");
		multiplicand = in.nextLong();
		product = algo(multiplier, multiplicand);

		System.out.println("Java: " + multiplier + " x " + multiplicand + " = " + multiplier * multiplicand);
		System.out.println("Algo: " + multiplier + " x " + multiplicand + " = " + product);

		in.close();
	}

	public static long algo(int multiplier, long multiplicand) {
		long result = 0;
		int reps = 0;
		int multiplier0 = 0;

		while (reps < 32) {
			multiplier0 = multiplier & 1;
			if (multiplier0 == 1) {
				result = result + multiplicand;
			}
			multiplicand = multiplicand << 1;
			multiplier = multiplier >> 1;
			reps++;

		}

		return result;
	}

}
