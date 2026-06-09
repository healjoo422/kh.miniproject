package com.kh.interface1;

public class Dog implements Animal{

	@Override
	public void speak() {
		System.out.println("멍멍!");
		
	}

	@Override
	public void move() {
		System.out.println("강아지가 발발발발");
		
	}
}
