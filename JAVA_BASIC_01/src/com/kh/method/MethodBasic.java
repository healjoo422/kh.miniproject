package com.kh.method;

public class MethodBasic {

	/*
	 * 클래스 내부에 정의된 함수
	 * 특정 기능을 수행하는 코드블럭을 사전에 정의하고, 필요할 때 호출해서 재사용이 가능
	 * 중복코드 제거와 가독성, 유지보수성이 향상됨
	 */
	
	/*
	 * [접근제한자] [static] 반환형 메서드이름(매개변수){
	 * 		코드;
	 * 		return 반환값;	
	 * }
	 * 
	 * 지역변수
	 * 블록{} 내부에서 선언된 변수
	 * 블록이 종료될 때 메모리에서 제거됨
	 * 
	 * 매개변수
	 * 메소드 호출시 외부에서 전달받은 값을 저장하는 지역변수
	 * 메소드 선언부에 필요에 따라 정의됨
	 * 
	 * call by value : 값에 의한 호출
	 * call by reference : 참조에 의한 호출
	 * 
	 * java는 무조건 call by value로만 동작한다
	 * 객체를넘겨줄 때 call by reference처럼 보이지만
	 * 실제로 그 안에 담겨있는 주소'값'을 넘겨받은 것이지 엄밀히 말해 call by reference가 아니다
	 */
	
	public static void main(String[] args) {
		System.out.println("start");
		hiEveryone(57);
		hiEveryone(77);
		adder(123213, 7748);
			
		String name = "micle";
		int age = 15;
		
		System.out.println(name);
		say(name, age);
		System.out.println(name);
		
		int[] iArr = {0};
		System.out.println(iArr[0]);
		arrTest(iArr);
		System.out.println(iArr[0]);
		
		iArr = objTest();
		System.out.println(iArr[0]);
	}
	
	public static void hiEveryone(int num) {
		System.out.println("안녕하세요");
		System.out.println("제 번호는 "+ num +"번 입니다");
	}
	
	public static int adder(int left, int right) {
		int result = left + right;
		return result;
	}

	public static void say(String name, int age) {
		name = "bart";
		System.out.println("in : "+ name);
	}
	
	public static void arrTest (int[] arr) {
		arr[0] = 1;
	}
	
	public static int[] objTest() {
		int[] a = {7};
		return a;
	}
}
