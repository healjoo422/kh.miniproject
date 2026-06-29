/*
문제명: 등수 매기기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120882
요약: 각 학생의 영어와 수학 점수를 바탕으로 평균이 높은 순서대로 등수를 구하는 문제입니다. 같은 평균이면 같은 등수를 가져야 합니다.
접근: 평균 대신 두 점수의 합을 비교해도 순서는 같습니다. 각 학생보다 합이 더 큰 학생 수를 세고, 그 수에 1을 더해 등수를 만들면 됩니다.
제한사항:
- 0 ≤ score[0], score[1] ≤ 100
- 1 ≤ score의 길이 ≤ 10
- score의 원소 길이는 2입니다.
- score는 중복된 원소를 갖지 않습니다.
*/

class Solution_032 {
    public int[] solution(int[][] score) {
        int n = score.length;
        int[] answer = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            sum[i] = score[i][0] + score[i][1];
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (sum[j] > sum[i]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }
}
