package com.kh.object.override;

public class Man {
	
	// 필드
	String name;
	String identifyCode;
	
	// 생성자
	// alt + shift + s , o
	public Man(String name) {
		this(name, "입력값 없음");
		// this()를 이용해서 다른 생성자를 호출 할 수 있음
	}
	
	public Man(String name, String identifyCode) {
		this.name = name;
		this.identifyCode = identifyCode;
	}
	
	// 메서드
	public void showMyInfo() {
		System.out.println("제 이름은 "+ name +"입니다.");
	}
	
	public void showMyInfo(String gender) {
		System.out.println("제 이름은 "+ name +"입니다. 성별은 "+ gender +"입니다.");
	}
}
