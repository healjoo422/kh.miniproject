/*
문제명: 영어가 싫어요
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120894
요약: 영단어로 이어 붙여 쓴 숫자 문자열이 주어질 때, 각 단어를 실제 숫자 문자로 바꿔 하나의 수로 반환하는 문제입니다. zero부터 nine까지의 단어만 순서대로 섞여 있으므로 이를 차례로 변환하면 됩니다.
접근: 각 숫자 영단어를 대응하는 숫자 문자로 순서대로 치환합니다. 치환이 끝난 문자열을 long으로 변환해 반환하면 됩니다.
제한사항:
- numbers는 소문자로만 구성되어 있습니다.
- numbers는 "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" 들이 공백 없이 조합되어 있습니다.
- 1 ≤ numbers의 길이 ≤ 50
- "zero"는 numbers의 맨 앞에 올 수 없습니다.
*/

class Solution_025 {
    public long solution(String numbers) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < words.length; i++) {
            numbers = numbers.replace(words[i], String.valueOf(i));
        }
        return Long.parseLong(numbers);
    }
}
