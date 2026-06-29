/*
문제명: 평행
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120875
요약: 네 개의 점에서 두 점씩 이어 만들 수 있는 두 직선 쌍들 중, 기울기가 같은 경우가 하나라도 있으면 1을 반환하고 없으면 0을 반환하는 문제입니다. 실수 계산 대신 두 선분의 기울기를 곱셈으로 비교하면 안전하게 판별할 수 있습니다.
접근: 서로 겹치지 않는 두 선분을 만드는 경우는 3가지뿐이므로 각각만 확인하면 됩니다. 두 선분의 기울기가 같은지는 (y 차이)와 (x 차이)를 교차 곱해서 비교합니다.
제한사항:
- dots의 길이 = 4
- dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
- 0 ≤ x, y ≤ 100
- 서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
- 두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
- 임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.
*/

class Solution_043 {
    public int solution(int[][] dots) {
        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }

    private boolean isParallel(int[] a, int[] b, int[] c, int[] d) {
        int dy1 = b[1] - a[1];
        int dx1 = b[0] - a[0];
        int dy2 = d[1] - c[1];
        int dx2 = d[0] - c[0];
        return dy1 * dx2 == dy2 * dx1;
    }
}
