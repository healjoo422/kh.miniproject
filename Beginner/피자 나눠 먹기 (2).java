/*
문제명: 피자 나눠 먹기 (2)
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120815
요약: 6조각으로 나뉜 피자를 n명이 똑같이 나눠 먹을 때, 남는 조각 없이 모두 같은 개수를 먹으려면 필요한 최소 피자 판 수를 구하는 문제입니다.
접근: 한 판은 6조각이므로 전체 조각 수가 n과 6의 공배수가 되어야 합니다. 최소공배수를 이용하면 필요한 피자 수는 lcm(n, 6) / 6이고, 이는 n / gcd(n, 6)으로 간단히 구할 수 있습니다.
제한사항:
- 1 ≤ n ≤ 100
*/

class Solution_003 {
    public int solution(int n) {
        return n / gcd(n, 6);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
