/*
문제명: 유한소수 판별하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120878
요약: 분수 a/b를 기약분수로 만든 뒤, 소수로 나타냈을 때 끝나는 유한소수인지 판별하는 문제입니다. 기약분수의 분모에 2와 5 이외의 소인수가 남으면 무한소수가 됩니다.
접근: 먼저 최대공약수로 a와 b를 나눠 분수를 기약분수로 만듭니다. 그다음 분모에서 2와 5를 계속 제거하고, 마지막에 1이 되면 유한소수이므로 1을 반환하고 아니면 2를 반환합니다.
제한사항:
- a, b는 정수
- 0 < a ≤ 1,000
- 0 < b ≤ 1,000
*/

class Solution_035 {
    public int solution(int a, int b) {
        int gcd = gcd(a, b);
        b /= gcd;

        while (b % 2 == 0) {
            b /= 2;
        }
        while (b % 5 == 0) {
            b /= 5;
        }

        return b == 1 ? 1 : 2;
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}
