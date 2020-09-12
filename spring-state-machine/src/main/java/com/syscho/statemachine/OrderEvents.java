package com.syscho.statemachine;
public enum OrderEvents {
    APPROVE ("Approve order"), 
    DENY ("Deny order"),
    CANCEL ("Calcel order"),
    PROCESS ("Process order");
	
    private String description;
	
    private OrderEvents(String description) {
        this.description = description;
    }
	
    public String getDescription() {
        return this.description;
    }
}