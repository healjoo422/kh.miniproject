package com.kh.array.practice;

import java.util.Scanner;

public class Practice7 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr;
		int num1=0, num2=0;
		int max = Integer.MIN_VALUE;
		
		System.out.print("input size : ");
		arr = new int[sc.nextInt()][sc.nextInt()];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print((i+1)+"번째 행 : ");
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					num1 = i+1;
					num2 = j+1;
				}
			}
		}
		
		System.out.printf("%d \n%d %d", max, num1, num2);
			
		sc.close();
	}
	
}
	
