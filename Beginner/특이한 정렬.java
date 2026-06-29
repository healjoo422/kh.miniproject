/*
문제명: 특이한 정렬
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120880
요약: 정수 배열을 기준값 n에 얼마나 가까운지에 따라 정렬하는 문제입니다. 거리가 같으면 더 큰 수가 먼저 오도록 순서를 정하면 됩니다.
접근: 배열을 Integer 배열로 바꾼 뒤 사용자 정의 정렬 기준을 적용합니다. 먼저 n과의 거리 오름차순으로 비교하고, 거리가 같으면 값 내림차순으로 비교한 후 다시 int 배열로 담아 반환합니다.
제한사항:
- 1 ≤ n ≤ 10,000
- 1 ≤ numlist의 원소 ≤ 10,000
- 1 ≤ numlist의 길이 ≤ 100
- numlist는 중복된 원소를 갖지 않습니다.
*/

import java.util.*;

class Solution_037 {
    public int[] solution(int[] numlist, int n) {
        Integer[] arr = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            arr[i] = numlist[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int diffA = Math.abs(a - n);
                int diffB = Math.abs(b - n);

                if (diffA != diffB) {
                    return diffA - diffB;
                }
                return b - a;
            }
        });

        int[] answer = new int[numlist.length];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        return answer;
    }
}
