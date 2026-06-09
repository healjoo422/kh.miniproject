package com.kh.control;

import java.util.Scanner;

public class Practice3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 과일구매
		 * 과일명을 입력하면
		 * 그에맞는 가격이 출력
		 * 
		 * 사과 	: 2000
		 * 바나나	: 3000
		 * 수박	: 8000
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("List : Apple(2000), Banana(3000), Melon(8000)");
		System.out.print("Choice : ");
		String choice = sc.next();
		int price = -1;
		
		switch(choice) {
		case "Apple" -> price = 2000;
		case "Banana" -> price = 3000;
		case "Melon" -> price = 8000;
		default -> price = -1;
		}
		
		if(price > 0) System.out.printf("%s is %d$ \n", choice, price);
		else System.out.println("ERROR");
	}

}
