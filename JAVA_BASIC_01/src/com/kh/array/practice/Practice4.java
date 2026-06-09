package com.kh.array.practice;


import java.util.Scanner;

public class Practice4 {

	public static void main(String[] args) {
		// 과제 안 내신 분?
		Scanner sc = new Scanner(System.in);
		
		boolean[] students = new boolean[30];

		for(int i=0; i<students.length; i++) {
			students[i] = false;
		}
		
		for(int i=0; i<28; i++) {
			students[sc.nextInt()-1] = true;
		}
		
		for(int i=0; i<students.length; i++) {
			if(!students[i]) System.out.print(i+1 + " ");
		}
		
		sc.close();
	}

}
