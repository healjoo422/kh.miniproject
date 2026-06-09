package com.kh.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopy {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] origin1 = {1,2,3,4,5};
		int[] copy1 = origin1;
		
		for(int n: origin1) {
			System.out.print(n + " ");
		}	System.out.println();
		
		for(int n: copy1) {
			System.out.print(n + " ");
		}	System.out.println();
		
		// 얕은 복사 : 주소만 참조하여 이름표만 복사하는 케이스
		
		copy1[1] = 100;
		
		for(int n: origin1) {
			System.out.print(n + " ");
		}	System.out.println();
		
		for(int n: copy1) {
			System.out.print(n + " ");
		}	System.out.println();
		
		System.out.println("===copy print===");
		for(int i : copy1) {
			System.out.print(i + " ");
		}	System.out.println();
		
		// 깊은 복사 : 실제 내용물의 카피본을 만드는 케이스 
		
		int[] origin2 = {1,2,3,4,5};
		int[] copy2 = new int[origin2.length];
		int cnt = 0;
		for(int i : origin2) {
			copy2[cnt] = i;
		}
		
		
		int[] origin3 = {1,2,3,4,5};
		int[] copy3 = origin3.clone();
		
		sc.close();
	}

}
