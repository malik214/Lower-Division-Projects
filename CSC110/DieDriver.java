
public class DieDriver {

	public static void main(String[] args) {

		// Creating 3 new Die objects for testing
		Die d1 = new Die();
		Die d2 = new Die(4);
		Die d3 = new Die(10);

		// Printing each die object created using a simple graphic
		System.out.println("Die Driver - M. Teague\n" + "\n1. Creation of Die\n");
		System.out.print("  a.) ");
		d1.print();
		System.out.print("\n  b.) ");
		d2.print();
		System.out.print("\n  c.) ");
		d3.print();

		// All die are created with a default value of 1. Changing that value here.
		System.out.println("\n" + "\n2. Setting value of Die\n");
		d1.setValue(3);
		d2.setValue(5);
		d3.setValue(0);

		System.out.print("  a.) ");
		d1.print();
		System.out.print("\n  b.) ");
		d2.print();
		System.out.print("\n  c.) ");
		d3.print();

		System.out.println("\n" + "\n3. Freezing a Die\n");
		d1.freeze();
		d1.setValue(5); // This method does not work as the die is currently frozen
		System.out.print("  a.) ");
		d1.print();
		d1.unFreeze();
		d1.setValue(5); // Die has been unfrozen and value is allowed to be changed
		System.out.print("\n  b.) ");
		d1.print();

		System.out.println("\n" + "\n4. Drawing a Die\n");
		System.out.print("  a.)\n");
		d1.draw();
		System.out.print("\n  b.)\n");
		d2.draw();
		System.out.print("\n  c.)\n");
		d3.draw(); // A simple graphic is used here as this die has more than 6 sides

		System.out.println("\n" + "\n5. Rolling a Die\n");

		// Rolling all 3 die simultaneously. Value will never exced maximum number of
		// sides a die has
		System.out.print("  a.) ");
		for (int i = 1; i <= 10; i++) {
			d1.roll();
			d1.print();
			System.out.print(" ");
		}
		System.out.print("\n  b.) ");
		for (int i = 1; i <= 3; i++) {
			d2.roll();
			d2.print();
			System.out.print(" ");
		}
		System.out.print("\n  c.) ");
		for (int i = 1; i <= 10; i++) { 
			d3.roll();
			d3.print();
			System.out.print(" ");
		}

	}

}
