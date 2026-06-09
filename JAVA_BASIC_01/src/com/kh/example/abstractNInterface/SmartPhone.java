package com.kh.example.abstractNInterface;

public abstract class SmartPhone {

	private String maker;
	
	public SmartPhone() {
	
	}
	
	public abstract String printInformation();

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	
}
