package com.kh.operator;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		/*
		 * 정수 2개를 집력받아 두 수의 합, 차, 곱, 나누기, 나머지 값을 출력
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.println("[console]");
		System.out.print("1st Integer : ");
		int num1 = sc.nextInt();
		
		System.out.print("2nd Integer : ");
		int num2 = sc.nextInt();
		
		System.out.println("Add : " + (num1+num2));
		System.out.println("Sub : " + (num1-num2));
		System.out.println("Mul : " + (num1*num2));
		System.out.println("Div : " + (num1/num2));
		//System.out.printf("Div : %.2f\n", (float)num1/(float)num2);
		System.out.println("Mod : " + num1%num2);
		
	}
	
	 
	
	

}
