package com.transaction.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private Long accountId;
    private double openingAmount;
    private double amount;
    private double closingAmount;
    private String type;
    
    
    
    
	public Transaction() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccount_id(Long accountId) {
		this.accountId = accountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public double getOpeningAmount() {
		return openingAmount;
	}
	public void setOpeningAmount(double openingAmount) {
		this.openingAmount = openingAmount;
	}
	public double getClosingAmount() {
		return closingAmount;
	}
	public void setClosingAmount(double closingAmount) {
		this.closingAmount = closingAmount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
    
}
