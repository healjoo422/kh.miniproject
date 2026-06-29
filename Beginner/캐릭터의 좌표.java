/*
문제명: 캐릭터의 좌표
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120861
요약: 방향키 입력을 순서대로 적용해 캐릭터가 최종적으로 도달하는 좌표를 구하는 문제입니다. 단, 이동 결과가 맵 범위를 벗어나면 그 입력은 무시해야 합니다.
접근: 가로와 세로의 이동 가능 최대 범위를 먼저 계산합니다. 각 방향키를 확인하면서 다음 위치가 범위 안일 때만 x 또는 y 값을 갱신하면 됩니다.
제한사항:
- board은 [가로 크기, 세로 크기] 형태로 주어집니다.
- board의 가로 크기와 세로 크기는 홀수입니다.
- board의 크기를 벗어난 방향키 입력은 무시합니다.
- 0 ≤ keyinput의 길이 ≤ 50
- 1 ≤ board[0] ≤ 99
- 1 ≤ board[1] ≤ 99
- keyinput은 항상 up, down, left, right만 주어집니다.
*/

class Solution_026 {
    public int[] solution(String[] keyinput, int[] board) {
        int x = 0;
        int y = 0;
        int maxX = board[0] / 2;
        int maxY = board[1] / 2;

        for (String key : keyinput) {
            if (key.equals("up")) {
                if (y + 1 <= maxY) {
                    y++;
                }
            } else if (key.equals("down")) {
                if (y - 1 >= -maxY) {
                    y--;
                }
            } else if (key.equals("left")) {
                if (x - 1 >= -maxX) {
                    x--;
                }
            } else if (key.equals("right")) {
                if (x + 1 <= maxX) {
                    x++;
                }
            }
        }

        return new int[]{x, y};
    }
}
