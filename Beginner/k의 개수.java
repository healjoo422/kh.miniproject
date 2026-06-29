/*
문제명: k의 개수
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120887
요약: 정수 i부터 j까지의 모든 수를 살펴보며, 각 숫자 안에 특정 숫자 k가 몇 번 나타나는지 합산하는 문제입니다. 범위 내 모든 수의 자릿수를 확인해 총 등장 횟수를 구하면 됩니다.
접근: i부터 j까지 하나씩 반복합니다. 각 수를 10으로 나누며 마지막 자릿수를 확인해 k와 같으면 개수를 증가시킵니다. 모든 수에 대해 이를 누적해 반환합니다.
제한사항:
- 1 ≤ i < j ≤ 100,000
- 0 ≤ k ≤ 9
*/

class Solution_008 {
    public int solution(int i, int j, int k) {
        int count = 0;

        for (int num = i; num <= j; num++) {
            int temp = num;
            while (temp > 0) {
                if (temp % 10 == k) {
                    count++;
                }
                temp /= 10;
            }
        }

        return count;
    }
}
