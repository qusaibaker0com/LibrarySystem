package person.employee.librarian;

import person.employee.Employee;

public class Librarian extends Employee {
	private final String role = "Librarian";

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

	public String getRole() {
		return role;
	}
}
