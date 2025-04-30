package person.employee.receptionist;

import person.employee.Employee;

public class Receptionist extends Employee {
	private final String role = "Receptionist";
	private String frontDeskLocation;
	private String shiftTime;

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

	public void setFrontDeskLocation(String frontDeskLocation) {
		this.frontDeskLocation = frontDeskLocation;
	}

	public void setShiftTime(String shiftTime) {
		this.shiftTime = shiftTime;
	}

	public String getRole() {
		return role;
	}

	public String getFrontDeskLocation() {
		return frontDeskLocation;
	}

	public String getShiftTime() {
		return shiftTime;
	}

}
