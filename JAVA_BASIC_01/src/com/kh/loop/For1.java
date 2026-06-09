package com.kh.loop;

public class For1 {

	public static void main(String[] args) {
		
		for(int i=0; i<5; i++) {
			System.out.printf("Hello! %d\n", i);
		}
		// 초기식, 조건식, 후처리 각각 명시하지 않아도 문법적으로는 아무런 문제없이 동작가능
		
		for(int i=0; i<5; i++) {
			System.out.print(i+1);
		}
		System.out.println();
		/*
		 * block scope -> {}
		 * 자바의 지역변수
		 *  - 특정 메서드나 블록 ({}) 내부에서 선억하고 관리하는 변수
		 *  - 해당 블록이 종료되면 블록 내부의 변수도 사라짐
		 *  - 예시 : 위 for문의 i 같은거
		 */
		
		int num1 = 7;
		for(int i=0; i<num1; i++) {
			System.out.printf("%d ", i+1);
		}
		System.out.println();
		
		
		int sum1 = 0;
		int num2 = 200;
		for(int i=1; i<=num2; i++) {
			sum1+=i;
		}
		System.out.println("Sum : " + sum1);
		
		sum1 = num2 * (num2+1) / 2;
		System.out.println("Sum : " + sum1);
	}

}
