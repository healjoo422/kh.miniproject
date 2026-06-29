/*
문제명: 소인수분해
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120852
요약: 자연수 n을 소인수분해했을 때 등장하는 서로 다른 소수만 골라 오름차순 배열로 반환하는 문제입니다. 같은 소수가 여러 번 나와도 결과에는 한 번만 담으면 됩니다.
접근: 2부터 차례대로 나누면서 소인수인지 확인합니다. 나누어떨어지면 답에 한 번만 추가하고, 더 이상 안 나눠질 때까지 계속 나눈 뒤 다음 수로 넘어가면 됩니다.
제한사항:
- 2 ≤ n ≤ 10,000
*/

import java.util.*;

class Solution_019 {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            list.add(n);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
