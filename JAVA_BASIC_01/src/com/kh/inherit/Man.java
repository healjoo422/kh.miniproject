package com.kh.inherit;

public class Man {
	private String name;

	public Man(String name) {
		super();
		this.name = name;
		System.out.println("Man 객체 생성");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void tellYourName() {
		System.out.println("제 이름은 " +name+ "입니다.");
	}
}
