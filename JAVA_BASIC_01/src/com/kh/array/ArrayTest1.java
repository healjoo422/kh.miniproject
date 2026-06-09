package com.kh.array;

import java.util.Scanner;

public class ArrayTest1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 크기가 10짜리 정수형 배열 numArr 생성
		int[] numArr = new int[10];
		
		// 반복문을 통해서 numArr의 모든 값을 10으로 초기화
		for(int i=0; i<10; i++) {
			numArr[i] = 10;
		}
		
		// for-each를 통해서 모든 배열의 요소 출력
		for(int n: numArr) {
			System.out.print(n + " ");
		}	System.out.println();
		
		
		// 사용자에게 배열의 길이를 입력받아, 입력받은 크기의 문자열배열 nameArr 생성
		System.out.print("Input length : ");
		String[] nameArr = new String[sc.nextInt()];
		sc.nextLine();
		
		// 사용자에게 이름을 입력받아 nameArr 에 저장, 해당 배열을 전부 채울때까지 반복
		for(int i=0; i<nameArr.length; i++) {
			System.out.print("Input name : ");
			nameArr[i] = sc.nextLine();
		}	System.out.println("Complete");
		
		for(String str: nameArr) {
			System.out.print(str + " ");
		}	System.out.println();
		
		System.out.print("Input Compare : ");
		
		
		
		String str1 = sc.nextLine();
		boolean sameNameFlag = false;
		
		
		
		for(String str2 : nameArr) {
			if(str1.equals(str2)) {
				System.out.println("같은이름 O");
				sameNameFlag = true;
				break;
			}
		}
		if(!sameNameFlag) System.out.println("같은이름 X");
		
		sc.close();
	}
}
