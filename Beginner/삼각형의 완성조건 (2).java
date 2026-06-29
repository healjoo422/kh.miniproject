/*
문제명: 삼각형의 완성조건 (2)
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120868
요약: 주어진 두 변의 길이를 이용해 삼각형이 되도록 나머지 한 변의 정수 길이가 몇 개인지 구하는 문제입니다. 삼각형 조건인 가장 긴 변이 나머지 두 변의 합보다 작아야 한다는 점을 이용하면 됩니다.
접근: 두 수 중 작은 값을 min, 큰 값을 max로 둡니다. 세 번째 변이 가장 긴 경우와 기존 변이 가장 긴 경우를 나누어 세면 가능한 개수는 모두 합쳐서 2 * min - 1이 됩니다.
제한사항:
- sides의 원소는 자연수입니다.
- sides의 길이는 2입니다.
- 1 ≤ sides의 원소 ≤ 1,000
*/

class Solution_024 {
    public int solution(int[] sides) {
        int min = Math.min(sides[0], sides[1]);
        return min * 2 - 1;
    }
}
