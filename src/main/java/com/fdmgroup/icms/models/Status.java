package com.fdmgroup.icms.models;

public enum Status {
	SUBMITTED ("Submitted"),
	IN_PROGRESS ("In Progress"),
	RESOLVED ("Resolved"),
	CLOSED ("Closed"),
	REJECTED ("Rejected"),
	CHANGE_REQUESTED ("Change Requested");
	
	private final String name;       

    private Status(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
