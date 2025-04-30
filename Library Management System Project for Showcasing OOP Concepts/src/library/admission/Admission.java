package library.admission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import person.member.Member;

public final class Admission {
	// Final Variables
	private final HashMap<Integer, Member> MEMBERS;
	private final List<AdmissionLog> LOGS;

	// Constructors
	public Admission() {
		this.MEMBERS = new HashMap<>();
		this.LOGS = new ArrayList<>();
	}

	// Default Getters
	public HashMap<Integer, Member> getAllMembers() {
		return MEMBERS;
	}

	public List<AdmissionLog> getAllLogs() {
		return LOGS;
	}

	// Special Getters
	public Member getVaildMemberById(int memberId) {
		if (!isValidMamberId(memberId))
			throw new IllegalArgumentException("Invalid Member ID!");
		Member m = MEMBERS.get(memberId);
		return m;
	}

	// Other Functions
	public Member createMember(
			// ID
			String nationalId,
			// Full Name
			String firstName, String lastName,
			// Date of Birth
			String birthDay, String birthMonth, String birthYear,
			// Contact Info
			String phoneNumber, String email,
			// Join Date
			String joinDay, String joinMonth, String joinYear) {
		Member m = new Member(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber, email,
				joinDay, joinMonth, joinYear);
		MEMBERS.put(m.getMemberId(), m);
		return m;
	}

	public boolean isValidMamberId(int memberId) {
		return MEMBERS.containsKey(memberId);
	}
}
