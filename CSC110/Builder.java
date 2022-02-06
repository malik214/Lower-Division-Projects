
public class Builder {
	String name;

	public Builder(String n) {
		name = n;
	}

	// Accessor method to return name of the builder
	public String getName() {
		return name;

	}

	// Method that will print any string a desired number of times
	public String makeRow(int n, String s) {
		String row = "";

		for (int i = 0; i < n; i++) {
			row = row + s;

		}

		return row;

	}

	// Method will create perfect pyramid with n being the base
	public void makePyramid(int n, String s) {
		int numSpaces = n / 2;
		for (int i = 1; i <= n; i = i + 2) {
			System.out.println(makeRow(numSpaces, " ") + makeRow(i, s));
			numSpaces--;

		}

	}
}
