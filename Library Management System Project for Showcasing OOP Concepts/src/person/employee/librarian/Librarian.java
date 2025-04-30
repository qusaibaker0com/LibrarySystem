package person.employee.librarian;

import person.employee.Employee;

public class Librarian extends Employee {
	// Final Variables
	private final String ROLE = "Librarian";

	// Constructors
	public Librarian(String nationalId, String hireDay, String hireMonth, String hireYear) {

		super(nationalId, hireDay, hireMonth, hireYear);
	}

	public Librarian(
			// ID
			String nationalId,
			// Full Name
			String firstName, String lastName,
			// Date of Birth
			String birthDay, String birthMonth, String birthYear,
			// Contact Info
			String phoneNumber, String email,
			// Hire Date
			String hireDay, String hireMonth, String hireYear,
			// Salary
			double salary,
			// Supervisor
			Employee supervisor) {

		super(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber, email, hireDay, hireMonth,
				hireYear, salary, supervisor);
	}

	// Default Getters
	public String getRole() {
		return ROLE;
	}

	// Other Functions
	@Override
	public String toString() {
		return "🧑‍💼 Librarian ⇨ [ " + "\n Employee ID : " + getEmployeeId() + " | National ID : " + getNationalId()
				+ " | Hire Date : " + getHireDate() + "\n Role : " + getRole() + " | Salary : " + getSalary()
				+ "\n Name : " + getFirstName() + " " + getLastName() + " | DOB : " + getDateOfBirth() + "\n Phone : "
				+ getPhoneNumber() + " | Email : " + getEmail() + " ]";
	}

}
