/*
문제명: 진료순서 정하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120835
요약: 응급실 환자들의 응급도 배열이 주어질 때, 응급도가 가장 높은 사람부터 1번으로 하여 각 환자의 진료 순서를 구하는 문제입니다. 같은 응급도는 없으므로 각 값의 상대적 크기만 비교하면 됩니다.
접근: 각 환자보다 더 큰 응급도가 몇 개인지 세면 그 사람의 순서를 바로 알 수 있습니다. 자기보다 큰 값의 개수에 1을 더해 결과 배열에 넣으면 됩니다.
제한사항:
- 중복된 원소는 없습니다.
- 1 ≤ emergency의 길이 ≤ 10
- 1 ≤ emergency의 원소 ≤ 100
*/

class Solution_010 {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (emergency[j] > emergency[i]) {
                    rank++;
                }
            }
            answer[i] = rank;
        }

        return answer;
    }
}
