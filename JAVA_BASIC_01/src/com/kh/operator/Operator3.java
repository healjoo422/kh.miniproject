package com.kh.operator;

public class Operator3 {

	public static void main(String[] args) {

		/*
		 * 3항 연산자
		 * 조건 ? 명령어1 : 명령어2
		 * 조건이 ture일 경우 명령어1 수행
		 * 조건이 falsed일 경우 명령어2 수행
		 */
		
		int num1 = 4<9 ? 100 : 50;
		System.out.println(num1);
		
		int num2 = false ? 100 : 50;
		System.out.println(num2);
		
		
		//다소 복잡하고 지저분하겠지만 중첩하는 방식의 응용도 가능함
		int num3 = -100;
		String result = (num3==0) ? "0" : ((num3 > 0) ? "양수" : "음수");
		System.out.println(result);
	
	}

}
