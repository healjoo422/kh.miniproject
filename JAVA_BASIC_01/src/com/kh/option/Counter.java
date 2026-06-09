package com.kh.option;

public class Counter {

	static int count = 0;
	private String name;
	
	public Counter(String name) {
		super();
		this.name = name;
		count++;
	}
	
	public void printCount() {
		System.out.println("count : " + count);
	}
	
	public static void showCount() {
		System.out.println("count : " + count);
	}
}
