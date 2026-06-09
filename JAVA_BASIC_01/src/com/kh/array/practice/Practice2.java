package com.kh.array.practice;

import java.util.Scanner;

public class Practice2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int arrayLength;
		int[] iArray;
		int iMax, iMin;
		
		System.out.print("길이입력 : ");
		arrayLength = sc.nextInt();
		iArray = new int[arrayLength];
		
		for(int i=0; i<iArray.length; i++) {
			iArray[i] = sc.nextInt();
		}
		
		iMax = iArray[0];
		iMin = iArray[0];
		/*
		for(int i=1; i<iArray.length; i++) {
			if(iArray[i] < iMin) iMin = iArray[i];
			else if(iArray[i] > iMax) iMax = iArray[i];
		}
		*/
		for(int num: iArray) {
			if(num < iMin) iMin = num;
			else if(num > iMax) iMax = num;
		}
		
		System.out.println(iMin + " " + iMax);
		
		sc.close();
	}

}
