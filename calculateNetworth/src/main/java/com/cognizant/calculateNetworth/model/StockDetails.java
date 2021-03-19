package com.cognizant.calculateNetworth.model;

public class StockDetails {
	
	private String shareId;

	private String shareName;

	private int shareValue;

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public StockDetails(String shareId, String shareName, int shareValue) {
		super();
		this.shareId = shareId;
		this.shareName = shareName;
		this.shareValue = shareValue;
	}

	public StockDetails() {
		super();
	}

	@Override
	public String toString() {
		return "ShareDetails [shareId=" + shareId + ", shareName=" + shareName + ", shareValue=" + shareValue + "]";
	}

	public String getShareName() {
		return shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public int getShareValue() {
		return shareValue;
	}

	public void setShareValue(int shareValue) {
		this.shareValue = shareValue;
	}

}
