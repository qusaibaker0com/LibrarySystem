package log;

import java.time.LocalDateTime;

public class Log {
	// Static Variables
	private static int logCounter = 0;

	// Final Variables
	private final int logId;
	private final String message;
	private final LocalDateTime logDate;

	// Constructors
	public Log(String message) {
		this.message = message;
		this.logDate = LocalDateTime.now();
		
		this.logId = logCounter;
		++logCounter;
	}

	// Static Getters
	public static int getLogCounter() {
		return logCounter;
	}

	// Default Getters
	public int getLogId() {
		return logId;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getLogDate() {
		return logDate;
	}

}
