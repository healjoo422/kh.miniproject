package com.kh.operator;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		/*
		 * 사용자로부터 가로, 세로값을 실수형으로 입력받아 사각형 면적과 둘레를 계산하여 출력
		 * + 소수점 2번째 자리까지만
		 */
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[console]");
		System.out.print("가로 : ");
		float squareWidth = sc.nextFloat();
		
		System.out.print("세로 : ");
		float squareLength = sc.nextFloat();
		
		System.out.printf("면적 : %.2f \n", squareWidth * squareLength);
		System.out.printf("둘레 : %.2f \n", 2 * (squareWidth + squareLength));
		
	}

}
