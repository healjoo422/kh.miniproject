/*
문제명: 숨어있는 숫자의 덧셈 (2)
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120864
요약: 문자열 안에서 연속된 숫자들을 각각 하나의 자연수로 보고, 그 값들을 모두 더한 결과를 구하는 문제입니다. 숫자가 전혀 없으면 0을 반환하면 됩니다.
접근: 문자를 앞에서부터 보면서 숫자면 현재 수를 이어 붙이고, 문자가 나오면 지금까지 만든 수를 합계에 더한 뒤 초기화합니다. 반복이 끝난 뒤 마지막에 남은 수도 한 번 더 더해주면 됩니다.
제한사항:
- 1 ≤ my_string의 길이 ≤ 1,000
- 1 ≤ my_string 안의 자연수 ≤ 1000
- 연속된 수는 하나의 숫자로 간주합니다.
- 000123과 같이 0이 선행하는 경우는 없습니다.
- 문자열에 자연수가 없는 경우 0을 return 해주세요.
*/

class Solution_013 {
    public int solution(String my_string) {
        int sum = 0;
        int current = 0;

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);

            if (Character.isDigit(ch)) {
                current = current * 10 + (ch - '0');
            } else {
                sum += current;
                current = 0;
            }
        }

        sum += current;
        return sum;
    }
}
