package com.syscho.statemachine;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	    private Long	id;
	    private String 	item;		// Item to order
	    private Integer number;		// Approval number
	    private String 	note;		// Note
	    private BigDecimal budget;	// Total paid for the order
	    private Date approvalDate;
	    private Date cancelDate;
	    
	    public Order(){}
	    public Order(String item){
	        this.item = item;
	    }
	    
	    public Order(Long id, String item, BigDecimal budget){
	    	this.id = id;
	        this.item = item;
	        this.budget = budget;
	    }
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		public Integer getNumber() {
			return number;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public BigDecimal getBudget() {
			return budget;
		}
		public void setBudget(BigDecimal budget) {
			this.budget = budget;
		}
		
		public Date getApprovalDate() {
			return approvalDate;
		}
		public void setApprovalDate(Date approvalDate) {
			this.approvalDate = approvalDate;
		}
		public Date getCancelDate() {
			return cancelDate;
		}
		public void setCancelDate(Date cancelDate) {
			this.cancelDate = cancelDate;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Order [id=").append(id).append(", item=").append(item).append(", number=").append(number)
					.append(", note=").append(note).append(", budget=").append(budget).append(", approvalDate=")
					.append(approvalDate).append(", cancelDate=").append(cancelDate).append("]");
			return builder.toString();
		}
}
