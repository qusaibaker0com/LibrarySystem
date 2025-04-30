package library.HumanResources;

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

	public static Employee viewMemberById(
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

	/*
	 * public static void updateEmployeeName(HumanResources hr, Admin admin, int
	 * employeeId, String firstName, String lastName) throws IllegalAccessException
	 * { if (!isValidEmployeeId(hr, employeeId)) throw new
	 * IllegalArgumentException("Invalid Employee Id!"); Employee e =
	 * getMemberById(hr, admin, employeeId); e.setFirstName(firstName);
	 * e.setLastName(lastName); hr.getAllLogs() .add(new HumanResourcesLog("",
	 * HumanResourcesLog.Action.UPDATE, "First Name + Last Name", e, admin)); }
	 * 
	 * public static void updateEmployeeDateOfBirth(HumanResources hr, Admin admin,
	 * int employeeId, String birthDay, String birthMonth, String birthYear) throws
	 * IllegalAccessException { if (!isValidEmployeeId(hr, employeeId)) throw new
	 * IllegalArgumentException("Invalid Employee Id!"); Employee e =
	 * getMemberById(hr, admin, employeeId); e.setDateOfBirth(birthDay, birthMonth,
	 * birthYear); hr.getAllLogs().add(new HumanResourcesLog("",
	 * HumanResourcesLog.Action.UPDATE, "Date of Birth", e, admin)); }
	 * 
	 * public static void updateEmployeeContactInfo(HumanResources hr, Admin admin,
	 * int employeeId, String phoneNumber, String email) throws
	 * IllegalAccessException { if (!isValidEmployeeId(hr, employeeId)) throw new
	 * IllegalArgumentException("Invalid Employee Id!"); Employee e =
	 * getMemberById(hr, admin, employeeId); e.setPhoneNumber(phoneNumber);
	 * e.setEmail(email); hr.getAllLogs().add(new HumanResourcesLog("",
	 * HumanResourcesLog.Action.UPDATE, "Phone Number + Email", e, admin)); }
	 * 
	 * public static void updateEmployeeSalary(HumanResources hr, Admin admin, int
	 * employeeId, String phoneNumber, double salary) throws IllegalAccessException
	 * { if (!isValidEmployeeId(hr, employeeId)) throw new
	 * IllegalArgumentException("Invalid Employee Id!"); Employee e =
	 * getMemberById(hr, admin, employeeId); e.setSalary(salary);
	 * hr.getAllLogs().add(new HumanResourcesLog("",
	 * HumanResourcesLog.Action.UPDATE, "Salary", e, admin)); }
	 */
}
