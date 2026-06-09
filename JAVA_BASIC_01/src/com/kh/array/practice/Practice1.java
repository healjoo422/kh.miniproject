package com.kh.array.practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// X보다 작은 수
		
		int arrLength, num1;
		int[] iArr1;
		
		System.out.print("입력(배열길이 비교할숫자) : ");
		arrLength = sc.nextInt();
		num1 = sc.nextInt();
		
		iArr1 = new int[arrLength];
		
		for(int i=0; i<iArr1.length; i++) {
			iArr1[i] = sc.nextInt();
		}
		
		for(int num2:iArr1) {
			if(num2<num1) System.out.print(num2 + " ");
		}
		
		sc.close();
	}

}
