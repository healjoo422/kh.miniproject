package com.kh.control;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		/*
		 * 나이를 입력받고
		 * 13 이하	: 어린이
		 * 14~19	: 청소년
		 * 20 이상	: 성인
		 * 
		 */

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input Age : ");
		int age = sc.nextInt();
		String grade; 
				
		if(age < 13) 		grade = "kids";
		else if (age < 20)	grade = "youth";
		else 				grade = "adult";
		
		System.out.printf("%d is %s\n", age, grade);
	}

}
