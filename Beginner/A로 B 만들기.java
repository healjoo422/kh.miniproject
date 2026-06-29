/*
문제명: A로 B 만들기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120886
요약: 두 문자열의 글자 구성이 같아서 순서만 바꿔 서로 만들 수 있는지 확인하는 문제입니다. 같은 길이의 두 문자열에서 각 알파벳의 개수를 비교해 판단하면 됩니다.
접근: 두 문자열을 한 번씩 순회하며 알파벳 개수를 셉니다. before에서 증가시키고 after에서 감소시킨 뒤, 모든 값이 0이면 만들 수 있으므로 1을 반환합니다.
제한사항:
- 0 < before의 길이 == after의 길이 < 1,000
- before와 after는 모두 소문자로 이루어져 있습니다.
*/

class Solution_007 {
    public int solution(String before, String after) {
        int[] count = new int[26];

        for (int i = 0; i < before.length(); i++) {
            count[before.charAt(i) - 'a']++;
            count[after.charAt(i) - 'a']--;
        }

        for (int value : count) {
            if (value != 0) {
                return 0;
            }
        }

        return 1;
    }
}
