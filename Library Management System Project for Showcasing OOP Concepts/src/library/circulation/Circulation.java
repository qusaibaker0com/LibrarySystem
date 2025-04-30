package library.circulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import book.BookCopy;
import book.BookLoan;

public final class Circulation {
	// Final Variables
	private final HashMap<Integer, BookLoan> BOOK_LOANS;
	private final List<CirculationLog> LOGS;

	// Constructors
	public Circulation() {
		this.BOOK_LOANS = new HashMap<>();
		this.LOGS = new ArrayList<>();
	}

	// Default Getters
	public HashMap<Integer, BookLoan> getAllBookLoans() {
		return BOOK_LOANS;
	}

	public List<CirculationLog> getAllLogs() {
		return LOGS;
	}

	// Special Getters
	public BookLoan getBookLoanByID(int loanID) {
		if (!BOOK_LOANS.containsKey(loanID))
			throw new IllegalArgumentException("Invalid Loan ID!");
		return BOOK_LOANS.get(loanID);
	}

	public BookLoan getActiveBookLoanByID(int loanID) {
		BookLoan loan = getBookLoanByID(loanID);
		if (!loan.isActiveLoan())
			throw new IllegalArgumentException("Loan is not Active, the Book Copy is already Returned!");
		return loan;
	}

	public HashMap<Integer, BookLoan> getAllActiveBookLoans() {
		HashMap<Integer, BookLoan> activeLoans = new HashMap<>();
		this.BOOK_LOANS.forEach((loanId, loan) -> {
			if (loan.isActiveLoan())
				activeLoans.put(loanId, loan);
		});
		return activeLoans;
	}

	// Other Functions
	public BookLoan openNewLoan(BookCopy copy, int loanPeriodInDays) {
		copy.setStatus(BookCopy.CopyAvailabilityStatus.BORROWED);
		BookLoan loan = new BookLoan(copy, loanPeriodInDays);
		this.BOOK_LOANS.put(loan.getLoanId(), loan);
		return loan;
	}

}
