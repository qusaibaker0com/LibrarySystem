package book;

public class BookEntry {
	// Final Variables
	private final String ISBN;

	// Instance Variables
	private String title;
	private String author;

	// Constructors
	public BookEntry(String isbn, String title, String author) {
		if (isbn == null || isbn.isBlank())
			throw new IllegalArgumentException("ISBN must not be blank");
		this.ISBN = isbn;
		this.title = title;
		this.author = author;
	}

	// Default Getters
	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	// Default Getters
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
