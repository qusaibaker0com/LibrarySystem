package person.member;

import java.time.LocalDate;

public interface MemberValidator {
	// Validators
	public static LocalDate validateJoinDate(String day, String month, String year) {
		if (!isValidJoinDate(day, month, year))
			throw new IllegalArgumentException("Invalid Join Date!");
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		int dayInt = Integer.parseInt(day);
		return LocalDate.of(yearInt, monthInt, dayInt);
	}

	// Validation Checks
	public static boolean isValidJoinDate(String day, String month, String year) {
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
