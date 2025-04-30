package library.circulation;

import book.BookCopy;
import book.BookLoan;
import library.Inventory.Inventory;
import person.employee.receptionist.Receptionist;
import person.member.Member;

public interface CirculationService {
	public static void borrowBook(
			// Departments
			Circulation circulation, Inventory inv,
			// Details
			int bookCopyId, int loanPeriodInDays,
			// Actors
			Member member, Receptionist receptionist) {

		// Get the copy from Inventory department
		BookCopy copy = inv.getAvailableCopyById(bookCopyId);
		// Open a new book loan in Circulation department
		BookLoan loan = circulation.openNewLoan(copy, loanPeriodInDays);
		// Add the loan to the member
		member.getMyBookLoans().add(loan);

		// Log Action
		circulation.getAllLogs()
				.add(new CirculationLog("", CirculationLog.TransactionType.BORROW, 0, loan, member, receptionist));
	}

	public static void returnBook(
			// Departments
			Circulation circulation,
			// Details
			int loanId,
			// Actors
			Member member, Receptionist receptionist) {

		// Get the loan from Circulation department
		BookLoan loan = circulation.getActiveBookLoanByID(loanId);
		// Close the active loan
		loan.finalizeLoan();
		// Remove the loan from the member
		member.getMyBookLoans().remove(loan);

		// Log Action
		circulation.getAllLogs()
				.add(new CirculationLog("", CirculationLog.TransactionType.RETURN, 0, loan, member, receptionist));
	}

	public static void renewBookLoan(
			// Departments
			Circulation circulation,
			// Details
			int loanId, int extensionPeriodInDays,
			// Actors
			Member member, Receptionist receptionist) {

		// Get the loan from Circulation department
		BookLoan loan = circulation.getActiveBookLoanByID(loanId);
		// Extend the loan dueDate by the the extension period
		loan.extendDueDate(extensionPeriodInDays);

		// Log Action
		circulation.getAllLogs().add(new CirculationLog("", CirculationLog.TransactionType.RENEW, extensionPeriodInDays,
				loan, member, receptionist));
	}
}
