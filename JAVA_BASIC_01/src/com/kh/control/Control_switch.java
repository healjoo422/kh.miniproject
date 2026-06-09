package com.kh.control;

import java.util.Scanner;

public class Control_switch {

	public static void main(String[] args) {

		// switch 기본형
		int num = 2;
		switch(num) {		
			case 1:
				System.out.println("case1");
			case 2:
				System.out.println("case2");
			case 3:
				System.out.println("case3");
				break;
			case 4:
				System.out.println("case4");
			default:
				System.out.println("default");
		
		}
		// default가 위로 올라가도 됨
		
		
		//변형 예제
		
		Scanner sc = new Scanner(System.in);
		int month = -1;
		int daily = -1;
		
		System.out.print("Input Month : ");
		month = sc.nextInt();
		
		daily = switch(month) {
			case 1, 3, 5, 7, 8, 10, 12 	-> 31;
			case 4, 6, 9, 11 			-> 30;
			case 2 						-> {
				System.out.println("2월은 조금특별한 케이스에요");
				yield 28;
			}
			default						-> -1;
		};
		
		if(daily > 0)	System.out.printf("%d월은 %d일 까지있습니다\n", month, daily);
		else			System.out.println("ERROR");
		
		/*
		 * 라벨(:)과 라벨(->)은 실제로 동작 방식에서 차이가 있기 때문에 혼용이 불가능하다
		 * 
		 * 라벨(:)은 의도적인 fall-through 방식에서 더 효과적이다
		 * 
		 * 라벨(->)은 switch문 자체가 특정한 값을 반환하도록 동작하게 만들 수 있다
		 * 사실상 모든 케이스의 결과값들이 서로 독립적일경우, 즉 모든 실행문에 break를 걸어야 하는 경우
		 * 라벨(->)의 코드가 더 간결하고, 안전하다고 볼 수 있음(자동으로 break를 걸어주므로 이를 까먹어서 발생하는 실수가 미연에 방지됨) 
		 */
	}
	

}
