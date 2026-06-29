/*
문제명: 숫자 찾기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120904
요약: 정수 num의 각 자리를 왼쪽부터 확인해 숫자 k가 처음 나타나는 위치를 구하는 문제입니다. 해당 숫자가 없으면 -1을 반환하면 됩니다.
접근: num을 문자열로 바꾼 뒤 문자 단위로 순서대로 확인합니다. k와 같은 문자를 처음 찾으면 1부터 시작하는 위치를 반환하고, 끝까지 없으면 -1을 반환합니다.
제한사항:
- 0 < num < 1,000,000
- 0 ≤ k < 10
- num에 k가 여러 개 있으면 가장 처음 나타나는 자리를 return 합니다.
*/

class Solution_001 {
    public int solution(int num, int k) {
        String s = String.valueOf(num);
        char target = (char) ('0' + k);

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) {
                return i + 1;
            }
        }

        return -1;
    }
}
