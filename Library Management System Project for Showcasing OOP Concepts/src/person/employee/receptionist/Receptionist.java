package person.employee.receptionist;

import person.employee.Employee;

public class Receptionist extends Employee {
	// Final Variables
	private final String ROLE = "Receptionist";

	// Instance Variables
	private String frontDeskLocation;
	private String shiftTime;

	// Constructors
	public Receptionist(String nationalId, String hireDay, String hireMonth, String hireYear) {

		super(nationalId, hireDay, hireMonth, hireYear);
	}

	public Receptionist(
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

	public String getFrontDeskLocation() {
		return frontDeskLocation;
	}

	public String getShiftTime() {
		return shiftTime;
	}

	// Default Setters
	public void setFrontDeskLocation(String frontDeskLocation) {
		this.frontDeskLocation = frontDeskLocation;
	}

	public void setShiftTime(String shiftTime) {
		this.shiftTime = shiftTime;
	}

	// Other Functions
	@Override
	public String toString() {
		return "🧑‍💼 Receptionist ⇨ [ " + "\n Employee ID : " + getEmployeeId() + " | National ID : " + getNationalId()
				+ " | Hire Date : " + getHireDate() + "\n Role : " + getRole() + " | Salary : " + getSalary()
				+ "\n Name : " + getFirstName() + " " + getLastName() + " | DOB : " + getDateOfBirth() + "\n Phone : "
				+ getPhoneNumber() + " | Email : " + getEmail() + " ]";
	}

}
