/*
문제명: 저주의 숫자 3
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120871
요약: 자연수를 1부터 차례로 세되, 3의 배수이거나 숫자에 3이 들어가면 건너뛰는 규칙에서 n번째로 말하는 수를 구하는 문제입니다. 즉 일반 숫자 n을 3x 마을에서 사용하는 대응 숫자로 바꾸면 됩니다.
접근: 1부터 숫자를 늘려 가며 조건에 걸리는 수는 제외합니다. 유효한 수를 셀 때마다 개수를 증가시키고, n번째가 되는 순간 그 값을 반환합니다.
제한사항:
- 1 ≤ n ≤ 100
*/

class Solution_031 {
    public int solution(int n) {
        int count = 0;
        int number = 0;

        while (count < n) {
            number++;

            if (number % 3 == 0 || String.valueOf(number).contains("3")) {
                continue;
            }

            count++;
        }

        return number;
    }
}
