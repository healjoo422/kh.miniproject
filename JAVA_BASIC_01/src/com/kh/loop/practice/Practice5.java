package com.kh.loop.practice;

import java.util.Scanner;

public class Practice5 {

	public static void main(String[] args) {
		// 누적 합 종료 조건
		
		Scanner sc = new Scanner(System.in);
		int num=0, sum=0;
		
		while(true) {
			System.out.print("숫자 입력 : ");
			num = sc.nextInt();
			
			if(num < 0) break;
			sum += num;
		}
		
		System.out.println("총합 : " + sum);
		
		sc.close();
	}

}
