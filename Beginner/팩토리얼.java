/*
문제명: 팩토리얼
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120848
요약: 정수 n이 주어질 때, n을 넘지 않는 팩토리얼 값 중에서 가장 큰 i!를 만드는 정수 i를 구하는 문제입니다. 1부터 차례로 곱해 가며 조건을 만족하는 마지막 수를 찾으면 됩니다.
접근: 1부터 누적 곱을 계산하면서 값이 n 이하인 동안만 진행합니다. 다음 곱이 n을 초과하는 순간, 직전의 수가 정답입니다.
제한사항:
- 0 < n ≤ 3,628,800
*/

class Solution_012 {
    public int solution(int n) {
        int factorial = 1;
        int i = 1;
        
        while (factorial * (i + 1) <= n) {
            i++;
            factorial *= i;
        }
        
        return i;
    }
}
