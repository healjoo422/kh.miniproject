/*
문제명: 문자열 밀기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120921
요약: 문자열 A를 오른쪽으로 한 칸씩 회전시켜 문자열 B를 만들 수 있는지 확인하고, 가능하다면 필요한 최소 이동 횟수를 구하는 문제입니다. 끝까지 회전해도 만들 수 없으면 -1을 반환합니다.
접근: A를 최대 길이만큼 한 칸씩 오른쪽으로 밀어 보면서 매번 B와 같은지 확인합니다. 처음 같아지는 순간의 횟수가 최소값이고, 끝까지 없으면 -1을 반환합니다.
제한사항:
- 0 < A의 길이 = B의 길이 < 100
- A, B는 알파벳 소문자로 이루어져 있습니다.
*/

class Solution_034 {
    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        String current = A;
        for (int i = 1; i <= A.length(); i++) {
            current = current.charAt(current.length() - 1) + current.substring(0, current.length() - 1);
            if (current.equals(B)) {
                return i;
            }
        }

        return -1;
    }
}
