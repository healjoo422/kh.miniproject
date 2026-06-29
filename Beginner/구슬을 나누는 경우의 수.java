/*
문제명: 구슬을 나누는 경우의 수
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120840
요약: 서로 다른 구슬 balls개 중에서 순서를 무시하고 share개를 고를 때 가능한 조합의 개수를 구하는 문제입니다. 즉, ballsCshare 값을 계산해 반환하면 됩니다.
접근: 조합의 성질을 이용해 nCr = nC(n-r)로 더 작은 쪽만 계산합니다. 분자와 분모를 차례대로 곱하고 나누는 방식으로 값을 구하면 범위 안에서 안전하게 계산할 수 있습니다.
제한사항:
- 1 ≤ balls ≤ 30
- 1 ≤ share ≤ 30
- 구슬을 고르는 순서는 고려하지 않습니다.
- share ≤ balls
*/

class Solution_023 {
    public int solution(int balls, int share) {
        int r = Math.min(share, balls - share);
        long result = 1;

        for (int i = 1; i <= r; i++) {
            result = result * (balls - r + i) / i;
        }

        return (int) result;
    }
}
