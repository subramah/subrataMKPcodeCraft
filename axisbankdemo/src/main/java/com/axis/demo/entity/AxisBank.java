package com.axis.demo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="axisbank3")
public class AxisBank {
	@EmbeddedId
	private AxisBankEmbaded embadedId;
	private String bankname;
	//private String ifsc;
	private String branch;
	private float minbalance;
	public AxisBankEmbaded getEmbadedId() {
		return embadedId;
	}
	public void setEmbadedId(AxisBankEmbaded embadedId) {
		this.embadedId = embadedId;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public float getMinbalance() {
		return minbalance;
	}
	public void setMinbalance(float minbalance) {
		this.minbalance = minbalance;
	}
	public AxisBank() {
		super();
	}
	public AxisBank(AxisBankEmbaded embadedId, String bankname, String branch, float minbalance) {
		super();
		this.embadedId = embadedId;
		this.bankname = bankname;
		this.branch = branch;
		this.minbalance = minbalance;
	}
	
	
	
}
