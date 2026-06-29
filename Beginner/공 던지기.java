/*
문제명: 공 던지기
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120843
요약: 원형으로 서 있는 친구들이 공을 던질 때, 한 사람을 건너뛰며 다음 사람에게만 전달합니다. 주어진 k번째 차례에 공을 던지는 사람의 번호를 구하는 문제입니다.
접근: 공을 던질 때마다 배열에서 인덱스가 2씩 이동한다고 보면 됩니다. 첫 번째 던지는 사람은 0번 인덱스이므로, (k-1)번 이동한 위치를 배열 길이로 나눈 나머지로 계산하면 됩니다.
제한사항:
- 2 < numbers의 길이 < 100
- 0 < k < 1,000
- numbers의 첫 번째와 마지막 번호는 실제로 바로 옆에 있습니다.
- numbers는 1부터 시작하며 번호는 순서대로 올라갑니다.
*/

class Solution_021 {
    public int solution(int[] numbers, int k) {
        int index = ((k - 1) * 2) % numbers.length;
        return numbers[index];
    }
}
