package com.kh.objectarray;

public class Run {

	public static void main(String[] args) {
		
		Book[] bookArr = new Book[3];
		
		System.out.println(bookArr);
		System.out.println(bookArr[0]);
		System.out.println(bookArr[1]);
		System.out.println(bookArr[2]);

		
		bookArr[0] = new Book();
		bookArr[1] = new Book();
		bookArr[2] = new Book();
		System.out.println(bookArr[0]);
		System.out.println(bookArr[1]);
		System.out.println(bookArr[2]);

		
		
	}

}
