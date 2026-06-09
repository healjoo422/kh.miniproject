package com.kh.object.ex3;

public class Run {

	public static void main(String[] args) {
		MathTest m = new MathTest();
		
		
		System.out.println(m.adder(10));
		System.out.println(m.adder(10, 20));
		System.out.println(m.adder(1.2, 3.4));

		System.out.println(m.adder("asd", 3));
		System.out.println(m.adder(3, "asd"));
		
		
	}

}