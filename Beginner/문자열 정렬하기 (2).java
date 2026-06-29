/*
문제명: 문자열 정렬하기 (2)
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120911
요약: 영문 대소문자가 섞인 문자열이 주어지면, 모든 문자를 소문자로 바꾼 뒤 알파벳 오름차순으로 정렬한 결과를 반환하는 문제입니다.
접근: 문자열을 먼저 소문자로 변환합니다. 그다음 문자 배열로 바꿔 정렬하고 다시 문자열로 합치면 됩니다.
제한사항:
- 0 < my_string 길이 < 100
*/
import java.util.Arrays;
class Solution_002 {
    public String solution(String my_string) {
        char[] chars = my_string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
