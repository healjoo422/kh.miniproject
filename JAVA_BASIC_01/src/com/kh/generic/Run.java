package com.kh.generic;

public class Run {

	/*
	 * 클래스나 메서드가 사용할 데이터타입을 컴파일 시점에 지정할 수 있도록 지원하는 문법이 제네릭이다
	 *  -> 필드, 메서드의 타입을 객체 생성시 전달받아 사용한다
	 * 
	 * 제네릭을 사용하지 않고 Object같이 넓은 범위를 수용할 수 이쓴ㄴ 타입을 사용할 경우에는
	 * 명시적 형변환이 매번 필요하거나, 런타임 오류를 야기할 수 있다
	 * 
	 */
	
	public static void main(String[] args) {
		
		Box aBox = new Box<>();
		aBox.setValue("10");
		
		int num = Integer.parseInt((String)aBox.getValue());
		
		Box<Integer> iBox = new Box<>();
		// iBox.setValue("10");
		
		
		
		
				
	}
}
