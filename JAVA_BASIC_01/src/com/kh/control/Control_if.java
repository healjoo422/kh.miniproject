package com.kh.control;

import java.util.Scanner;

public class Control_if {

	public static void main(String[] args) {
		
		/*
		 * 특정 코드를 선택적으로 실행시키고 싶을 때 조건문을 활용
		 * 조건식을통해 true, false를 판단하고 결과에 따라 실행흐름을 분기
		 */
		
		// if, else 기본형
		int num1 = 5;
	
		if(num1 % 2 == 0) {
			System.out.println("isEven");
		}
		else {
			System.out.println("isOdd");
		}
		
		
		// else if 문 활용
		// 조건문의 실행부분이 한 1줄밖에 없다면 중괄호{} 로 엮지 않아도 문법상 오류가 없음
		int month = 7;
		if(month == 1 || month == 2 || month == 12)
			System.out.println("Winter");
		
		else if(month <= 5)
			System.out.println("Spring");
		
		else if(month <= 8)
			System.out.println("Summer");

		else if(month <= 11)
			System.out.println("Autumn");

		else
			System.out.println("X");
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input Integer : ");
		int num2 = sc.nextInt();
		
		
		// 양수, 음수, 0 판별
		// 양수체크
		if(num2 > 0) {
			System.out.println("isPositive");
		} 
		// 0인지 체크
		else if(num2 == 0) {
			System.out.println("isZero");
		} 
		// 어떤 정수가 양수도 아니고 0도 아니라면 항상 음수이므로 더 이상 조건체크가 필요없음 
		else {
			System.out.println("isNegative");
		}


	}

}
