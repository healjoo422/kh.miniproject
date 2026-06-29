/*
문제명: 다항식 더하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120863
요약: 덧셈으로만 이루어진 일차식 문자열에서 x항과 상수항을 각각 모아 간단한 형태의 식으로 바꾸는 문제입니다. 같은 종류의 항을 더한 뒤, x항을 앞에 두고 불필요한 1이나 0은 생략해 가장 짧게 표현하면 됩니다.
접근: 문자열을 ` + ` 기준으로 나눈 뒤 각 항이 x항인지 상수항인지 구분해 따로 합칩니다. 마지막에 x의 계수와 상수값을 조건에 맞게 조합해 결과 문자열을 만듭니다.
제한사항:
- 0 < polynomial에 있는 수 < 100
- polynomial에 변수는 'x'만 존재합니다.
- polynomial은 양의 정수, 공백, ‘x’, ‘+'로 이루어져 있습니다.
- 항과 연산기호 사이에는 항상 공백이 존재합니다.
- 공백은 연속되지 않으며 시작이나 끝에는 공백이 없습니다.
- 하나의 항에서 변수가 숫자 앞에 오는 경우는 없습니다.
- " + 3xx + + x7 + "와 같은 잘못된 입력은 주어지지 않습니다.
- 0으로 시작하는 수는 없습니다.
- 문자와 숫자 사이의 곱하기는 생략합니다.
- polynomial에는 일차 항과 상수항만 존재합니다.
- 계수 1은 생략합니다.
- 결괏값에 상수항은 마지막에 둡니다.
- 0 < polynomial의 길이 < 50
*/

class Solution_036 {
    public String solution(String polynomial) {
        String[] terms = polynomial.split(" \\+ ");
        int xSum = 0;
        int constantSum = 0;

        for (String term : terms) {
            if (term.contains("x")) {
                if (term.equals("x")) {
                    xSum += 1;
                } else {
                    xSum += Integer.parseInt(term.substring(0, term.length() - 1));
                }
            } else {
                constantSum += Integer.parseInt(term);
            }
        }

        StringBuilder answer = new StringBuilder();

        if (xSum > 0) {
            if (xSum == 1) {
                answer.append("x");
            } else {
                answer.append(xSum).append("x");
            }
        }

        if (constantSum > 0) {
            if (answer.length() > 0) {
                answer.append(" + ");
            }
            answer.append(constantSum);
        }

        return answer.toString();
    }
}
