package com.fdmgroup.icms.enums;

public enum Priority {
	CRITICAL ("Critical"),
	MAJOR ("Major"),
	NORMAL ("Normal"),
	MINOR ("Minor");
	
	private final String name;       

    private Priority(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
       return this.name;
    }
}
