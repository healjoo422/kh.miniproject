/*
문제명: 외계어 사전
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120869
요약: 주어진 알파벳 배열의 글자들을 각각 한 번씩 모두 사용해서 만들 수 있는 단어가 사전에 있는지 찾는 문제입니다. 조건에 맞는 단어가 있으면 1, 없으면 2를 반환하면 됩니다.
접근: spell의 문자들을 정렬해 기준 문자열을 만듭니다. 사전의 각 단어도 길이가 같을 때만 정렬해서 비교하면, 같은 문자들로만 이루어진 단어인지 쉽게 확인할 수 있습니다.
제한사항:
- spell과 dic의 원소는 알파벳 소문자로만 이루어져있습니다.
- 2 ≤ spell의 크기 ≤ 10
- spell의 원소의 길이는 1입니다.
- 1 ≤ dic의 크기 ≤ 10
- 1 ≤ dic의 원소의 길이 ≤ 10
- spell의 원소를 모두 사용해 단어를 만들어야 합니다.
- spell의 원소를 모두 사용해 만들 수 있는 단어는 dic에 두 개 이상 존재하지 않습니다.
- dic과 spell 모두 중복된 원소를 갖지 않습니다.
*/

import java.util.*;

class Solution_027 {
    public int solution(String[] spell, String[] dic) {
        char[] targetArr = new char[spell.length];
        for (int i = 0; i < spell.length; i++) {
            targetArr[i] = spell[i].charAt(0);
        }
        Arrays.sort(targetArr);
        String target = new String(targetArr);

        for (String word : dic) {
            if (word.length() != spell.length) {
                continue;
            }

            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            if (target.equals(new String(wordArr))) {
                return 1;
            }
        }

        return 2;
    }
}
