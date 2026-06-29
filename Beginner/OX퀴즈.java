/*
문제명: OX퀴즈
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120907
요약: 문자열로 주어진 덧셈·뺄셈 식들을 하나씩 계산해 결과가 맞는지 판별하고, 맞으면 O 틀리면 X를 같은 순서로 반환하는 문제입니다. 음수가 포함될 수 있으므로 공백 기준으로 나눈 뒤 정수로 계산하면 됩니다.
접근: 각 식을 공백으로 분리하면 피연산자, 연산자, 결과를 쉽게 얻을 수 있습니다. 연산자가 +인지 -인지에 따라 계산한 값과 결과값을 비교해 O 또는 X를 저장합니다.
제한사항:
- 연산 기호와 숫자 사이는 항상 하나의 공백이 존재합니다. 단 음수를 표시하는 마이너스 기호와 숫자 사이에는 공백이 존재하지 않습니다.
- 1 ≤ quiz의 길이 ≤ 10
- X, Y, Z는 각각 0부터 9까지 숫자로 이루어진 정수를 의미하며, 각 숫자의 맨 앞에 마이너스 기호가 하나 있을 수 있고 이는 음수를 의미합니다.
- X, Y, Z는 0을 제외하고는 0으로 시작하지 않습니다.
- -10,000 ≤ X, Y ≤ 10,000
- -20,000 ≤ Z ≤ 20,000
- [연산자]는 + 와 - 중 하나입니다.
*/

class Solution_038 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] parts = quiz[i].split(" ");
            int x = Integer.parseInt(parts[0]);
            String op = parts[1];
            int y = Integer.parseInt(parts[2]);
            int z = Integer.parseInt(parts[4]);

            int result;
            if (op.equals("+")) {
                result = x + y;
            } else {
                result = x - y;
            }

            answer[i] = (result == z) ? "O" : "X";
        }

        return answer;
    }
}
