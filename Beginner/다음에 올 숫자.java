/*
문제명: 다음에 올 숫자
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120924
요약: 정수 배열이 등차수열 또는 등비수열로 주어질 때, 마지막 원소 뒤에 이어질 다음 값을 구하는 문제입니다. 앞의 몇 항을 보고 수열 종류를 판별한 뒤 규칙에 맞는 다음 수를 반환하면 됩니다.
접근: 처음 세 항을 이용해 앞뒤 차이가 같으면 등차수열로 판단합니다. 등차수열이면 공차를 더하고, 아니면 공비를 구해 마지막 값에 곱합니다.
제한사항:
- 2 < common의 길이 < 1,000
- -1,000 < common의 원소 < 2,000
- common의 원소는 모두 정수입니다.
- 등차수열 혹은 등비수열이 아닌 경우는 없습니다.
- 등비수열인 경우 공비는 0이 아닌 정수입니다.
*/

class Solution_039 {
    public int solution(int[] common) {
        int diff1 = common[1] - common[0];
        int diff2 = common[2] - common[1];

        if (diff1 == diff2) {
            return common[common.length - 1] + diff1;
        }

        int ratio = common[1] / common[0];
        return common[common.length - 1] * ratio;
    }
}
