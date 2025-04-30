package library.HumanResources;

import log.Log;
import person.admin.Admin;
import person.employee.Employee;

public final class HumanResourcesLog extends Log {
	// Enums
	public static enum Action {
		VIEW, CREATE, UPDATE, DELETE
	}

	// Final Variables
	private final Action ACTION;
	private final Employee EMPLOYEE;
	private final Admin ADMIN;
	private final String UPDATED_ATTRIBUTES; // null in case of actions other than update

	// Constructors
	public HumanResourcesLog(
			// Log Info
			String msg, Action action, String updatedAttributes,
			// Resources
			Employee employee,
			// Actors
			Admin admin) {
		super(msg);
		this.ACTION = action;
		this.EMPLOYEE = employee;
		this.ADMIN = admin;
		this.UPDATED_ATTRIBUTES = updatedAttributes;
	}

	// Default Getters
	public Action getAction() {
		return ACTION;
	}

	public Employee getEmployee() {
		return EMPLOYEE;
	}

	public Admin getAdmin() {
		return ADMIN;
	}

	public String getupdatedAttributes() {
		return UPDATED_ATTRIBUTES;
	}

}
