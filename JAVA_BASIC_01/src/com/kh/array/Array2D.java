package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class Array2D {

	public static void main(String[] args) {
		
		// int[행][열]
		
		Scanner sc = new Scanner(System.in);
		
		int[][] arr1;
		
		arr1 = new int[2][3];
		
		arr1[0][0] = 1;
		arr1[0][1] = 1;
		arr1[0][2] = 1;
		arr1[1][0] = 2;
		arr1[1][1] = 2;
		arr1[1][2] = 2;
		
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}	System.out.println();

	
		int[][] arr2 = new int[3][];
		arr2[0] = new int[] {1,2};
		arr2[1] = new int[5] ;
		arr2[2] = new int[4];
		Arrays.fill(arr2[2], 100);
		
		for(int i=0; i<arr2.length; i++) {
			for(int j=0; j<arr2[i].length; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
