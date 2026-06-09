package com.kh.array;

import java.util.Scanner;

public class Array2DTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 사용자에게 행, 열을 입력받아 2차원배열 생성
		// 각 공간에 들어갈 문자열을 입력받아 저장한 뒤 출력
		
		Scanner sc = new Scanner(System.in);
		String[][] strArray;
		
		System.out.print("Input Array Size : ");
		strArray = new String[sc.nextInt()][sc.nextInt()];
		sc.nextLine();
		
		for(int i=0; i<strArray.length; i++) {
			for(int j=0; j<strArray[i].length; j++) {
				System.out.print((i+1) + "행" + (j+1) + "열 : ");
				strArray[i][j] = sc.nextLine();
			}
		}	System.out.println();
		
		for(int i=0; i<strArray.length; i++) {
			for(int j=0; j<strArray[i].length; j++) {
				System.out.print(strArray[i][j] + " ");
			}
			System.out.println();
		}
	}

}
