package com.kh.example.oop1;

public class Product {
	private String pName;
	private int price;
	private String brand;
	
	public Product() {
		
	}
	
	public void information() {
		System.out.println("상품명 : "+ this.pName);
		System.out.println("가격 : "+ this.price);
		System.out.println("브랜드 : "+ this.brand);
	}
	
	
}
