import java.util.Scanner;

public class Fibbonacci {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter an Integer: ");
		int n = in.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.print(fib(i) + " ");
		}

		
		in.close();
	}
	
	

	public static int fib(int n) {

		int[] fib = new int[n + 2];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++) {

			fib[i] = fib[i - 1] + fib[i - 2];

		}
		return fib[n];

	}
}
