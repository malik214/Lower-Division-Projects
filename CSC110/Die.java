
public class Die {
	int numSides;
	int value;
	boolean frozen;

	// Creates a die with desired number of sides. Does not allow for 1 sided die or
	// negative sides
	public Die(int numSides) {
		if (numSides > 1) {
			this.numSides = numSides;
		} else {
			numSides = 6;
			System.out.print("Incorrect input. Assuming 6 sides\n");
		}

		value = 1;
		frozen = false;

		// All created die will be unfrozen initially
	}

	// Die created with no parameters defaults to 6 sides
	public Die() {
		numSides = 6;
		value = 1;
		frozen = false;

	}

	// As long as die isn't frozen, value parameter will pass
	public void setValue(int v) {
		if (frozen == false) {
			value = v;
		}

		// The value cannot be a negative number or greater than the number of sides
		if (v <= 0 || v > numSides) {
			value = 1;
			System.out.print("*** Attempted to set value to " + v + ", assumed 1.\n");
		}

	}

	public int getValue() {
		return value;
	}

	// As long as die isn't frozen, will generate a random number between 1 and the
	// maxiumum number of sides
	public void roll() {
		if (frozen == false) {
			value = (int) (Math.random() * numSides + 1);
		}

	}

	public void print() {
		System.out.print("[" + value + ":" + numSides + "]");
	}

	// Method that draws a realistic graphic of the die if it has 6 or less sides.
	// Else will just print a simple graphic
	public void draw() {

		if (numSides <= 6) {

			switch (value) {

			case 1:
				System.out.print(
						".......\n" + ".     ." + "\n.     ." + "\n.  *  ." + "\n.     ." + "\n.     ." + "\n.......");
				break;
			case 2:
				System.out.print(
						".......\n" + ".     ." + "\n.   * ." + "\n.     ." + "\n. *   ." + "\n.     ." + "\n.......");
				break;
			case 3:
				System.out.print(
						".......\n" + ".     ." + "\n.   * ." + "\n.  *  ." + "\n. *   ." + "\n.     ." + "\n.......");
				break;
			case 4:
				System.out.print(
						".......\n" + ".     ." + "\n. * * ." + "\n.     ." + "\n. * * ." + "\n.     ." + "\n.......");
				break;
			case 5:
				System.out.print(
						".......\n" + ".     ." + "\n. * * ." + "\n.  *  ." + "\n. * * ." + "\n.     ." + "\n.......");
				break;
			case 6:
				System.out.print(
						".......\n" + ".     ." + "\n. * * ." + "\n. * * ." + "\n. * * ." + "\n.     ." + "\n.......");
				break;
			default:
				print();

			}
		} else
			print();

	}

	// Freezes the die, prohibiting rolls and value changes
	public void freeze() {
		frozen = true;
	}

	// Unfreezes the die, resuming rolls and changes to values
	public void unFreeze() {
		frozen = false;
	}
}
