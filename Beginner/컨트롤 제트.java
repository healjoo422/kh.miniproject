/*
문제명: 컨트롤 제트
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120853
요약: 공백으로 구분된 문자열을 순서대로 보면서 숫자는 더하고, Z가 나오면 직전에 더했던 숫자를 다시 빼서 최종 합을 구하는 문제입니다.
접근: 문자열을 공백 기준으로 나눈 뒤 순회합니다. 숫자가 나오면 합계와 직전 값에 반영하고, Z가 나오면 직전 값을 합계에서 빼면 됩니다.
제한사항:
- 1 ≤ s의 길이 ≤ 200
- -1,000 < s의 원소 중 숫자 < 1,000
- s는 숫자, "Z", 공백으로 이루어져 있습니다.
- s에 있는 숫자와 "Z"는 서로 공백으로 구분됩니다.
- 연속된 공백은 주어지지 않습니다.
- 0을 제외하고는 0으로 시작하는 숫자는 없습니다.
- s는 "Z"로 시작하지 않습니다.
- s의 시작과 끝에는 공백이 없습니다.
- "Z"가 연속해서 나오는 경우는 없습니다.
*/

class Solution_017 {
    public int solution(String s) {
        String[] tokens = s.split(" ");
        int sum = 0;
        int last = 0;

        for (String token : tokens) {
            if (token.equals("Z")) {
                sum -= last;
            } else {
                last = Integer.parseInt(token);
                sum += last;
            }
        }

        return sum;
    }
}
