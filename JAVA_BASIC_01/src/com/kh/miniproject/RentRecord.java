package com.kh.miniproject;

import java.util.Objects;

public class RentRecord {

	private int bookID;
	private int managementID;
	private int rentDate;
	private int dueDate;
	private int returnDate;
	
	public RentRecord() {
	}

	public RentRecord(int bookID, int managementID, int rentDate, int dueDate) {
		super();
		this.bookID = bookID;
		this.managementID = managementID;
		this.rentDate = rentDate;
		this.dueDate = dueDate;
		this.returnDate = -1;
	}

	public int getBookID() {
		return bookID;
	}

	public int getmanagementID() {
		return managementID;
	}

	public int getRentDate() {
		return rentDate;
	}

	public int getDueDate() {
		return dueDate;
	}

	public int getReturnDate() {
		return returnDate;
	}
	
	public void setDueDate(int dueDate) {
		this.dueDate = dueDate;
	}

	public void setReturnDate(int returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "[도서번호=" + bookID + ", 사용자번호=" + managementID + ", 대출일=" + rentDate + ", 반납예정일=" + dueDate
				+ ", 반납일=" + returnDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bookID, rentDate, managementID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RentRecord other = (RentRecord) obj;
		return bookID == other.bookID && rentDate == other.rentDate && managementID == other.managementID;
	}

	
	
}
