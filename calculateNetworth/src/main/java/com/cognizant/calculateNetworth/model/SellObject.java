package com.cognizant.calculateNetworth.model;

import java.util.List;

public class SellObject {
	
	int pid;
	
	List<String> aid;
	
	String atype;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<String> getAid() {
		return aid;
	}

	public void setAid(List<String> aid) {
		this.aid = aid;
	}

	public String getAtype() {
		return atype;
	}

	public void setAtype(String atype) {
		this.atype = atype;
	}

	public SellObject(int pid, List<String> aid, String atype) {
		super();
		this.pid = pid;
		this.aid = aid;
		this.atype = atype;
	}

	@Override
	public String toString() {
		return "SellObject [pid=" + pid + ", aid=" + aid + ", atype=" + atype + "]";
	}

	public SellObject() {
		super();
	}

}
