package com.kh.inherit;

public class BusinessMan extends Man{
	
	private String company;
	private String position;
	
	public BusinessMan(String name, String company, String position) {
		super(name); 
		
		this.company = company;
		this.position =position;
		
		System.out.println("BusinessMan 객체 생성");
	}
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void tellYourInfo() {
		System.out.println("저는 " +company+ "에서 "+position+"으로 일하고 있습니다.");
		this.tellYourName();
	}
}
