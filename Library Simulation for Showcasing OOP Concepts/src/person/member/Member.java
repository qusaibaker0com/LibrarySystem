package person.member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import book.BookLoan;
import person.Person;

public class Member extends Person {
	private static int memberCounter = 0;
	private final int memberId;
	private final LocalDate joinDate;
	private final List<BookLoan> myBookLoans;

	public Member(
			// ID
			String nationalId,
			// Join Date
			String joinDay, String joinMonth, String joinYear) {

		super(nationalId);

		this.joinDate = MemberValidator.validateJoinDate(joinDay, joinMonth, joinYear);

		this.myBookLoans = new ArrayList<>();
		this.memberId = memberCounter;
		++memberCounter;
	}

	public Member(
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

		super(nationalId, firstName, lastName, birthDay, birthMonth, birthYear, phoneNumber, email);

		this.joinDate = MemberValidator.validateJoinDate(joinDay, joinMonth, joinYear);

		this.myBookLoans = new ArrayList<>();
		this.memberId = memberCounter;
		++memberCounter;
	}

	public int getMemberId() {
		return memberId;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public List<BookLoan> getMyBookLoans() {
		return myBookLoans;
	}
}
