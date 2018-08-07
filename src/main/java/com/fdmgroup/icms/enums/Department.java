package com.fdmgroup.icms.enums;

import java.util.EnumSet;

public enum Department {
	ACCOUNTING ("Accounting"),
	HELP_DESK ("Help Desk"),
	HR ("HR"),
	NETWORKING ("Networking"),
	SALES ("Sales"),
	TELECOM ("Telecom"),
	WEB_APPS("Web Apps"),
	WEB_SERVICES("Web Services");
	
	static EnumSet<Department> ticketHandlers = EnumSet.of(HELP_DESK, NETWORKING, TELECOM, WEB_APPS, WEB_SERVICES);
	
	private final String name;

    private Department(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
