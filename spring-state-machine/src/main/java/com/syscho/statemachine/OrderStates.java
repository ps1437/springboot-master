package com.syscho.statemachine;
public enum OrderStates {
    CREATED ("New order"), 
    APPROVED ("Approved"),
    CANCELLED ("Cancelled"),
    DENIED ("Denied"),
    PROCESSED ("Processed");
	
    private String description;
	
    private OrderStates(String description) {
        this.description = description;
    }
	
    public String getDescription() {
        return this.description;
    }
}