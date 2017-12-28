package com.ssm.entity;

public class OrderLine {
	
	private Integer odlId;
	private Integer odlOrderId;
	private String odlProductName;
	private double odlProductPrice;
	private int odlProductCount;
	
	public OrderLine() {
		super();
	}

	public OrderLine(Integer odlId, Integer odlOrderId, String odlProductName, double odlProductPrice,
			int odlProductCount) {
		super();
		this.odlId = odlId;
		this.odlOrderId = odlOrderId;
		this.odlProductName = odlProductName;
		this.odlProductPrice = odlProductPrice;
		this.odlProductCount = odlProductCount;
	}

	public Integer getOdlId() {
		return odlId;
	}

	public void setOdlId(Integer odlId) {
		this.odlId = odlId;
	}

	public Integer getOdlOrderId() {
		return odlOrderId;
	}

	public void setOdlOrderId(Integer odlOrderId) {
		this.odlOrderId = odlOrderId;
	}

	public String getOdlProductName() {
		return odlProductName;
	}

	public void setOdlProductName(String odlProductName) {
		this.odlProductName = odlProductName;
	}

	public double getOdlProductPrice() {
		return odlProductPrice;
	}

	public void setOdlProductPrice(double odlProductPrice) {
		this.odlProductPrice = odlProductPrice;
	}

	public int getOdlProductCount() {
		return odlProductCount;
	}

	public void setOdlProductCount(int odlProductCount) {
		this.odlProductCount = odlProductCount;
	}

	@Override
	public String toString() {
		return "OrderLine [odlId=" + odlId + ", odlOrderId=" + odlOrderId + ", odlProductName=" + odlProductName
				+ ", odlProductPrice=" + odlProductPrice + ", odlProductCount=" + odlProductCount + "]";
	}
	
	

}
