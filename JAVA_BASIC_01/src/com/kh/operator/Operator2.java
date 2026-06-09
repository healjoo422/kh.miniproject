package com.kh.operator;

import java.util.Scanner;

public class Operator2 {

	public static void main(String[] args) {
		
		// 비교연산자 응용
		System.out.println((int)'a' + " ~ " + (int)'z');
		System.out.println((int)'A' + " ~ " + (int)'Z');

		System.out.print("Input 1char at alphabet : ");
		Scanner sc = new Scanner(System.in);
		char ch = sc.next().charAt(0);
		
		boolean res1 = (97 <= ch && ch <= 122);
		boolean res2 = (65 <= ch && ch <= 90);
		System.out.println("Is this alphabet? : " + (res1 || res2));
		
	}

}
