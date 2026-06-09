package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
	}
	
	public String afterToken(String str) {
		StringTokenizer st = new StringTokenizer(str, " ");
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreTokens()) {
			sb.append(st.nextToken());
		}
	
		return sb.toString();
	}
	
	public String firstCap(String input) {
		/*
		char[] chArr = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		if(chArr[0] >= 97 && chArr[0] <= 122)
			chArr[0] -= 32;
		
		for(char ch : chArr) {
			sb.append(ch);
		}
		
		return sb.toString();
		*/
		
		char first = input.toUpperCase().charAt(0);
		return first + input.substring(1);
	}
	
	public int findChar(String input, char one) {
		/*
		char[] chArr = input.toCharArray();
		
		int cnt=0;

		for(char ch : chArr) {
			if(ch == one)
				cnt++;
		}
	
		return cnt;
		*/
		
		return (int)input.chars()
				.filter(c -> c == one)
				.count();
	}
}
