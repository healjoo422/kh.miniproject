package com.kh.loop.practice;

public class Practice4 {

	public static void main(String[] args) {
		// 7의 배수찾기
		
		for(int i=0; i++<100; ) {
			if(i % 7 != 0) continue; 
			if(i % 2 == 0) continue; 
			System.out.printf("%d ", i);
		}

	}

}
