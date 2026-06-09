package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class Break1 {

	public static void main(String[] args) {


		
		/*
		 * 랜덤정수(1~100)를 반복적으로 출력
		 * 생성된 값이 3의 배수일 경우 반복문 종료
		 * 단, 탈출조건은 break로 구현할 것
		 */
		Random random = new Random();
		
		
		
		int num1 = -1;
		while(true) {
		//	num1 = random.nextInt(100)+1;
			num1 = (int)(Math.random() * 100 + 1);
			System.out.println(num1);
			if(num1 % 3 == 0) break;
		}
		
		
		// 문자열을 입력받아 문자열의 길이를 출력하는 프로그램
		// exit을 입력받으면 중단, break로 구현할 것
		
		Scanner sc = new Scanner(System.in);
		String str1 = "";
		
		while(true) {
			System.out.print("문자열 입력 : ");
			str1 = sc.nextLine();
			if(str1.equals("exit")) {
				System.out.println("종료합니다");
				break;
			}
			System.out.println("길이 : " + str1.length());
			
		}
		
		
	}

}
