package person;

import java.time.LocalDate;

public abstract class Person {
	// Final Variables
	private final String NATIONAL_ID;

	// Instance Variables
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String phoneNumber;
	private String email;

	// Constructors
	public Person(String nationalId) {

		this.NATIONAL_ID = PersonValidator.validateNationalId(nationalId);
	}

	public Person(
			// ID
			String nationalId,
			// Full Name
			String firstName, String lastName,
			// Date of Birth
			String birthDay, String birthMonth, String birthYear,
			// Contact Info
			String phoneNumber, String email) {

		this(nationalId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDateOfBirth(birthDay, birthMonth, birthYear);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	// Default Getters
	public String getNationalId() {
		return NATIONAL_ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	// Validated Setters
	public void setFirstName(String firstName) {
		this.firstName = PersonValidator.validateFirstName(firstName);
	}

	public void setLastName(String lastName) {
		this.lastName = PersonValidator.validateLastName(lastName);
	}

	public void setDateOfBirth(String day, String month, String year) {
		this.dateOfBirth = PersonValidator.validateDateOfBirth(day, month, year);
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = PersonValidator.validatePhoneNumber(phoneNumber);
	}

	public void setEmail(String email) {
		this.email = PersonValidator.validateEmail(email);
	}
}
