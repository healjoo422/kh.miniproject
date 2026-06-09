package com.kh.api;

public class WrapperAPI {

	public void method() {
		int num1 = 10;
		int num2 = 20;
		
		System.out.println(num1 == num2);
		
		Integer i1 = new Integer(num1);
		Integer i2 = new Integer(num2);
		
		// Integer의 equals는 Object 객체를 받아야하는데 literal를 집어넣어도
		// 알아서 Integer객체로 감싸서 비교함(auto boxing)
		// 이렇게 literal을 Wrapper로 변환하는것을 Boxing 이라고 함
		System.out.println(i1.equals(10));

		
		// 반대로 Wrapper 객체가 담고있는 값을 꺼내서 literal화 시키는것을 unBoxing이라고 함
		Integer iNum1 = 128;
		int iNum2 = 128;
		System.out.println(iNum1 == iNum2);
		// 객체간의 == 비교는 참조비교이기 때문에 false를 반환하는것이 맞지만
		// java에서 Wrapper 객체와 literal 객체간의 == 비교는 auto unBoxing을 지원하기 때문에
		// literal 비교로 true를 반환하게 됨
		
		
		Integer iNum3 = 128;
		System.out.println(iNum1 == iNum3);
		
	}
}
