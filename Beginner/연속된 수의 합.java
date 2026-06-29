/*
문제명: 연속된 수의 합
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120923
요약: 연속된 정수 num개를 더해서 total이 되는 수열을 찾아 오름차순 배열로 반환하는 문제입니다. 조건상 항상 가능한 경우만 주어집니다.
접근: 연속된 수를 x부터 시작한다고 두면 합은 num * x + 0부터 num-1까지의 합이 됩니다. 이 식으로 시작값 x를 구한 뒤, x부터 num개를 차례대로 배열에 넣으면 됩니다.
제한사항:
- 1 ≤ num ≤ 100
- 0 ≤ total ≤ 1000
- num개의 연속된 수를 더하여 total이 될 수 없는 테스트 케이스는 없습니다.
*/

class Solution_040 {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int start = (total - (num * (num - 1) / 2)) / num;

        for (int i = 0; i < num; i++) {
            answer[i] = start + i;
        }

        return answer;
    }
}
