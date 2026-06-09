package com.kh.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DateAPI {

	public void method() {
		/*
		 * 1. java.util.Date
		 * 
		 * 자바 초기부터 사용하던 날짜/시간 클래스
		 * 현재 직접 사용을 권장하지는 않음
		 * 
		 * 이유 :
		 *  - 년도계산이 불편함 : 실제년도 - 1900
		 *  - 월 계산이 불편함 : 실제 월 - 1
		 *  - 멤버변수에 직접 접근하여 날짜변경이 가능해서 안전하지 않음
		 *  - deprecated : java에서 사용을 권장하지 않는 메서드(이클립스의 경우, 취소선이 그어짐)
		 */
		
		// 코드가 돌아가는 머신의 날짜와 시간이 들어감
		// 클라이언트-서버간 통신에서 시간이 어긋날 수 있음
		Date date1 = new Date();
		
		// 얘가 deprecated 된 놈
		date1.getDate();
		
		System.out.println("현재시간 : " + date1);
		
		Date date2 = new Date(2026 - 1900, 3 - 1, 1);
		System.out.println("지정날짜 : " + date2);
		
		/*
		 * LocalDateTime
		 * 
		 * java8부터 도입됨
		 * 기존 Date 클래스의 문제점을 보완
		 * 
		 * 장점 : 원본객체를 변경시키지 않고, 새로운 객체를 생성해서 반환함
		 */
		
		LocalDateTime lc = LocalDateTime.now();
		
		System.out.println("날짜 및 시간 : " + lc);
		
		LocalDateTime date3 = LocalDateTime.of(2026, 5, 25, 12, 30, 15);
		System.out.println("날짜 및 시간 : " + date3);
		
		// 날짜와 시간이 분리되어있음
		LocalDate onlyDate = date3.toLocalDate();
		LocalTime onlyTime = date3.toLocalTime();
		
		System.out.println(onlyDate);
		System.out.println(onlyTime);
		
		
	}
}
