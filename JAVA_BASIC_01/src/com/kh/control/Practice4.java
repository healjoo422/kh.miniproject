package com.kh.control;

import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		/*
		 * 성별을 m/f로(대,소문자 상관 X) 입력받아서 남학생 여학생 판별
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input Gender : ");
		char gender = sc.next().charAt(0);
		
		switch(gender){
			case 'm', 'M' -> System.out.println("You are a boy");
			case 'f', 'F' -> System.out.println("You are a girl");
			default -> System.out.println("Wrong type");
		}
		

	}

}
