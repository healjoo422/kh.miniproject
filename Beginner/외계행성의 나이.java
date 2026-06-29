/*
문제명: 외계행성의 나이
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120834
요약: 주어진 나이를 각 자리 숫자로 나눈 뒤, 0부터 9까지를 각각 a부터 j로 바꾼 문자열을 만드는 문제입니다. 예를 들어 23은 2→c, 3→d로 변환해 "cd"가 됩니다.
접근: 나이를 문자열로 바꾼 뒤 각 문자를 순회합니다. 숫자 문자에서 '0'을 빼 인덱스를 얻고, 'a'를 더해 대응하는 알파벳으로 변환하면 됩니다.
제한사항:
- age는 자연수입니다.
- age ≤ 1,000
- PROGRAMMERS-962 행성은 알파벳 소문자만 사용합니다.
*/

class Solution_004 {
    public String solution(int age) {
        String str = String.valueOf(age);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char digit = str.charAt(i);
            sb.append((char) ('a' + (digit - '0')));
        }

        return sb.toString();
    }
}
