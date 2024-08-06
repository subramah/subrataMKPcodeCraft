package com.example.banking.dto;


public class TransactionDto {
	private int id;
    private String accountHolderName;
    private int accountId;
    private double openingAmount;
    private double amount;
    private String type;
    private double closingAmount;
	
	public TransactionDto(int id, String accountHolderName, int accountId, double openingAmount, double amount,
			double closingAmount,String type) {
		super();
		this.id = id;
		this.accountHolderName = accountHolderName;
		this.accountId = accountId;
		this.openingAmount = openingAmount;
		this.amount = amount;
		this.closingAmount = closingAmount;
		this.type = type;
	}
	public TransactionDto() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getOpeningAmount() {
		return openingAmount;
	}
	public void setOpeningAmount(double openingAmount) {
		this.openingAmount = openingAmount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	@Override
	public String toString() {
		return "TransactionDto [id=" + id + ", accountHolderName=" + accountHolderName + ", account_id=" + accountId
				+ ", openingAmount=" + openingAmount + ", amount=" + amount + ", closingAmount=" + closingAmount
				+ ", getId()=" + getId() + ", getAccountHolderName()=" + getAccountHolderName() + ", getAccount_id()="
				+ getAccountId() + ", getOpeningAmount()=" + getOpeningAmount() + ", getAmount()=" + getAmount()
				+ ", getClosingAmount()=" + getClosingAmount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
}
