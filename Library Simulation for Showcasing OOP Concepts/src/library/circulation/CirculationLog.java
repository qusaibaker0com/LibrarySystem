package library.circulation;

import book.BookLoan;
import log.Log;
import person.employee.receptionist.Receptionist;
import person.member.Member;

public final class CirculationLog extends Log {
	// Enums
	public enum TransactionType {
		BORROW, RETURN, RENEW
	}

	// Final Variables
	private final TransactionType TYPE;
	private final int EXTENSION_PERIOD_IN_DAYS;
	private final BookLoan BOOK_LOAN;
	private final Member MEMBER;
	private final Receptionist RECEPTIONIST;

	// Constructors
	public CirculationLog(
			// Log Info
			String msg, TransactionType type, int extentionPeriodInDays,
			// Resource
			BookLoan bookLoan,
			// Actors
			Member memebr, Receptionist receptionist) {
		super(msg);
		this.TYPE = type;
		this.EXTENSION_PERIOD_IN_DAYS = extentionPeriodInDays;
		this.BOOK_LOAN = bookLoan;
		this.MEMBER = memebr;
		this.RECEPTIONIST = receptionist;
	}

	// Default Getters
	public TransactionType getType() {
		return TYPE;
	}

	public int getExtentionPeriodInDays() {
		return EXTENSION_PERIOD_IN_DAYS;
	}

	public BookLoan getBookLoan() {
		return BOOK_LOAN;
	}

	public Member getMemebr() {
		return MEMBER;
	}

	public Receptionist getReceptionist() {
		return RECEPTIONIST;
	}

}
