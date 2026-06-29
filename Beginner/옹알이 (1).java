/*
문제명: 옹알이 (1)
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120956
요약: 주어진 문자열 배열에서 아기가 말할 수 있는 발음 조각 "aya", "ye", "woo", "ma"만 이어서 만든 단어가 몇 개인지 세는 문제입니다. 각 문자열이 처음부터 끝까지 이 발음들로 정확히 나뉘는지 확인하면 됩니다.
접근: 각 단어를 왼쪽부터 보면서 현재 위치에서 시작하는 발음 조각이 있는지 검사합니다. 맞는 조각이 나오면 그 길이만큼 이동하고, 끝까지 모두 맞으면 가능한 단어로 셉니다.
제한사항:
- 1 ≤ babbling의 길이 ≤ 100
- 1 ≤ babbling[i]의 길이 ≤ 15
- babbling의 각 문자열에서 "aya", "ye", "woo", "ma"는 각각 최대 한 번씩만 등장합니다.
- 즉, 각 문자열의 가능한 모든 부분 문자열 중에서 "aya", "ye", "woo", "ma"가 한 번씩만 등장합니다.
- 문자열은 알파벳 소문자로만 이루어져 있습니다.
*/

class Solution_044 {
    public int solution(String[] babbling) {
        String[] words = {"aya", "ye", "woo", "ma"};
        int count = 0;

        for (String babble : babbling) {
            int index = 0;

            while (index < babble.length()) {
                boolean matched = false;

                for (String word : words) {
                    if (babble.startsWith(word, index)) {
                        index += word.length();
                        matched = true;
                        break;
                    }
                }

                if (!matched) {
                    break;
                }
            }

            if (index == babble.length()) {
                count++;
            }
        }

        return count;
    }
}
