package library.Admission;

import person.employee.receptionist.Receptionist;
import person.member.Member;

public interface AdmissionService {

	public static void addMember(
			// Departments
			Admission admission,
			// ID
			String nationalId,
			// Full Name
			String firstName, String lastName,
			// Date of Birth
			String birthDay, String birthMonth, String birthYear,
			// Contact Info
			String phoneNumber, String email,
			// Join Date
			String joinDay, String joinMonth, String joinYear,
			// Actors
			Receptionist receptionisit) {

		// Add a new Member in Admission department
		Member m = admission.createMember(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber,
				email, joinDay, joinMonth, joinYear);

		// Log Action
		admission.getAllLogs().add(new AdmissionLog("", AdmissionLog.Action.CREATE, null, m, receptionisit));
	}

	public static Member viewMemberById(
			// Departments
			Admission admission,
			// Details
			int memberId,
			// Actors
			Receptionist receptionisit) {

		// Get the Member details from Admission department
		Member m = admission.getVaildMemberById(memberId);

		// Log Action
		admission.getAllLogs().add(new AdmissionLog("", AdmissionLog.Action.VIEW, null, m, receptionisit));
		return m;
	}

	public static void removeMemberbyId(
			// Departments
			Admission admission,
			// Details
			int memberId,
			// Actors
			Receptionist receptionisit) {

		// Get the Member details from Admission department
		Member m = admission.getVaildMemberById(memberId);
		// Remove the Member form Admission department
		admission.getAllMembers().remove(memberId);

		// Log Action
		admission.getAllLogs().add(new AdmissionLog("", AdmissionLog.Action.DELETE, null, m, receptionisit));
	}

	/*
	 * public static void updateMemberName(Admission admission, Receptionist
	 * receptionisit, int memberId, String firstName, String lastName) throws
	 * IllegalAccessException { if (!isValidMamberId(admission, memberId)) throw new
	 * IllegalArgumentException("Invalid Member Id!"); Member m =
	 * getMemberById(admission, receptionisit, memberId); m.setFirstName(firstName);
	 * m.setLastName(lastName); admission.getLogs() .add(new AdmissionLog("",
	 * AdmissionLog.Action.UPDATE, "First Name + Last Name", m, receptionisit)); }
	 * 
	 * public static void updateMemberDateOfBirth(Admission admission, Receptionist
	 * receptionisit, int memberId, String birthDay, String birthMonth, String
	 * birthYear) throws IllegalAccessException { if (!isValidMamberId(admission,
	 * memberId)) throw new IllegalArgumentException("Invalid Member Id!"); Member m
	 * = getMemberById(admission, receptionisit, memberId);
	 * m.setDateOfBirth(birthDay, birthMonth, birthYear);
	 * admission.getLogs().add(new AdmissionLog("", AdmissionLog.Action.UPDATE,
	 * "Date of Birth", m, receptionisit)); }
	 * 
	 * public static void updateMemberContactInfo(Admission admission, Receptionist
	 * receptionisit, int memberId, String phoneNumber, String email) throws
	 * IllegalAccessException { if (!isValidMamberId(admission, memberId)) throw new
	 * IllegalArgumentException("Invalid Member Id!"); Member m =
	 * getMemberById(admission, receptionisit, memberId);
	 * m.setPhoneNumber(phoneNumber); m.setEmail(email); admission.getLogs()
	 * .add(new AdmissionLog("", AdmissionLog.Action.UPDATE, "Phone Number + Email",
	 * m, receptionisit)); }
	 */
}
