/*
문제명: 안전지대
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120866
요약: 지뢰가 놓인 칸과 그 주변 8방향 칸을 모두 위험지역으로 표시한 뒤, 끝까지 위험하지 않은 칸의 개수를 구하는 문제입니다.
접근: 지뢰를 찾을 때마다 자기 자신과 주변 8칸을 위험지역으로 표시합니다. 모든 표시가 끝난 뒤 위험지역이 아닌 칸만 세어서 반환하면 됩니다.
제한사항:
- board는 n * n 배열입니다.
- 1 ≤ n ≤ 100
- 지뢰는 1로 표시되어 있습니다.
- board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
*/

class Solution_041 {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] danger = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    for (int dx = -1; dx <= 1; dx++) {
                        for (int dy = -1; dy <= 1; dy++) {
                            int nx = i + dx;
                            int ny = j + dy;

                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                danger[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!danger[i][j]) {
                    safeCount++;
                }
            }
        }

        return safeCount;
    }
}
