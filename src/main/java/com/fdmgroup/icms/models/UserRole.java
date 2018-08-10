package com.fdmgroup.icms.models;

public enum UserRole {
	GENERAL_USER ("General User"),
	DEPARTMENT_ADMINISTRATOR ("Department Administrator"),
	GENERAL_ADMINISTRATOR ("General Administrator");
	
	private final String name;       

    private UserRole(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
