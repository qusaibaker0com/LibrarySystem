package book;

import java.time.LocalDate;

public class BookLoan {
	// Static Variables
	private static int loanCounter = 0;

	// Final Variables
	private final int loanId;
	private final BookCopy copy;
	private final LocalDate loanDate;

	// Instance Variables
	private LocalDate dueDate;
	private LocalDate returnDate; // null if the book is still in borrow and not yet returned.

	// Constructors
	public BookLoan(BookCopy copy, int loanPeriodInDays) {
		this.copy = copy;
		this.loanDate = LocalDate.now();
		this.dueDate = LocalDate.now().plusDays(loanPeriodInDays);
		
		this.loanId = loanCounter;
		++loanCounter;
	}

	// Static Counter
	public static int getLoanCounter() {
		return loanCounter;
	}

	// Default Getters

	public int getLoanId() {
		return loanId;
	}

	public BookCopy getCopy() {
		return copy;
	}

	public LocalDate getLoanDate() {
		return loanDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	// Special Setters
	public void setReturnDateToNow() {
		this.returnDate = LocalDate.now();
	}

	// Other Functions
	public void extendDueDate(int extensionPeriodInDays) {
		this.dueDate = this.dueDate.plusDays(extensionPeriodInDays);
	}

	public boolean isActiveLoan() {
		return returnDate != null;
	}

	public void finalizeLoan() {
		this.setReturnDateToNow();
		this.copy.setStatus(BookCopy.CopyAvailabilityStatus.AVAILABLE);
	}

}
