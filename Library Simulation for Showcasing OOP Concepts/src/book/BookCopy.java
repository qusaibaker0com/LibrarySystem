package book;

public class BookCopy {
	// Enums
	public static enum CopyAvailabilityStatus {
		AVAILABLE, BORROWED, LOST
	}

	public static enum CopyType {
		Physical, Digital
	}

	// Static Variables
	private static int copyCounter = 0;

	// Final Variables
	private final int copyId;
	private final BookEntry entry;
	private final CopyType copyType;
	private final int weight;
	private final int length;
	private final int width;
	private final int height;

	// Instance Variables
	private CopyAvailabilityStatus status;

	// Constructors
	public BookCopy(BookEntry entry, CopyType copyType, int weight, int length, int width, int height) {
		this.entry = entry;
		this.status = CopyAvailabilityStatus.AVAILABLE;
		this.copyType = copyType;
		this.weight = weight;
		this.length = length;
		this.width = width;
		this.height = height;
		
		this.copyId = copyCounter;
		++copyCounter;
	}

	// Static Getters
	public static int getCopyCounter() {
		return copyCounter;
	}

	// Default Getters
	public int getCopyId() {
		return copyId;
	}

	public static void setCopyCounter(int copyCounter) {
		BookCopy.copyCounter = copyCounter;
	}

	public BookEntry getEntry() {
		return entry;
	}

	public CopyType getCopyType() {
		return copyType;
	}

	public int getWeight() {
		return weight;
	}

	public int getLength() {
		return length;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public CopyAvailabilityStatus getStatus() {
		return status;
	}

	// Default Setters
	public void setStatus(CopyAvailabilityStatus status) {
		this.status = status;
	}

	// Other Functions
	public boolean isAvailableCopy() {
		return status == CopyAvailabilityStatus.AVAILABLE;
	}

}
