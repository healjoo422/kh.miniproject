/*
문제명: 7의 개수
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120912
요약: 정수 배열의 모든 원소를 살펴보면서 각 숫자 안에 들어 있는 7의 개수를 모두 합해 반환하는 문제입니다. 배열 전체에서 숫자 7이 몇 번 등장하는지 세면 됩니다.
접근: 각 원소를 문자열로 바꾸거나 자릿수로 나누어 7인지 확인하면 됩니다. 여기서는 문자열로 변환한 뒤 문자 하나씩 검사해 7이 나오면 개수를 증가시킵니다.
제한사항:
- 1 ≤ array의 길이 ≤ 100
- 0 ≤ array의 원소 ≤ 100,000
*/

class Solution_016 {
    public int solution(int[] array) {
        int count = 0;

        for (int num : array) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '7') {
                    count++;
                }
            }
        }

        return count;
    }
}
