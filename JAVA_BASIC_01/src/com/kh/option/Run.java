package com.kh.option;

public class Run {

	public static void main(String[] args) {
		
		/*
		 * pakage
		 * 클래스간 공간적 충돌이나 접근방법의 충돌을 막기위해
		 * 저장위치를 구분해서 명확성을 확보할 수 있도록 해주는 개념
		 
		 * 네이밍 방식
		 * 도메인 : www.naver.com 일때
		 * 패치지 : com.naver.팀명 // com.naver.프로젝트명 등등
		 *
		 */
		
		Counter.showCount();
		// static 메서드는 
		Counter c1 = new Counter("aaa");
		Counter.showCount();
		c1.printCount();
		
		Counter c2 = new Counter("bbb");
		Counter c3 = new Counter("ccc");
		
		c2.printCount();
		c3.printCount();
		
	}

}
