/*
문제명: 합성수 찾기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120846
요약: 자연수 n 이하에서 합성수인 숫자가 몇 개인지 세는 문제입니다. 합성수는 약수가 3개 이상인 수이므로 1부터 n까지 각각 판별하면 됩니다.
접근: 2부터 n까지 각 수의 약수 개수를 셉니다. 약수가 3개 이상이면 합성수로 보고 개수를 증가시킵니다.
제한사항:
- 1 ≤ n ≤ 100
*/

class Solution_005 {
    public int solution(int n) {
        int count = 0;

        for (int i = 2; i <= n; i++) {
            int divisorCount = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCount++;
                }
            }

            if (divisorCount >= 3) {
                count++;
            }
        }

        return count;
    }
}
