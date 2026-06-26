package com.kh.programers;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        char[] arr = my_string.toCharArray();
        char temp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = temp;
        answer = new String(arr);
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
