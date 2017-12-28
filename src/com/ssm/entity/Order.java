package com.ssm.entity;

import java.util.Date;

public class Order {
	
	private Integer odrId;
	private Integer odrCustomerId;
	private String odrCustomerName;
	private String odrDeliverAddr;
	private Date odrOrderDate;
	private Date odrDeliverDate;
	private String odrStatus;
	
	public Order() {
		super();
	}

	public Order(Integer odrId, Integer odrCustomerId, String odrCustomerName, String odrDeliverAddr, Date odrOrderDate,
			Date odrDeliverDate, String odrStatus) {
		super();
		this.odrId = odrId;
		this.odrCustomerId = odrCustomerId;
		this.odrCustomerName = odrCustomerName;
		this.odrDeliverAddr = odrDeliverAddr;
		this.odrOrderDate = odrOrderDate;
		this.odrDeliverDate = odrDeliverDate;
		this.odrStatus = odrStatus;
	}

	public Integer getOdrId() {
		return odrId;
	}

	public void setOdrId(Integer odrId) {
		this.odrId = odrId;
	}

	public Integer getOdrCustomerId() {
		return odrCustomerId;
	}

	public void setOdrCustomerId(Integer odrCustomerId) {
		this.odrCustomerId = odrCustomerId;
	}

	public String getOdrCustomerName() {
		return odrCustomerName;
	}

	public void setOdrCustomerName(String odrCustomerName) {
		this.odrCustomerName = odrCustomerName;
	}

	public String getOdrDeliverAddr() {
		return odrDeliverAddr;
	}

	public void setOdrDeliverAddr(String odrDeliverAddr) {
		this.odrDeliverAddr = odrDeliverAddr;
	}

	public Date getOdrOrderDate() {
		return odrOrderDate;
	}

	public void setOdrOrderDate(Date odrOrderDate) {
		this.odrOrderDate = odrOrderDate;
	}

	public Date getOdrDeliverDate() {
		return odrDeliverDate;
	}

	public void setOdrDeliverDate(Date odrDeliverDate) {
		this.odrDeliverDate = odrDeliverDate;
	}

	public String getOdrStatus() {
		return odrStatus;
	}

	public void setOdrStatus(String odrStatus) {
		this.odrStatus = odrStatus;
	}

	@Override
	public String toString() {
		return "Order [odrId=" + odrId + ", odrCustomerId=" + odrCustomerId + ", odrCustomerName=" + odrCustomerName
				+ ", odrDeliverAddr=" + odrDeliverAddr + ", odrOrderDate=" + odrOrderDate + ", odrDeliverDate="
				+ odrDeliverDate + ", odrStatus=" + odrStatus + "]";
	}
	
	

}
