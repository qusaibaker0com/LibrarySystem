package person.employee;

import java.time.LocalDate;

public interface EmployeeValidator {
	// Validators
	public static LocalDate validateHireDate(String day, String month, String year) {
		if (!isValidHireDate(day, month, year))
			throw new IllegalArgumentException("Invalid Hire Date!");
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		int dayInt = Integer.parseInt(day);
		return LocalDate.of(yearInt, monthInt, dayInt);
	}

	// Validation Checks
	public static boolean isValidHireDate(String day, String month, String year) {
		try {
			int yearInt = Integer.parseInt(year);
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			LocalDate.of(yearInt, monthInt, dayInt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
