package com.kh.polymorphism;

public class CheeseCake extends Cake{

	public void milky() {
		System.out.println("치즈케이크 느끼하다");
	}
	
	@Override
	public void yummy() {
		System.out.println("치즈케이크 냠냠");
	}
}
