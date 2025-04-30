package library.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import book.BookCopy;
import book.BookEntry;
import book.BookCopy.CopyType;

public final class Inventory {
	// Final Variables
	private final HashMap<String, BookEntry> BOOK_ENTRIES;
	private final HashMap<Integer, BookCopy> BOOK_COPIES;
	private final List<InventoryLog> LOGS;

	// Constructors
	public Inventory() {
		this.BOOK_ENTRIES = new HashMap<>();
		this.BOOK_COPIES = new HashMap<>();
		this.LOGS = new ArrayList<>();
	}

	// Default Getters
	public HashMap<String, BookEntry> getAllEntries() {
		return BOOK_ENTRIES;
	}

	public HashMap<Integer, BookCopy> getAllCopies() {
		return BOOK_COPIES;
	}

	public List<InventoryLog> getAllLogs() {
		return LOGS;
	}

	// Special Getters
	public BookEntry getEntryByISBN(String ISBN) {
		if (!BOOK_ENTRIES.containsKey(ISBN))
			throw new IllegalArgumentException("Invalid ISBN!");
		return BOOK_ENTRIES.get(ISBN);
	}

	public BookCopy getCopyByID(int COPY_ID) {
		if (!BOOK_COPIES.containsKey(COPY_ID))
			throw new IllegalArgumentException("Invalid Book Copy ID!");
		return BOOK_COPIES.get(COPY_ID);
	}

	public BookCopy getAvailableCopyById(int COPY_ID) {
		BookCopy copy = this.getCopyByID(COPY_ID);
		if (!copy.isAvailableCopy())
			throw new IllegalArgumentException("Requested Copy is NOT Currently Avaliable!");
		return copy;
	}

	public HashMap<Integer, BookCopy> getAvailableBookCopies() {
		HashMap<Integer, BookCopy> availableCopies = new HashMap<>();
		BOOK_COPIES.forEach((copyId, bookCopy) -> {
			if (bookCopy.isAvailableCopy()) {
				availableCopies.put(copyId, bookCopy);
			}
		});
		return availableCopies;
	}

	// Other Functions
	public BookEntry createBookEntry(String isbn, String title, String author) {
		BookEntry be = new BookEntry(isbn, title, author);
		BOOK_ENTRIES.put(be.getISBN(), be);
		return be;
	}

	public BookCopy createBookCopy(String ISBN, CopyType copyType, int weight, int length, int width, int height) {
		BookEntry be = getEntryByISBN(ISBN);
		BookCopy bc = new BookCopy(be, copyType, weight, length, width, height);
		BOOK_COPIES.put(bc.getCopyId(), bc);
		return bc;
	}
}
