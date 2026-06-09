package com.kh.object.ex1;

/*
 * 클래스 구성요소
 * 
 * 필드
 * -> 사용할 데이터를 선언
 * 생성자
 * -> 데이터를 초기화하기 위한 특수목적 메서드
 * 메서드
 * > 클래스의 기능을 정의
 * 
 * public: 제한 없이 모든 외부 접근을 허용
 * protected: 같은 패키지(폴더) 내부와 해당 클래스를 상속받은 자식 클래스에서만 접근을 허용
 * default (또는 지정자 없음): 같은 패키지 내에서만 접근을 허용, 패키지 외부 접근 X
 * private: 선언된 해당 클래스 내부에서만 접근이 가능하며, 외부에서는 접근할 수 없음
 * 
 */



public class Student {
	
	// 필드
	String name;
	int age;
	
	public Student() {
		
	}
	
	// 생성자
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 메서드
	void myInfo() {
		System.out.printf("Hello. My name is "+ name +". and "+ age +" years old.\n");
	}
}
