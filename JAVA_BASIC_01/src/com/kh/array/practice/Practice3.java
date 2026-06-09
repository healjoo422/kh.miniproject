package com.kh.array.practice;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// 공넣기
		Scanner sc = new Scanner(System.in);

		int arrLength, cnt, range1, range2, num;
		int[] arr;
		
		System.out.print("input : ");
		arrLength = sc.nextInt();
		cnt = sc.nextInt();
		
		arr = new int[arrLength];
		
		for(int i=0; i<cnt; i++) {
			range1 = sc.nextInt();
			range2 = sc.nextInt();
			num = sc.nextInt();
			
			for(; range1<=range2; range1++) {
				arr[range1-1] = num;
			}
		}
		
		for(int n: arr) {
			System.out.print(n + " ");
		}
		
		sc.close();
	}

}
