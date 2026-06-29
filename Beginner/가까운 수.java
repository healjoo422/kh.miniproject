/*
문제명: 가까운 수
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120890
요약: 정수 배열에서 기준값 n과의 차이가 가장 작은 값을 찾는 문제입니다. 차이가 같은 값이 여러 개라면 그중 더 작은 수를 반환하면 됩니다.
접근: 배열을 한 번 순회하면서 현재까지 가장 가까운 값을 저장합니다. 더 작은 차이를 발견하면 갱신하고, 차이가 같으면 더 작은 숫자로 바꿉니다.
제한사항:
- 1 ≤ array의 길이 ≤ 100
- 1 ≤ array의 원소 ≤ 100
- 1 ≤ n ≤ 100
- 가장 가까운 수가 여러 개일 경우 더 작은 수를 return 합니다.
*/

class Solution_014 {
    public int solution(int[] array, int n) {
        int answer = array[0];
        int minDiff = Math.abs(array[0] - n);

        for (int i = 1; i < array.length; i++) {
            int diff = Math.abs(array[i] - n);

            if (diff < minDiff) {
                minDiff = diff;
                answer = array[i];
            } else if (diff == minDiff && array[i] < answer) {
                answer = array[i];
            }
        }

        return answer;
    }
}
