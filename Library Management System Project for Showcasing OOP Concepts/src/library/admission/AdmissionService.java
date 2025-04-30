package library.admission;

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

	public static void viewAllMembers(
			// Departments
			Admission admission,
			// Actors
			Receptionist receptionisit) {
		admission.getAllMembers().forEach((key, value) -> {
			System.out.println(value.toString() + "\n");
		});

	}
}
