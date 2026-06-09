package com.kh.programers;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		int n = 3;
		int[] slicer = {12, 4, 15, 1, 14};
		int[] num_list = {1, 5, 2};
		
		String str = "xaxbxcxdx";
		
		String[] str2 = str.split("x");
	
        ArrayList<String> myList = new ArrayList<String>();
        
        
        myList.sort(Comparator.naturalOrder());
		
		
		for(String s1 : str2) {
			System.out.println("e: "+s1);
		}
		
	//	int a = s.solution(slicer);
		
		

		
		

		
	}


}
