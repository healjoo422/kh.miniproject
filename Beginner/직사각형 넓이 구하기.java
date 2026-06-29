/*
문제명: 직사각형 넓이 구하기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120860
요약: 축과 평행한 직사각형의 네 꼭짓점이 주어질 때, 가로 길이와 세로 길이를 구해 넓이를 계산하는 문제입니다. 좌표들에서 가장 작은 값과 큰 값을 찾으면 변의 길이를 쉽게 구할 수 있습니다.
접근: 모든 점의 x좌표와 y좌표에서 각각 최솟값과 최댓값을 찾습니다. 가로는 x의 차이, 세로는 y의 차이이므로 두 값을 곱해 넓이를 반환합니다.
제한사항:
- dots의 길이 = 4
- dots의 원소의 길이 = 2
- -256 < dots[i]의 원소 < 256
- 잘못된 입력은 주어지지 않습니다.
*/

class Solution_029 {
    public int solution(int[][] dots) {
        int minX = dots[0][0];
        int maxX = dots[0][0];
        int minY = dots[0][1];
        int maxY = dots[0][1];

        for (int i = 1; i < dots.length; i++) {
            minX = Math.min(minX, dots[i][0]);
            maxX = Math.max(maxX, dots[i][0]);
            minY = Math.min(minY, dots[i][1]);
            maxY = Math.max(maxY, dots[i][1]);
        }

        return (maxX - minX) * (maxY - minY);
    }
}
