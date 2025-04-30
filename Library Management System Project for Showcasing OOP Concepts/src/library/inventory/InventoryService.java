package library.inventory;

import book.BookCopy;
import book.BookEntry;
import book.BookCopy.CopyType;
import person.employee.librarian.Librarian;

public interface InventoryService {

	public static void addBookEntry(
			// Departments
			Inventory inv,
			// Details
			String isbn, String title, String author,
			// Actors
			Librarian librarian) {

		// Create a new Book Entry
		BookEntry be = inv.createBookEntry(isbn, title, author);

		// Log Action
		inv.getAllLogs().add(new InventoryLog("", InventoryLog.Action.CREATE, be, null, librarian));
	}

	public static void addBookCopy(
			// Departments
			Inventory inv,
			// Details
			String ISBN, CopyType copyType, int weight, int length, int width, int height,
			// Actors
			Librarian librarian) {

		// Create a new Book Copy
		BookCopy bc = inv.createBookCopy(ISBN, copyType, weight, length, width, height);

		// Log Action
		inv.getAllLogs().add(new InventoryLog("", InventoryLog.Action.CREATE, null, bc, librarian));
	}

	public static void viewAllBookEntries(
			// Departments
			Inventory inv,
			// Actors
			Librarian librarian) {
		inv.getAllEntries().forEach((key, value) -> {
			System.out.println(value.toString() + "\n");
		});
	}

	public static void viewAllBookCopies(
			// Departments
			Inventory inv,
			// Actors
			Librarian librarian) {
		inv.getAllCopies().forEach((key, value) -> {
			System.out.println(value.toString() + "\n");
		});
	}
}
