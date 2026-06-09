package com.kh.array.practice;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		// 바구니 뒤집기
		
		Scanner sc = new Scanner(System.in);
		int[] basket;
		int arrLength, cnt, num1, num2;
		
		System.out.print("Input : ");
		arrLength = sc.nextInt();
		cnt = sc.nextInt();
		
		basket = new int[arrLength];
		
		for(int i=0; i<basket.length; i++) {
			basket[i] = i+1;
		}
		
		for(int i=0; i<cnt; i++) {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			
			for(int j=0; num1+j<num2-j; j++) {
				int temp;
				temp = basket[num2-j-1];
				basket[num2-j-1] = basket[num1+j-1];
				basket[num1+j-1] = temp;
			}
		}
		
		for(int n: basket) {
			System.out.print(n + " ");
		}
		
		sc.close();
		

	}

}
