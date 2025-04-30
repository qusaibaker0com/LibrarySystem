package library.admission;

import log.Log;
import person.employee.receptionist.Receptionist;
import person.member.Member;

public final class AdmissionLog extends Log {
	// Enums
	public static enum Action {
		VIEW, CREATE, UPDATE, DELETE
	}

	// Final Variables
	private final Action ACTION;
	private final Member MEMBER;
	private final Receptionist RECEPTIONIST;
	private final String UPDATED_ATTRIBUTES; // null in case of actions other than update

	// Constructors
	public AdmissionLog(
			// Log Info
			String msg, Action action, String updatedAttributes,
			// Resources
			Member member,
			// Actors
			Receptionist receptionist) {
		super(msg);
		this.ACTION = action;
		this.MEMBER = member;
		this.RECEPTIONIST = receptionist;
		this.UPDATED_ATTRIBUTES = updatedAttributes;
	}

	// Default Getters
	public Action getAction() {
		return ACTION;
	}

	public Member getMember() {
		return MEMBER;
	}

	public Receptionist getReceptionist() {
		return RECEPTIONIST;
	}

	public String getUpdatedAttributes() {
		return UPDATED_ATTRIBUTES;
	}

}
