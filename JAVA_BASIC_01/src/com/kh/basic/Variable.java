package com.kh.basic;

public class Variable {

	public static void main(String[] args) {
		
		int num;
		num = 10;
		System.out.println(num);
		
		boolean isTrue = false;
		isTrue = true;
		System.out.println(isTrue);
		
		float num2;
		num2 = 0.123456789f;
		System.out.println(num2);
		System.out.printf("%.4f \n", num2);
		
		int inum = 10;		// 4바이트
		byte bnum = 10;		// 1바이트
		short snum = 10;	// 2바이트
		long lnum = 10;		// 8바이트
		float fnum = 3.14f;	// 4바이트
		double dnum = 3.14;	// 8바이트
		
		System.out.println(dnum);
		
		char ch1 = '일';
		char ch2 = '이';
		char ch3 = '삼';
		
		System.out.println(ch1);
		System.out.println(ch1 + ch2+ ch3);
		System.out.printf("%c%c%c \n", ch1,ch2,ch3);
		
		boolean b1 = 10 > 0;
		boolean b2 = 20 == 10;
		System.out.println(b1);
		System.out.println(b2);
		
		// 객체타입은 명시적으로 메모리할당을 선언하도록(new) 하는것이 원칙이다
		// 문자열은 객체형임에도 예외적으로 메모리할당 선언없이 생성할 수 있도록 되어있음
		String str1 = new String("Hello?");
		String str2 = "Hello!";
		System.out.println(str1);
		System.out.println(str2);
		

		
		// \t : 탭문자
		System.out.println("name\tage\tadress");
		// \\ : 백슬래시문자
		System.out.println("name\\age\\adress");
		// \" : 쌍따옴표
		System.out.println("name\"age\"adress");
		
		
		
		// 문자열의 속성
		String str3 = "바보" + 123 + 45;
		System.out.println(str3);		
		String str4 = 123 + 45 + "바보";
		System.out.println(str4);
		
		// 상수 선언
		// 딱 한번만 값 할당이 가능함 초기화 이후에 대입이 불가능
		// 코드가 실행되는동안 절대 변해서는 안되는 변수에 활용
		// 코드블록에서 상수임을 알 수있도록 변수명을 지을때 별도의 규칙을 두는것이 좋음 (모두 대문자로 짓는게 일반적)
		final float PI = 3.141592f;
		

		
		/*
		 * 프로그래밍에서 이름짓는 방식(권장사항)
		 * 
		 * 1. 카멜 케이스 : 단어를 나열할 때 두번째 단어부터 첫글자를 대문자로 작성
		 * 	ex) userName, totalCount
		 * 	자바에서 모든 함수명, 변수명
		 * 
		 * 2. 파스칼 케이스 : 카멜케이스에서 첫 글자까지 대문자로 작성
		 * 	ex) UserName, TotalCount
		 * 	자바에서 클래스명에 사용
		 * 
		 * 3. 스네이 크케이스 : 문자와 문자사이를 _를 통해서 이어주는 것
		 * 	ex) user_name, total_count
		 * 	Python, JS 등에서 사용 
		 * 
		 * 4. 대문자 스네이크 케이스
		 *  ex) USER_NAME, TOTAL_COUNT
		 * 	대부분의 언어에서 상수명
		 * 
		 * 5. 케밥 케이스 : 단어는 소문자로 작성하되, 문자와 문자사이를 -으로 이어주는 것
		 *  ex) user-name, total-count
		 *  html에서 속성, url, 설정파일 등
		 *  
		 */
		
		
	}
}
