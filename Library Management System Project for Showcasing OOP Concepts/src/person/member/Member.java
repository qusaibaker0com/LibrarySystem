package person.member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import book.BookLoan;
import person.Person;

public class Member extends Person {
	// Static Variables
	private static int memberCounter = 0;

	// Final Variables
	private final int MEMBER_ID;
	private final LocalDate JOIN_DATE;
	private final List<BookLoan> MY_BOOK_LOANS;

	// Constructors
	public Member(
			// ID
			String nationalId,
			// Join Date
			String joinDay, String joinMonth, String joinYear) {

		super(nationalId);

		this.JOIN_DATE = MemberValidator.validateJoinDate(joinDay, joinMonth, joinYear);

		this.MY_BOOK_LOANS = new ArrayList<>();
		this.MEMBER_ID = memberCounter;
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

		this.JOIN_DATE = MemberValidator.validateJoinDate(joinDay, joinMonth, joinYear);

		this.MY_BOOK_LOANS = new ArrayList<>();
		this.MEMBER_ID = memberCounter;
		++memberCounter;
	}

	// Default Getters
	public int getMemberId() {
		return MEMBER_ID;
	}

	public LocalDate getJoinDate() {
		return JOIN_DATE;
	}

	public List<BookLoan> getMyBookLoans() {
		return MY_BOOK_LOANS;
	}

	// Other Functions
	@Override
	public String toString() {
		return "🧑‍💼 Member ⇨ [ " + "\n Member ID : " + getMemberId() + " | National ID : " + getNationalId()
				+ " | Join Date : " + getJoinDate() + "\n Name : " + getFirstName() + " " + getLastName() + " | DOB : "
				+ getDateOfBirth() + "\n Phone : " + getPhoneNumber() + " | Email : " + getEmail() + " ]";
	}

}
