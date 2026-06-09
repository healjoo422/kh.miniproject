package com.kh.loop;

public class Continue1 {

	public static void main(String[] args) {
		
		/*
		 * 1~50까지의 수 중에서 5의 배수만 출력
		 */
		
		for(int i=0; i++<50; ) {
			if(i % 5 != 0) continue;
			System.out.print(i + " ");
		}
		
	}

}
