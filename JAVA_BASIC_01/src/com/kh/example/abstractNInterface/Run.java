package com.kh.example.abstractNInterface;

public class Run {

	public static void main(String[] args) {

		PhoneController pc = new PhoneController();
		
		String[] strArr = pc.method();
		
		for(int i=0; i<strArr.length; i++) {
			System.out.println(strArr[i]);
			System.out.println();
		}
	}

}
