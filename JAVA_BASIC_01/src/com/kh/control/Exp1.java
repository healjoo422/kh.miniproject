package com.kh.control;

import java.util.Scanner;

public class Exp1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int score = -1;
		char grade = 'N';
		
		System.out.print("Input score : ");
		score = sc.nextInt();

		if(score >= 90) grade = 'A';
		else if(score >= 80) grade = 'B';
		else if(score >= 70) grade = 'C';
		else if(score >= 60) grade = 'D';
		else grade = 'F';
		
		System.out.printf("Your grade is %c\n", grade);
	}

}
