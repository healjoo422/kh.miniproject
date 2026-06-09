package com.kh.loop.practice;

public class Practice7 {

	public static void main(String[] args) {
		// 구구단 출력
		for(int i=1; i++<9; ) {
			for(int j=0; j++<9; ) {
				System.out.printf("%d x %d = %d \n",i,j,i*j);
			}
		}

	}

}
