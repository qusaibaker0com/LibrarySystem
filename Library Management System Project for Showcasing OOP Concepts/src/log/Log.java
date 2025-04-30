package log;

import java.time.LocalDateTime;

public class Log {
	// Static Variables
	private static int logCounter = 0;

	// Final Variables
	private final int LOG_ID;
	private final String MESSAGE;
	private final LocalDateTime LOG_DATE;

	// Constructors
	public Log(String message) {
		this.MESSAGE = message;
		this.LOG_DATE = LocalDateTime.now();
		
		this.LOG_ID = logCounter;
		++logCounter;
	}

	// Static Getters
	public static int getLogCounter() {
		return logCounter;
	}

	// Default Getters
	public int getLogId() {
		return LOG_ID;
	}

	public String getMessage() {
		return MESSAGE;
	}

	public LocalDateTime getLogDate() {
		return LOG_DATE;
	}

}
