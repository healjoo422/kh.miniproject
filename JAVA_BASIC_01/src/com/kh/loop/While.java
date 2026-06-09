package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		/*
		 * while(조건문){
		 * 		명령문
		 * 		+ 탈출빌드업
		 * }
		 * 
		 */
		
		int i = 0;
		while(i < 5) {
			System.out.println("hello! " + i++);
		}

		i = 10;
		do {
			System.out.println("hello! " + i);
		} while(i < 5);
		
		System.out.println();
		
		for(i=0; i<5; i++) {
			System.out.println("hello! " + i);
		}
		
		/*
		사용자가 0을 입력할때까지 반복입력받아 출력
		 
		int num1 = -1;
		Scanner sc = new Scanner(System.in);
		
		while(num1 != 0) {
			num1 = sc.nextInt();
			System.out.println(num1 + " ");
		}
		*/
		
		
		// 랜덤값 1~100 하나 생성
		// 1~ 랜덤값 까지의 합을 while을 이용해 더하기
		
		int randomInteger = (int)(Math.random() * 100)+1; 
		int sum1 = 0;
		int flag = 0;
		
		System.out.println("value : " + randomInteger);
		while(flag <= randomInteger) {
			sum1 += flag++;
		}
		System.out.println("sum : "+ sum1);
	
		// 0을 입력할때까지 1~100사이의 무작위 값을 생성해서 모두 더하기
		
		
		int num2 = -1;
		int sum2 = 0;
		
		
		while(num2 != 0) {
			System.out.println("숫자입력(0입력시 종료): ");
			num2 = sc.nextInt();
		//	sum2 += (int)(Math.random() * 100)+1;
			sum2 += random.nextInt(100)+1;
			System.out.println("랜덤값누적 : "+ sum2);
		}
		
		
	}
	
	

}
