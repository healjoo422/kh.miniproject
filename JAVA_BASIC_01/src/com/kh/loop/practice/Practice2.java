package com.kh.loop.practice;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int fullPrice = 0, fullKind = 0, price = 0, qty = 0, sum = 0;
		
		System.out.print("총 가격 : ");
		fullPrice = sc.nextInt();
		System.out.print("종류 : ");
		fullKind = sc.nextInt();
		
		for(int i=0; i<fullKind; i++) {
			System.out.print("가격 수량 : ");
			price = sc.nextInt();
			qty = sc.nextInt();
			sum += price*qty;
			//System.out.printf("디버깅용 : %d %d %d \n", price, qty, sum );
			
		}
		System.out.println(fullPrice == sum ? "Yes" : "No");
		
		sc.close();
	}

}
