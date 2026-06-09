package com.kh.loop.practice;

import java.util.Scanner;

public class Practice8 {

	public static void main(String[] args) {
		// 별 피라미드 출력
		
		Scanner sc = new Scanner(System.in);
		int num=0;
		
		System.out.print("정수 입력(1~30) : ");
		num = sc.nextInt();
		
		for(int i=0; i++<num; ) {
			System.out.println();
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}	
		}
		
		sc.close();
		
		
	}

}
