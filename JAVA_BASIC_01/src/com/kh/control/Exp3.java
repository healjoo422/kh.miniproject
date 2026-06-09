package com.kh.control;
import java.util.Scanner;

public class Exp3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int age, price = -1;
		String day, grade;
		
		int test = 8000;
		
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("요일을 입력하세요 : ");
		day = sc.next();
		
		if(age < 13) {
			grade = "어린이";
			price = 5000;
		}
		else if(age < 19) {
			grade = "청소년";
			price = 7000;
		}
		else {
			grade = "성인";
			price = 10000;
		}
		
		System.out.printf("%s 요금입니다. ", grade);
		
		switch(day) {
			case "토", "일":
				price *= 0.8;
				System.out.print("(주말 할인 적용)");
				break;
			default:
				break;
		}
		System.out.printf("\n최종 요금은 %d원 입니다.\n", price);
	}

}
