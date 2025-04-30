package library.Inventory;

import book.BookCopy;
import book.BookEntry;
import log.Log;
import person.employee.librarian.Librarian;

public final class InventoryLog extends Log {
	// Enums
	public static enum Action {
		VIEW, CREATE, UPDATE, DELETE
	}

	// Final Variables
	private final Action ACTION;
	private final BookEntry ENTRY; // null if not used by a method of a service
	private final BookCopy COPY; // null if not used by a method of a service
	private final Librarian LIBRARIAN;
	
	//Constructors
	public InventoryLog(
			// Log Info
			String message, Action action,
			// Resources
			BookEntry entry, BookCopy copy,
			// Actors
			Librarian librarian) {
		super(message);
		ACTION = action;
		ENTRY = entry;
		COPY = copy;
		LIBRARIAN = librarian;
	}
	
	// Default Getters
	public Action getACTION() {
		return ACTION;
	}

	public BookEntry getENTRY() {
		return ENTRY;
	}

	public BookCopy getCOPY() {
		return COPY;
	}

	public Librarian getLIBRARIAN() {
		return LIBRARIAN;
	}

}
