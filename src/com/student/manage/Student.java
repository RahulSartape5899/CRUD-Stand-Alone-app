package com.student.manage;

public class Student {

	private int sId;
	private String sName;
	private String phoneNum;
	private String sCity;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	
	public String getsName() {
		return sName;
	}
	
	public void setsName(String sName) {
		this.sName = sName;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public String getsCity() {
		return sCity;
	}
	
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	
	public Student(String sName, String phone, String sCity) {
		super();
		this.sName = sName;
		this.phoneNum = phone;
		this.sCity = sCity;
	}
	
	public Student() {
	}
	
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", phoneNum=" + phoneNum + ", sCity=" + sCity + "]";
	}
}
