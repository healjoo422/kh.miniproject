/*
문제명: 모스부호 (1)
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120838
요약: 공백으로 구분된 모스부호 문자열이 주어졌을 때, 각 부호를 대응하는 알파벳 소문자로 바꿔 원래 문장을 복원하는 문제입니다. 모든 입력은 해독 가능한 형태이므로 순서대로 변환해 이어 붙이면 됩니다.
접근: 모스부호와 알파벳의 대응을 배열로 준비합니다. 입력 문자열을 공백 기준으로 나눈 뒤, 각 모스부호를 찾아 알파벳으로 바꾸고 결과 문자열에 이어 붙입니다.
제한사항:
- 1 ≤ letter의 길이 ≤ 1,000
- return값은 소문자입니다.
- letter의 모스부호는 공백으로 나누어져 있습니다.
- letter에 공백은 연속으로 두 개 이상 존재하지 않습니다.
- 해독할 수 없는 편지는 주어지지 않습니다.
- 편지의 시작과 끝에는 공백이 없습니다.
*/

import java.util.*;

class Solution_011 {
    public String solution(String letter) {
        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            map.put(morse[i], (char)('a' + i));
        }

        StringBuilder answer = new StringBuilder();
        String[] codes = letter.split(" ");
        for (String code : codes) {
            answer.append(map.get(code));
        }

        return answer.toString();
    }
}
