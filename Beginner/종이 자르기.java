/*
문제명: 종이 자르기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120922
요약: M x N 크기의 종이를 1 x 1 조각으로 모두 나누기 위해 필요한 최소 가위질 횟수를 구하는 문제입니다. 종이를 겹쳐 자를 수 없으므로 한 번 자를 때마다 조각 수가 정확히 1개씩 늘어납니다.
접근: 처음 종이는 1장이고, 최종적으로는 M*N장의 1 x 1 조각이 필요합니다. 가위질 한 번마다 조각 수가 1씩 증가하므로 필요한 최소 횟수는 M*N - 1입니다.
제한사항:
- 0 < M, N < 100
- 종이를 겹쳐서 자를 수 없습니다.
*/

class Solution_028 {
    public int solution(int M, int N) {
        return M * N - 1;
    }
}
