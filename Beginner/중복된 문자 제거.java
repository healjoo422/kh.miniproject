/*
문제명: 중복된 문자 제거
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120888
요약: 문자열에서 같은 문자가 여러 번 나오더라도 가장 먼저 나온 문자만 남기고, 나머지는 제거한 결과를 구하는 문제입니다. 공백과 대소문자도 각각 서로 다른 문자로 처리합니다.
접근: 문자를 앞에서부터 순서대로 확인하면서 이미 나온 문자인지 기록합니다. 처음 나온 문자만 StringBuilder에 추가하면 원하는 순서를 유지하며 중복을 제거할 수 있습니다.
제한사항:
- 1 ≤ my_string ≤ 110
- my_string은 대문자, 소문자, 공백으로 구성되어 있습니다.
- 대문자와 소문자를 구분합니다.
- 공백(" ")도 하나의 문자로 구분합니다.
- 중복된 문자 중 가장 앞에 있는 문자를 남깁니다.
*/

class Solution_009 {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        boolean[] seen = new boolean[128];

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (!seen[c]) {
                seen[c] = true;
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
