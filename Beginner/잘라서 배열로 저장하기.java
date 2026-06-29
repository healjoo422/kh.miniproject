/*
문제명: 잘라서 배열로 저장하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120913
요약: 문자열을 앞에서부터 n글자씩 끊어서 순서대로 배열에 담아 반환하는 문제입니다. 마지막 조각의 길이가 n보다 짧아도 그대로 포함하면 됩니다.
접근: 전체 조각 개수를 먼저 계산한 뒤 문자열을 n칸씩 이동하며 잘라 넣습니다. 각 구간의 끝은 문자열 길이를 넘지 않도록 Math.min으로 처리합니다.
제한사항:
- 1 ≤ my_str의 길이 ≤ 100
- 1 ≤ n ≤ my_str의 길이
- my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.
*/

class Solution_018 {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int size = (len + n - 1) / n;
        String[] answer = new String[size];

        for (int i = 0; i < size; i++) {
            int start = i * n;
            int end = Math.min(start + n, len);
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
}
