package com.kh.api;

import java.util.StringTokenizer;

public class StringAPI {

	public void method1() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		
		System.out.println(str1);
		System.out.println(str2.toString());
		// 본디 Object 클래스에 정의된 toString()은
		// 객체타입 + 해시코드로 이루어진 문자열을 반환한다
		// 하지만 String 클래스 내에 재정의(오버라이딩)되어있다
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		// hashCode() 또한 객체가 담고있는 문자열 리터럴을 기반으로 해시코드를 생성하도록 객체 내에서 재정의 되어있다
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		// 실제 메모리 기반 해시코드를 보고싶다면 이와같은 메서드가 있다
		
	}
	
	public void method2() {
		String str1 = "Hello World";
		
		char ch = str1.charAt(6);
		System.out.println("ch : " + ch);
		
		// .contains(키워드) : boolean
		// 문자열에 매개변수로 전달받은 키워드가 포함되어있는지 여부 확인
		System.out.println("str1에 ello 키워드 포함여부" + str1.contains("ello"));
		
		// .substring(시작위치, [끝위치]) : String
		// 문자열을 시작위치부터 끝위치 -1 인덱스 위치까지 추출해서 반환
		System.out.println("str1 4번째부터 끝까지 : " + str1.substring(4));
		
		// .replace(대상문자, 변겅문자) : String
		// 문자열에서 대상 문자를찾아 변경문자로 치환후 문자열 반환
		System.out.println("str1 o를 O로 변환 : " + str1.replace('o', 'O'));
		
		// .trim() : String
		// 문자열 앞 뒤 공백을 제거
		
		// .toCharArray() : char[]
		// 문자열을 문자열 배열로 변환
	}
	
	public void method3() {
		String str = "Java,Oracle,sql,html,css,js,jsp,Spring";
		
		
		// .split(키워드) : String[]
		// 문자열을 전달받은 키워드를 기준으로 분할하여 문자열 배열로 반환
		
		
		// .join(키워드, 문자열배열) : String
		// 문자열 배열을 키워드를 삽입해 하나의 문자열로 만든 후 반환
		
		// 문자열 토큰화를 이용한 관리
		// 전달받은 문자열을 구분자를 기준으로 토큰화한 객체생성
		// StringTokenizer << 순회형 자료구조를 가지고있음, 유사 iterator임
		StringTokenizer stn = new StringTokenizer(str, ",");
		
		
	}
	
	
}
