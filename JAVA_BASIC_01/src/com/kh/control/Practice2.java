package com.kh.control;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		/*
		 * 정수입력받고
		 * 1, 5 일경우	-> 빨간색
		 * 2 일 경우 		-> 파란색
		 * 3 일 경우		-> 초록색
		 * 나머지 		-> 잘못입력
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input Integer : ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1:
			case 5:
				System.out.println("Red");
				break;
			case 2:
				System.out.println("Blue");
				break;
			case 3:
				System.out.println("Green");
				break;
			default:
				System.out.println("ERROR");
		}

	}

}
