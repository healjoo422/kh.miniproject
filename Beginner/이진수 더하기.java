/*
문제명: 이진수 더하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120885
요약: 두 개의 이진수 문자열이 주어질 때, 이를 더한 결과를 다시 이진수 문자열로 반환하는 문제입니다. 입력 길이가 짧으므로 정수로 바꿔 계산한 뒤 다시 이진수로 변환하면 됩니다.
접근: 각 이진수 문자열을 2진수 기준으로 정수로 변환합니다. 두 값을 더한 뒤 결과를 다시 2진수 문자열로 바꿔 반환합니다.
제한사항:
- return 값은 이진수를 의미하는 문자열입니다.
- 1 ≤ bin1, bin2의 길이 ≤ 10
- bin1과 bin2는 0과 1로만 이루어져 있습니다.
- bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.
*/

class Solution_020 {
    public String solution(String bin1, String bin2) {
        int num1 = Integer.parseInt(bin1, 2);
        int num2 = Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(num1 + num2);
    }
}
