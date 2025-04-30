package library.HumanResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import person.employee.Employee;
import person.employee.librarian.Librarian;
import person.employee.receptionist.Receptionist;

public final class HumanResources {
	// Final Variables
	private final HashMap<Integer, Librarian> LIBRARIANS;
	private final HashMap<Integer, Receptionist> RECEPTIONISTS;
	private final List<HumanResourcesLog> LOGS;

	// Constructors
	public HumanResources() {
		this.LIBRARIANS = new HashMap<>();
		this.RECEPTIONISTS = new HashMap<>();
		this.LOGS = new ArrayList<>();
	}

	// Getters
	public HashMap<Integer, Librarian> getAllLibrarians() {
		return LIBRARIANS;
	}

	public HashMap<Integer, Receptionist> getAllReceptionists() {
		return RECEPTIONISTS;
	}

	public List<HumanResourcesLog> getAllLogs() {
		return LOGS;
	}

	// Special Getters
	public HashMap<Integer, Employee> getAllEmployees() {
		HashMap<Integer, Employee> employees = new HashMap<>();
		employees.putAll(LIBRARIANS);
		employees.putAll(RECEPTIONISTS);
		return employees;
	}

	public Employee getValidEmployeeById(int employeeId) {
		Employee e;
		if (!isValidEmployeeId(employeeId))
			throw new IllegalArgumentException("Invalid Emplyee ID!");
		if (LIBRARIANS.containsKey(employeeId)) {
			e = LIBRARIANS.get(employeeId);
		} else {
			e = RECEPTIONISTS.get(employeeId);
		}
		return e;
	}

	// Other Functions
	public Librarian createLibrarian(
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
		Librarian e = new Librarian(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber,
				email, hireDay, hireMonth, hireYear, salary, supervisor);
		LIBRARIANS.put(e.getEmployeeId(), e);
		return e;
	}

	public Receptionist createReceptionist(
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
		Receptionist e = new Receptionist(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber,
				email, hireDay, hireMonth, hireYear, salary, supervisor);
		RECEPTIONISTS.put(e.getEmployeeId(), e);
		return e;
	}

	public boolean isValidEmployeeId(int employeeId) {
		return LIBRARIANS.containsKey(employeeId) || RECEPTIONISTS.containsKey(employeeId);
	}

}
