package com.kh.loop.practice;

import java.util.Scanner;

public class Practice6 {

	public static void main(String[] args) {
		// 짝수만 제곱 출력하기
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		for(int i=0; i<10; i++) {
			System.out.print("숫자 입력 : ");
			num = sc.nextInt();
			if(num % 2 == 1) continue;
			System.out.printf("짝수 %d의 제곱은 %d입니다 \n", num, num*num);
		}
		
		sc.close();
	}

}
