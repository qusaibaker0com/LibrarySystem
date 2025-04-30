package library.hr;

import person.admin.Admin;
import person.employee.Employee;
import person.employee.librarian.Librarian;
import person.employee.receptionist.Receptionist;

public interface HumanResourcesService {
	public static void addLibrarian(
			// Departments
			HumanResources hr,
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
			Employee supervisor,
			// Actors
			Admin admin) {

		// Add new Librarian in Human Resources department
		Employee e = hr.createLibrarian(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber,
				email, hireDay, hireMonth, hireYear, salary, supervisor);

		// Log Action
		hr.getAllLogs().add(new HumanResourcesLog("", HumanResourcesLog.Action.CREATE, null, e, admin));
	}

	public static void addReceptionist(
			// Departments
			HumanResources hr,
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
			Employee supervisor,
			// Actors
			Admin admin) {

		// Add new Receptionist in Human Resources department
		Employee e = hr.createReceptionist(nationalId, firstName, lastName, birthDay, birthMonth, birthYear,
				phoneNumber, email, hireDay, hireMonth, hireYear, salary, supervisor);

		// Log Action
		hr.getAllLogs().add(new HumanResourcesLog("", HumanResourcesLog.Action.CREATE, null, e, admin));
	}

	public static Employee viewEmployeeById(
			// Departments
			HumanResources hr,
			// Details
			int employeeId,
			// Actors
			Admin admin) {

		// Get the Employee from Human Resources department
		Employee e = hr.getValidEmployeeById(employeeId);

		// Log Action
		hr.getAllLogs().add(new HumanResourcesLog("", HumanResourcesLog.Action.VIEW, null, e, admin));
		return e;
	}

	public static void removeEmployeebyId(
			// Departments
			HumanResources hr,
			// Details
			int employeeId,
			// Actors
			Admin admin) {

		// Get the Employee from Human Resources department
		Employee e = hr.getValidEmployeeById(employeeId);
		// Remove the Employee from Human Resources department
		if (e instanceof Librarian) {
			hr.getAllLibrarians().remove(employeeId);
		} else if (e instanceof Receptionist) {
			hr.getAllReceptionists().remove(employeeId);
		}

		// Log Action
		hr.getAllLogs().add(new HumanResourcesLog("", HumanResourcesLog.Action.DELETE, null, e, admin));
	}

	public static void viewAllEmployees(
			// Departments
			HumanResources hr,
			// Actors
			Admin admin) {
		hr.getAllEmployees().forEach((key, value) -> {
			System.out.println(value.toString() + "\n");
		});
	}
}
