package com.kh.basic;

public class Conversion {

	public static void main(String[] args) {
		
		// 자동형변환(묵시적 형변환)
		// 자바는 자료형의 데이터 손실이 없는방향에 한에서 (대체적으로 작은자료형 -> 큰 자료형) 자동으로 형변환을 지원함
		long cNum1 = 100;
		int cNum2 = 2;
		long cNum3 = cNum1 + cNum2;
		System.out.println(cNum3);
		
		// 명시적 형변환
		// 프로그래머의 의도에 따라 데이터 손실을 감수하고 형변환이 가능하다
		double cNum4 = 3.141592;
		int cNum5 = (int)cNum4;
		System.out.println(cNum5);
		
		// 그러나 메모리에 저장된 값을 기준으로 형변환이 진행되기 때문에 맥락상 전혀 관계없는 값이 튀어나오므로 주의
		long cNum6 = 3000000000000007L;
		int cNum7 = (int)cNum6;
		System.out.println(cNum7);
		
		char ch1 = 'a';
		System.out.println("a : " + ch1);
		System.out.println("a : " + (int)ch1);
		System.out.println("a : " + (ch1+1));
		System.out.println("a : " + (char)(ch1+1));
		System.out.println("a : " + (char)(98));
	}

}
