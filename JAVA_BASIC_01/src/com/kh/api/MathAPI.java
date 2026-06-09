package com.kh.api;

import java.util.Random;

public class MathAPI {
	
	// java.lang -> 기본으로 import되는 클래스
	// 그 안에 .Math라고 모든 필드와 메서드가 static으로 정의된 클래스가 있음
	
	public void method() {
		System.out.println("PI : " + Math.PI);
		
		System.out.println("랜덤(0.00~0.99) : " + Math.random());
		
		System.out.println("절댓값 : " + Math.abs(-10.4));
		
		System.out.println("올림 : " + Math.ceil(10.2));
		
		System.out.println("반올림 : " + Math.round(10.2));
		
		System.out.println("버림 : " + Math.floor(10.2));
		
		
		
		
	}
}
