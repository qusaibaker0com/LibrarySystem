package ui;

public interface UIElements {
	public static final String RESET = "\u001B[0m";
	public static final String BOLD = "\u001B[1m";
	public static final String CYAN = "\u001B[36m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String MAGENTA = "\u001B[35m";

	public static void printProgramTitle(String title) {
		int padding = 6;
		int totalLength = title.length() + padding * 2;

		String outer = MAGENTA + BOLD + "*".repeat(totalLength + 10) + RESET;
		String innerTop = MAGENTA + BOLD + "**  " + CYAN + "╔" + "═".repeat(totalLength) + "╗  **" + RESET;
		String content = MAGENTA + "**  " + CYAN + BOLD + "║" + "▒".repeat(padding) + title + "▒".repeat(padding)
				+ "║  **" + RESET;
		String innerBot = MAGENTA + BOLD + "**  " + CYAN + "╚" + "═".repeat(totalLength) + "╝  **" + RESET;

		System.out.println(outer);
		System.out.println(innerTop);
		System.out.println(content);
		System.out.println(innerBot);
		System.out.println(outer);
	}

	public static void printMenuHeader(String headerText) {
		int pad = 4;
		String padded = " ".repeat(pad) + headerText + " ".repeat(pad);
		String border = "═".repeat(padded.length());
		System.out.println(GREEN + BOLD + "╔" + border + "╗");
		System.out.println("║" + padded + "║");
		System.out.println("╚" + border + "╝" + RESET);
	}

	public static void printSubHeading(String text) {
		String line = "─".repeat(text.length() + 4);
		System.out.println(BOLD + CYAN + "┌" + line + "┐");
		System.out.println("│  " + text + "  │");
		System.out.println("└" + line + "┘" + RESET);
	}

	public static void printMenuItems(String[] items) {
		for (int i = 0; i < items.length; i++) {
			String idx = i < 9 ? " " + (i + 1) : String.valueOf(i + 1);
			System.out.println(GREEN + BOLD + idx + ") " + RESET + YELLOW + "➜ " + items[i] + RESET);
		}
	}

	public static void printDivider() {
		System.out.println();
		String pattern = MAGENTA + BOLD + "≡" + CYAN + "≡" + YELLOW + "≡" + GREEN + "≡" + RESET;
		System.out.println(pattern.repeat(15));
		System.out.println();
	}
}
