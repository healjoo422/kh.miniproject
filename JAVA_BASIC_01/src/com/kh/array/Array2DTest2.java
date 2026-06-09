package com.kh.array;

import java.util.Scanner;

public class Array2DTest2 {

	public static void main(String[] args) {
		/* 사용자에게 좌석의 행,열을 입력받아 좌석 생성
		 * 좌석별 관객의 이름을입력받고
		 * 좌석표 출력 
		 */

		Scanner sc = new Scanner(System.in);
		int a,b;
		String[][] strArray;
		
		System.out.print("Input row Size : ");
		a = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Input column Size : ");
		b = sc.nextInt();
		sc.nextLine();
		
		strArray = new String[a][b];
		
		for(int i=0; i<strArray.length; i++) {
			for(int j=0; j<strArray[i].length; j++) {
				System.out.print((i+1) + "행 " + (j+1) + "열 : ");
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
