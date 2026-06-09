package com.kh.api;

public class Run {

	public static void main(String[] args) {
		
		/*
		 * API : Application Programing Interface
		 * 프로그램끼리 서로의 기능를 사용할 수 있도록 미리 만들어져 제공되는 기능들의 모음
		 * 
		 * 자바 API = 자바 표준 라이브러리(다른 개발자가 특정 목적을 가지고 만들어서 공유해준 코드)
		 * - 언어 자체는 기본문법만 제공함(변수, 제어문, 클래스... 등등)
		 * - 실제 개발에서는 수많은 기능들이 필요하기 때문에
		 *	이런 기능들을 자바 개발팀에서 미리 구현해서 제공하는 클래스/인터페이스를 표준 API라고 함
		 */
		
		MathAPI m = new MathAPI();
		m.method();
		
		StringAPI s = new StringAPI();
		s.method1();
		
		WrapperAPI w = new WrapperAPI();
		w.method();
		
		DateAPI d = new DateAPI();
		d.method();
		
	}

}
