package com.kh.example.oop7;

public class ProductController {

	Product[] pro = new Product[10];
	public static int qty = 3;
	
	public ProductController() {
		pro[0] = new Product("Galaxy", 1200000, "Samsung");
		pro[1] = new Product("iPhone", 1200000, "Apple");
		pro[2] = new Product("iPad", 1200000, "Apple");
	}
	
	public void insertProduct(String pName, int price, String brand) {
		pro[qty] = new Product(pName, price, brand);
		qty++;
	}
	
	public Product[] selectProduct() {
		return pro;
	}
}
