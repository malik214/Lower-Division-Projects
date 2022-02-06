public class PokerDice {

	public static void main(String[] args) {
		final int MAX_ROLLS = 1_000_000;
		int[] tally = { 0, 0, 0, 0, 0, 0, 0, 0 }; // tally[0] not used
		String[] handNames = { "N/A", "None alike", "One Pair", "Two Pairs", "Three of a Kind", "Full House",
				"Four of a Kind", "Five of a Kind" };

		Die[] dice = createDice(5); // Creates an array of 5 dice

		for (int roll = 0; roll < MAX_ROLLS; roll++) {
			rollDice(dice);
			int hand = determineHand(dice); // Checking each hand for unique matches after every roll
			tally[hand]++;
		}

		printHeading(MAX_ROLLS);
		for (int i = 1; i < tally.length; i++) {
			System.out.printf("Case %d.) %15s, is %.5f\n", i, handNames[i], (double) tally[i] / MAX_ROLLS);
		}
	}

	public static void printHeading(int MAX_ROLLS) {
		int number = MAX_ROLLS;
		System.out.printf("Poker Dice Probability Calculator - M.Teague\n" + "Running " + "%,d" + " trials\n" + "\n",
				number);

	}

	// This method will function properly when game is being played with 5 dice
	public static int determineHand(Die[] dice) {
		int uniqueMatch = 0;
		int uniqueHand = 0;

		// Checking each die in the array from left to right looking for a unique pair
		for (int i = 0; i < dice.length; i++) {
			dice[i].getValue();
			for (int j = i + 1; j < dice.length; j++) {
				dice[j].getValue();
				if (dice[i].getValue() == dice[j].getValue()) {
					uniqueMatch++;
				}
			}
		}

		// There are seven distinct possibilites for the numbers of unique matches
		switch (uniqueMatch) {
		case 0: // None Alike
			uniqueHand = 1;
			break;
		case 1: // One Pair
			uniqueHand = 2;
			break;
		case 2: // Two pairs
			uniqueHand = 3;
			break;
		case 3: // Three of a Kind
			uniqueHand = 4;
			break;
		case 4: // Full House
			uniqueHand = 5;
			break;
		case 6: // Four of a Kind
			uniqueHand = 6;
			break;
		case 10: // Five of a Kind
			uniqueHand = 7;
			break;

		}

		return uniqueHand;
	}

	// Rolls all the dice created in the array
	public static void rollDice(Die[] dice) {
		for (int i = 0; i < dice.length; i++) {
			dice[i].roll();
		}

	}

	// Creates an array of dice of any desired size
	// Please pass in parameter value of 5 for game to function properly
	public static Die[] createDice(int n) {
		Die[] dice = new Die[n];
		for (int i = 0; i < n; i++) {
			dice[i] = new Die();
		}

		return dice;
	}

}
