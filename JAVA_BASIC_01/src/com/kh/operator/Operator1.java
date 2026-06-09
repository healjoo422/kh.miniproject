package com.kh.operator;

import java.util.Scanner;

public class Operator1 {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 5;
		int c = 5;
		int d = 3;
		
		// 논리연산자
		System.out.println(!true);
		
		System.out.println(true&&true);
		System.out.println(true&&false);
		
		System.out.println(true||false);
		System.out.println(false||false);
		

		//산술연산자
		a = 10;
		b = 5;
		c = 5;
		d = 3;
		
		System.out.println(a+b);	// 덧셈
		System.out.println(c-d);	// 뺄셈
		System.out.println(a/b);	// 나눗셈
		System.out.println(c*d);	// 곱셈
		System.out.println(a%d); 	// 나머지
		
		System.out.println(a+b);
		System.out.println(a+=b);
		System.out.println(a);
		System.out.println(a-=b);
		System.out.println(a);
		
		// ++, -- 연산자의 선처리와 후처리
		float x = 5.1f;
		float y = x++;
		System.out.println(x++); 	
		System.out.println(x);
		
		System.out.println(y--);	
		System.out.println(y);
		
		x = 5.1f;
		y = 3;
		System.out.println(++x);
		System.out.println(x);
		System.out.println(--y);	
		System.out.println(y);
		
		//비교연산자
		a = 10;
		b = 5;
		c = 5;
		d = 3;
		
		System.out.println(a>b);	// a는 b보다 크다
		System.out.println(b==c);	// b는 c와 같다
		System.out.println(b>=c);	// b는 c보다 크거나 같다
		System.out.println(b!=d);	// b는 d와 같지 않다
		
		
		
		
		// @주의 : == 연산자를 객체에 사용하면 기본적으로 참조비교를 하기때문에 객체의 값을 비교하기위해서는 특정한 메서드를 사용해야한다
		
		// 그런데 문자열은 조금 특별함 ㅋㅋ
		// 왜냐하면 문자열 객체만 생성과정이 조금 특별하기 때문임
		
		System.out.println("문자열 테스트");
		
		String str1 = "cat";
		String str2 = "cat";
		
		
		String str3 = new String("cat");
		String str4 = new String("cat");
		
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str3==str4);

		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));

		// 재미난 케이스 : 숫자가 127을 초과하면 삼단논법이 파괴됨
		
		Integer iNum1 = 128;
		Integer iNum2 = 128;
		Integer iNum3 = Integer.valueOf(128);
		Integer iNum4 = Integer.valueOf(128);
		
		
		System.out.println(iNum1 == iNum2);
		System.out.println(iNum1 == iNum3);
		System.out.println(iNum3 == iNum4);

		System.out.println("iNum1 : " + System.identityHashCode(iNum1));
		System.out.println("iNum2 : " + System.identityHashCode(iNum2));
		System.out.println("iNum3 : " + System.identityHashCode(iNum3));
		System.out.println("iNum4 : " + System.identityHashCode(iNum4));
		
	}

}
