package person.employee;

import java.time.LocalDate;

import person.Person;

public abstract class Employee extends Person {
	// Static Variables
	private static int employeeCounter = 0;

	// Final Variables
	private final int employeeId;
	private final LocalDate hireDate;

	// Instance Variables
	private double salary;
	private Employee supervisor;

	// Constructors
	public Employee(
			// ID
			String nationalId,
			// HireDate
			String hireDay, String hireMonth, String hireYear) {

		super(nationalId);

		this.hireDate = EmployeeValidator.validateHireDate(hireDay, hireMonth, hireYear);

		this.employeeId = employeeCounter;
		++employeeCounter;
	}

	public Employee(
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

		super(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber, email);

		this.setSalary(salary);
		this.setSupervisor(supervisor);

		this.hireDate = EmployeeValidator.validateHireDate(hireDay, hireMonth, hireYear);

		this.employeeId = employeeCounter;
		++employeeCounter;
	}

	// Static Getters
	public static int getEmployeeCounter() {
		return employeeCounter;
	}

	// Default Getters
	public int getEmployeeId() {
		return employeeId;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	// Default Setters
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

}
