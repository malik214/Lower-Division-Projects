
public class BrandName {

	public static void main(String[] args) {
		System.out.println("Brand Name Generator - M. Teague\n");
		
		// Produces 10 names between 6-12 letters
		for(int num = 1; num <=10; num++) {
			int size = (int)(Math.random()*7)+6;
			String name = generateName(size);
			
			System.out.printf("%2d) %s\n", num, name);
		}
	}

	// Will generate a random name always starting with a consonant
	public static String generateName(int size) {
		int n = size;
		String name = "";

		for (int i = 0; i <= n; i++) {
			switch (name.length()) {   
			case 0:
				name = getConsonant();
				break;
			case 1:
				name = name + getVowel();
				break;
			case 2:
				name = name + getConsonant();
				break;
			case 3:
				name = name + getVowel();
				break;
			case 4:
				name = name + getConsonant();
				break;
			case 5:
				name = name + getVowel();
				break;
			case 6:
				name = name + getConsonant();
				break;
			case 7:
				name = name + getVowel();
				break;
			case 8:
				name = name + getConsonant();
				break;
			case 9:
				name = name + getVowel();
				break;
			case 10:
				name = name + getConsonant();
				break;
			case 11:
				name = name + getVowel();
				break;
			}
		}

		// The first letter will always be uppercase
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

		return name;
	}

	// Method that selects a vowel at random || Used in generateName Method
	public static String getVowel() {
		String[] vowels = { "a", "e", "i", "o", "u" };
		int random = (int) (Math.random() * 5);
		return vowels[random];
	}

	// Method that selects a consonant at random || Used in generateName Method
	public static String getConsonant() {
		String[] consonants = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w",
				"x", "z" };
		int random = (int) (Math.random() * 19);
		return consonants[random];
	}

}
