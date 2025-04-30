package library;

import library.admission.Admission;
import library.circulation.Circulation;
import library.hr.HumanResources;
import library.inventory.Inventory;
import person.admin.Admin;

public class Library {
	// Final Variables
	private final Admin ADMIN;
	private final Admission ADMISSION;
	private final HumanResources HUMAN_RESOURCES;
	private final Inventory INVENTORY;
	private final Circulation CIRCULATION;

	// Constructors
	public Library(Admin admin) {
		this.ADMIN = admin;
		this.ADMISSION = new Admission();
		this.HUMAN_RESOURCES = new HumanResources();
		this.INVENTORY = new Inventory();
		this.CIRCULATION = new Circulation();
	}

	// Default Getters
	public Admin getAdmin() {
		return ADMIN;
	}

	public Admission getAdmission() {
		return ADMISSION;
	}

	public HumanResources getHumanResources() {
		return HUMAN_RESOURCES;
	}

	public Inventory getInventory() {
		return INVENTORY;
	}

	public Circulation getCirculation() {
		return CIRCULATION;
	}

}
