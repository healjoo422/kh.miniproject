package com.kh.basic;

import java.util.Scanner;

public class Output {

	public static void main(String[] args) {
		
		System.out.print("hello.");
		System.out.print("hello.\n");
		System.out.println("hello.\n");
		System.out.println("hello.");
		
		String name = "Peter";
		int age = 40;
		String gender = "Male";
		
		System.out.print("my name is " + name + ", " + gender + " and " + age + " years old.\n");
		System.out.printf("my name is %s, %s and %d years old.\n", name, gender, age);
		
		/*
		 * %d : 정수
		 * %c : 문자
		 * %s : 문자열
		 * %f : 실수  (%.4f = 소수점 4자리까지 표현, 기본은 6자리까지만)
		 */
		
		Scanner sc = new Scanner(System.in);
		String str;
		int inum;
		
		System.out.print("입력 : ");
		str = sc.nextLine();
		System.out.println("출력 : " + str);
		
		/*
		 * 현대적 컴퓨터는 버퍼라는 임시 저장소를 가지고있는데 사용자의 입력값이 이곳에 저장된다
		 * Scanner Class는 이 버퍼를 잠조하여 값을 가져온다
		 * 이 버퍼에대한 구조적인 이해가 뒷받침 되어야 입/출력을 자유롭게 다룰 수 있다 
		 * 또한 Scanner Class 내부에도 굉장히 많은 메서드가 있음 
		 */
		
	}

}
