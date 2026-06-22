package com.kh.exampletest;


public class Run {

	public static void main(String[] args) {
		
		try {
			step1();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void step1() throws Exception {
		step2();
		System.out.println("step1");
	}
	
	public static void step2() throws Exception {
		step3();
		System.out.println("step2");
	}
	
	public static void step3() throws Exception {
		boolean isExc = true;
		
		if(isExc) {
			throw new Exception("의도된 오류");
		}
		
		System.out.println("step3");
	}
}
