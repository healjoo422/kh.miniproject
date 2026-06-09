package com.kh.array.practice;

import java.util.Scanner;

public class Practice6 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] arrA, arrB;
		int num1, num2;
		
		System.out.print("Input size : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		sc.nextLine();
		
		arrA = new int[num1][num2];
		arrB = new int[num1][num2];
		
		for(int i=0; i<arrA.length; i++) {
			for(int j=0; j<arrA[i].length; j++) {
				arrA[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<arrB.length; i++) {
			for(int j=0; j<arrB[i].length; j++) {
				arrB[i][j] = sc.nextInt();
			}
		}
		
		System.out.println();
		
		for(int i=0; i<arrA.length; i++) {
			for(int j=0; j<arrA[i].length; j++) {
				System.out.print(arrA[i][j] + arrB[i][j] + " ");
			}	System.out.println();
		}
		
		sc.close();
	}

}
