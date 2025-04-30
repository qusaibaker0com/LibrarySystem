
import java.time.LocalDate;

import book.BookCopy.CopyType;
import library.Library;
import library.admission.AdmissionService;
import library.hr.HumanResourcesService;
import library.inventory.InventoryService;
import person.admin.Admin;
import person.employee.librarian.Librarian;
import person.employee.receptionist.Receptionist;
import ui.UIElements;

public class Main {

	public static void main(String[] args) {
		Library lib = initializeLibrary();
		UIElements.printProgramTitle(" Library Mangement System Project for Showcasing OOP Concepts ");

		UIElements.printMenuHeader("List of OOP Concepts applied in this Project");
		String[] concepts = { "Classes and Objects", "Access Modifires", "Encapsulation", "Inheritance", "Overriding",
				"Overloading", "Type Casting", "Abstraction", "Interfaces", "Enums" };
		UIElements.printMenuItems(concepts);

		UIElements.printMenuHeader("List of Some Project Features and Services");
		String[] features = { "Member Admission Service", "Librarain/Receptionist Employment Service",
				"Book Borrow/Retuen/Renew Service", "Library Inventory Mangament Service", "Admin Access Control",
				"Data Validation", "Operations Logging Feature", "And much more, check the project source code ..." };
		UIElements.printMenuItems(features);

		UIElements.printMenuHeader("List of Possible Future Updates and Improvements");
		String[] updates = { "Enhancing interactivity and user engagment", "Fully functionl CLI user interface",
				"Sophisticated validation and error handling process",
				"Expansion and diversification of current services",
				"Building a complete Library System to be used in real world use cases" };
		UIElements.printMenuItems(updates);

		UIElements.printDivider();

		UIElements.printSubHeading("Library Members List");
		AdmissionService.viewAllMembers(lib.getAdmission(), lib.getHumanResources().getAllReceptionists().get(2));

		UIElements.printSubHeading("Library Employees List");
		HumanResourcesService.viewAllEmployees(lib.getHumanResources(), lib.getAdmin());

		UIElements.printSubHeading("Library Book Entries List");
		InventoryService.viewAllBookEntries(lib.getInventory(), lib.getHumanResources().getAllLibrarians().get(0));

		UIElements.printSubHeading("Library Book Copies List");
		InventoryService.viewAllBookCopies(lib.getInventory(), lib.getHumanResources().getAllLibrarians().get(0));
	}

	private static Library initializeLibrary() {
		System.out.println("Initializing library system...");

		// Create admin and library
		Admin admin = new Admin("000000000");
		admin.setFirstName("System");
		admin.setLastName("Administrator");
		admin.setEmail("admin@library.com");
		admin.setPhoneNumber("590000000");
		admin.setDateOfBirth("1", "1", "1990");

		Library lib = new Library(admin);

		// Create some sample data
		createSampleData(lib);

		System.out.println("Library system initialized successfully!\n");
		return lib;
	}

	private static void createSampleData(Library library) {
		LocalDate today = LocalDate.now();
		String currentDay = today.getDayOfMonth() + "";
		String currentMonth = today.getMonthValue() + "";
		String currentYear = today.getYear() + "";

		// Create sample librarians
		HumanResourcesService.addLibrarian(library.getHumanResources(), "111111111", "Kamal", "Husam", "10", "5",
				"1985", "591234567", "kamal@library.com", currentDay, currentMonth, currentYear, 3000.0, null,
				library.getAdmin());

		HumanResourcesService.addLibrarian(library.getHumanResources(), "222222222", "Sara", "Khamis", "15", "8",
				"1990", "592345678", "sara@library.com", currentDay, currentMonth, currentYear, 2800.0, null,
				library.getAdmin());

		// Create sample receptionists
		HumanResourcesService.addReceptionist(library.getHumanResources(), "333333333", "Mazen", "Hamad", "25", "3",
				"1992", "593456789", "mazen@library.com", currentDay, currentMonth, currentYear, 2500.0, null,
				library.getAdmin());

		HumanResourcesService.addReceptionist(library.getHumanResources(), "444444444", "Marwa", "Saleem", "8", "11",
				"1988", "594567890", "marwa@library.com", currentDay, currentMonth, currentYear, 2600.0, null,
				library.getAdmin());

		// Create sample members
		Receptionist sampleReceptionist = (Receptionist) library.getHumanResources().getAllReceptionists().values()
				.iterator().next();

		AdmissionService.addMember(library.getAdmission(), "555555555", "Ahmed", "Khalid", "3", "7", "1995",
				"595678901", "ahmed@example.com", currentDay, currentMonth, currentYear, sampleReceptionist);

		AdmissionService.addMember(library.getAdmission(), "666666666", "Samir", "Jamal", "12", "9", "1998",
				"596789012", "samir@example.com", currentDay, currentMonth, currentYear, sampleReceptionist);

		AdmissionService.addMember(library.getAdmission(), "777777777", "Lana", "Moneeb", "20", "4", "1980",
				"597890123", "lana@example.com", currentDay, currentMonth, currentYear, sampleReceptionist);

		// Create sample book entries
		Librarian sampleLibrarian = (Librarian) library.getHumanResources().getAllLibrarians().values().iterator()
				.next();

		InventoryService.addBookEntry(library.getInventory(), "9780451524935", "1984", "George Orwell",
				sampleLibrarian);

		InventoryService.addBookEntry(library.getInventory(), "9780061120084", "To Kill a Mockingbird", "Harper Lee",
				sampleLibrarian);

		InventoryService.addBookEntry(library.getInventory(), "9780141439518", "Pride and Prejudice", "Jane Austen",
				sampleLibrarian);

		// Create sample book copies
		InventoryService.addBookCopy(library.getInventory(), "9780451524935", CopyType.Physical, 300, 20, 15, 3,
				sampleLibrarian);

		InventoryService.addBookCopy(library.getInventory(), "9780451524935", CopyType.Physical, 300, 20, 15, 3,
				sampleLibrarian);

		InventoryService.addBookCopy(library.getInventory(), "9780061120084", CopyType.Physical, 350, 22, 15, 3,
				sampleLibrarian);

		InventoryService.addBookCopy(library.getInventory(), "9780141439518", CopyType.Digital, 0, 0, 0, 0,
				sampleLibrarian);
	}

}
