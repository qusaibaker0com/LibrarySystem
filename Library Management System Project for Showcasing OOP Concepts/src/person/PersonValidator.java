package person;

import java.time.LocalDate;
import java.util.regex.Pattern;

public interface PersonValidator {
	// Static Variables
	public static final String PALESTINE_ID_REGEX = "^\\d{9}$";
	public static final String PALESTINE_MOBILE_REGEX = "^(?:(?:\\+970|\\+972|00970|00972|0)\\s*(?:59|56)|(?:59|56))\\s*[0-9]{7}$";
	public static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

	// Validators
	public static String validateNationalId(String nationalId) {
		if (!PersonValidator.isValidNationalId(nationalId))
			throw new IllegalArgumentException("Natiaonal ID is invalid!");
		return nationalId;
	}

	public static String validateFirstName(String firstName) {
		if (!PersonValidator.isValidFirstName(firstName))
			throw new IllegalArgumentException("First Name is invalid!");
		return firstName;
	}

	public static String validateLastName(String lastName) {
		if (!PersonValidator.isValidLastName(lastName))
			throw new IllegalArgumentException("Last Name is invalid!");
		return lastName;
	}

	public static LocalDate validateDateOfBirth(String day, String month, String year) {
		if (!PersonValidator.isValidDateOfBirth(day, month, year))
			throw new IllegalArgumentException("Date of Birth is invalid!");
		int yearInt = Integer.parseInt(year);
		int monthInt = Integer.parseInt(month);
		int dayInt = Integer.parseInt(day);
		return LocalDate.of(yearInt, monthInt, dayInt);
	}

	public static String validatePhoneNumber(String phoneNumber) {
		if (!PersonValidator.isValidPhoneNumber(phoneNumber))
			throw new IllegalArgumentException("Phone Number is invalid!");
		return phoneNumber;
	}

	public static String validateEmail(String email) {
		if (!PersonValidator.isValidEmail(email))
			throw new IllegalArgumentException("Email is invalid!");
		return email;
	}

	// Validation Checks
	public static boolean isValidNationalId(String nationalId) {
		String normalizedID = nationalId.replaceAll("[^0-9]", "");
		return Pattern.matches(PALESTINE_ID_REGEX, normalizedID);
	}

	public static boolean isValidFirstName(String firstName) {
		return firstName.length() > 2 ? true : false;
	}

	public static boolean isValidLastName(String lastName) {
		return lastName.length() > 2 ? true : false;
	}

	public static boolean isValidDateOfBirth(String day, String month, String year) {
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

	public static boolean isValidPhoneNumber(String phoneNumber) {
		String normalizedNumber = phoneNumber.replaceAll("[^0-9]", "");
		return Pattern.matches(PALESTINE_MOBILE_REGEX, normalizedNumber);
	}

	public static boolean isValidEmail(String email) {
		return Pattern.matches(EMAIL_REGEX, email);
	}
}
