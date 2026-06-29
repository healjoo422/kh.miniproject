/*
문제명: 한 번만 등장한 문자
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120896
요약: 주어진 소문자 문자열에서 딱 한 번만 나온 문자들만 골라 알파벳 순서대로 이어 붙여 반환하는 문제입니다. 그런 문자가 없으면 빈 문자열을 반환하면 됩니다.
접근: 알파벳마다 등장 횟수를 먼저 셉니다. 그다음 a부터 z까지 순서대로 보며 횟수가 1인 문자만 결과에 추가하면 자동으로 정렬된 문자열을 만들 수 있습니다.
제한사항:
- 0 < s의 길이 < 1,000
- s는 소문자로만 이루어져 있습니다.
*/

class Solution_015 {
    public String solution(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                answer.append((char) ('a' + i));
            }
        }

        return answer.toString();
    }
}
