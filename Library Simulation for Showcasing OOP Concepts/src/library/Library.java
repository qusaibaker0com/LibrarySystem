package library;

import library.Admission.Admission;
import library.HumanResources.HumanResources;
import library.Inventory.Inventory;
import library.circulation.Circulation;
import person.admin.Admin;

public class Library {
	// Final Variables
	private final Admin admin;
	private final Admission admission;
	private final HumanResources humanResources;
	private final Inventory inventory;
	private final Circulation circulation;

	// Constructors
	public Library(Admin admin) {
		this.admin = admin;
		this.admission = new Admission();
		this.humanResources = new HumanResources();
		this.inventory = new Inventory();
		this.circulation = new Circulation();
	}

	// Getters
	public Admin getAdmin() {
		return admin;
	}

	public Admission getAdmission() {
		return admission;
	}

	public HumanResources getHumanResources() {
		return humanResources;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Circulation getCirculation() {
		return circulation;
	}

}
