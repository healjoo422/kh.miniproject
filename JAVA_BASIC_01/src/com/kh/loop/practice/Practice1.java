package com.kh.loop.practice;
import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = -1;
		System.out.print("1~9사이의 숫자를 입력해주세요 : ");
		num1 = sc.nextInt();
		
		for(int i=0; i++<9; ) {
			System.out.printf("%d * %d = %d\n", num1, i, num1*i);
		}
		
		sc.close();
	}

}
