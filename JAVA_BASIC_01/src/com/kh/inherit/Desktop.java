package com.kh.inherit;

public class Desktop extends Product{
	
	private boolean allInOne;
	
	public Desktop() {
		
	}

	public Desktop(String pName, int price, String brand, boolean allInOne) {
		super(pName, price, brand);
		this.allInOne = allInOne;
		
	}
	
}
