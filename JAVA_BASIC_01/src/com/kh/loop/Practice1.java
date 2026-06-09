package com.kh.loop;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		/*
		 * 커피주문
		 */
		
		Scanner sc = new Scanner(System.in);
		int order = -1;
		final int PRICE = 1100;
		
		System.out.printf("아메리카노(%d원)를 몇잔 구매하시겠습니까? : ", PRICE);
		order = sc.nextInt();
		
		for(int i=0; i<order; i++) {
			System.out.printf("%d잔 -> %d원 \n", i+1, (i+1)*PRICE);
		}
		System.out.printf("결제하실 금액 %d원 입니다. \n", order*PRICE);
	}

		
}
