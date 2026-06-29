/*
문제명: 겹치는 선분의 길이
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120876
요약: 세 개의 선분이 주어질 때, 두 개 이상이 동시에 덮는 구간들의 전체 길이를 구하는 문제입니다. 좌표 범위가 작으므로 각 1길이 구간마다 몇 개의 선분이 지나가는지 확인하면 됩니다.
접근: 정수 좌표 사이의 [x, x+1) 구간을 하나씩 표시합니다. 각 선분이 지나가는 구간의 카운트를 증가시키고, 마지막에 카운트가 2 이상인 구간 수를 합하면 겹친 길이가 됩니다.
제한사항:
- lines의 길이 = 3
- lines의 원소의 길이 = 2
- 모든 선분은 길이가 1 이상입니다.
- lines의 원소는 [a, b] 형태이며, a, b는 각각 선분의 양 끝점 입니다.
- -100 ≤ a < b ≤ 100
*/

class Solution_042 {
    public int solution(int[][] lines) {
        int[] count = new int[201];

        for (int[] line : lines) {
            int start = line[0];
            int end = line[1];
            for (int x = start; x < end; x++) {
                count[x + 100]++;
            }
        }

        int answer = 0;
        for (int c : count) {
            if (c >= 2) {
                answer++;
            }
        }

        return answer;
    }
}
