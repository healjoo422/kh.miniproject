/*
문제명: 문자열 계산하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120902
요약: 공백으로 구분된 덧셈·뺄셈 수식을 문자열로 받아, 왼쪽부터 순서대로 계산한 결과를 구하는 문제입니다. 숫자와 연산자를 차례로 읽으며 최종 값을 반환하면 됩니다.
접근: 문자열을 공백 기준으로 나누면 숫자와 연산자가 번갈아 나옵니다. 첫 숫자를 시작값으로 두고, 이후에는 연산자에 따라 다음 숫자를 더하거나 빼면 됩니다.
제한사항:
- 연산자는 +, -만 존재합니다.
- 문자열의 시작과 끝에는 공백이 없습니다.
- 0으로 시작하는 숫자는 주어지지 않습니다.
- 잘못된 수식은 주어지지 않습니다.
- 5 ≤ my_string의 길이 ≤ 100
- my_string을 계산한 결과값은 1 이상 100,000 이하입니다.
- my_string의 중간 계산 값은 -100,000 이상 100,000 이하입니다.
- 계산에 사용하는 숫자는 1 이상 20,000 이하인 자연수입니다.
- my_string에는 연산자가 적어도 하나 포함되어 있습니다.
- return type 은 정수형입니다.
- my_string의 숫자와 연산자는 공백 하나로 구분되어 있습니다.
*/

class Solution_022 {
    public int solution(String my_string) {
        String[] tokens = my_string.split(" ");
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int number = Integer.parseInt(tokens[i + 1]);

            if (operator.equals("+")) {
                result += number;
            } else {
                result -= number;
            }
        }

        return result;
    }
}
