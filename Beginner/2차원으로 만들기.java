/*
문제명: 2차원으로 만들기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120842
요약: 1차원 정수 배열을 앞에서부터 n개씩 끊어서 여러 행으로 이루어진 2차원 배열로 바꾸는 문제입니다. 배열 길이는 항상 n의 배수이므로 남는 원소 없이 순서대로 채우면 됩니다.
접근: 행의 개수는 num_list.length / n으로 구합니다. 2차원 배열을 만든 뒤, 각 원소를 result[i / n][i % n] 위치에 순서대로 넣으면 됩니다.
제한사항:
- num_list의 길이는 n의 배 수개입니다.
- 0 ≤ num_list의 길이 ≤ 150
- 2 ≤ n < num_list의 길이
*/

class Solution_006 {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];

        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }

        return answer;
    }
}
