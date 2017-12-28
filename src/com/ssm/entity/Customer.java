package com.ssm.entity;

public class Customer {
	
	private Integer cusId;
	private String cusName;
	private String cusAddr;
	
	public Customer() {
		super();
	}

	public Customer(Integer cusId, String cusName, String cusAddr) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusAddr = cusAddr;
	}

	public Integer getCusId() {
		return cusId;
	}

	public void setCusId(Integer cusId) {
		this.cusId = cusId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddr() {
		return cusAddr;
	}

	public void setCusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", cusName=" + cusName + ", cusAddr=" + cusAddr + "]";
	}
	
	

}
