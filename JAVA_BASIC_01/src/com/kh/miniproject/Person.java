package com.kh.miniproject;

import java.util.Objects;

public class Person {

	private static int MANAGEMENT_ID_GENERATOR = 101;
	
	private int managementID;
	private String userID;
	private String phone;
	private int fee;
	
	public Person() {
	}

	public Person(String userID, String phone) {
		super();
		this.managementID = MANAGEMENT_ID_GENERATOR++;
		this.userID = userID;
		this.phone = phone;
		this.fee = 0;
	}

	public int getManagementID() {
		return managementID;
	}

	public void setManagementID(int managementID) {
		this.managementID = managementID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "[사용자번호=" + managementID + ", 이름=" + userID + ", 핸드폰=" + phone + ", fee=" + fee
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(phone, userID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(phone, other.phone) && Objects.equals(userID, other.userID);
	}


	
}
