
public class Student {
	String studentMajor;
	String firstName;
	String lastName;
	int studentCredits;

	public Student(String fName, String lName, String major, int credits) {
		firstName = fName;
		lastName = lName;
		studentMajor = major;
		studentCredits = credits;

	}

	public Student(String fName, String lName) {
		firstName = fName;
		lastName = lName;
		this.studentMajor = ("General Studies");
		this.studentCredits = 0;

	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getMajor() {
		return studentMajor;

	}

	public int getCredits() {
		return studentCredits;
	}

	public void changeMajor(String newMajor) {
		studentMajor = newMajor;

		System.out.print(firstName + " " + lastName + " has changed majors to " + studentMajor);
	}

}
