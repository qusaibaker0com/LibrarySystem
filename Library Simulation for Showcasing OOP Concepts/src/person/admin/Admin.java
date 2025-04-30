package person.admin;

import person.Person;

public class Admin extends Person {
	// Final Variables
	private final String role = "Admin";

	// Constructors
	public Admin(String nationalId) {
		super(nationalId);
	}

	// Default Getters
	public String getRole() {
		return role;
	}
}
