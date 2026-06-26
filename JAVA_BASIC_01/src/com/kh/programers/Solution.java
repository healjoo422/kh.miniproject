package com.kh.programers;

class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
		int num1 = box[0] / n;
		int num2 = box[1] / n;
		int num3 = box[2] / n;
		answer = num1 * num2 * num3;
        return answer;
    }
}

/*
 * 1 2 3 4
 * 12 13 0 5
 * 11 14 15 6
 * 10 9 8 7
 */



// A: 65 Z: 90 a: 97 z:122
