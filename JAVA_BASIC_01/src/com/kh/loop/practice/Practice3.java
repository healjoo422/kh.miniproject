package com.kh.loop.practice;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int caseNum = 0;
		int num1 = 0, num2 = 0;
		
		System.out.print("테스트 케이스 갯수 : ");
		caseNum = sc.nextInt();
		int[] arr = new int[caseNum]; 
		
		for(int i=0; i<caseNum; i++) {
			System.out.print("정수입력 : ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			arr[i] = num1+num2;
		}
		
		for(int i=0; i<caseNum; i++) {
			System.out.printf("Case #%d: %d \n", i+1, arr[i]);
		}
		
		sc.close();
	}

}
