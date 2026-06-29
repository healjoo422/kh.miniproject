/*
문제명: 치킨 쿠폰
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120884
요약: 주문한 치킨 수로 시작해 쿠폰 10장마다 서비스 치킨 1마리를 받고, 서비스 치킨에서도 다시 쿠폰이 생길 때 최대로 받을 수 있는 서비스 치킨 수를 구하는 문제입니다. 쿠폰이 더 이상 교환되지 않을 때까지 반복해서 계산하면 됩니다.
접근: 현재 쿠폰 수가 10장 이상인 동안 계속 서비스 치킨을 받습니다. 매번 쿠폰을 10으로 나눈 몫만큼 서비스 치킨을 더하고, 남은 쿠폰과 새로 생긴 쿠폰을 합쳐 다음 계산에 사용합니다.
제한사항:
- chicken은 정수입니다.
- 0 ≤ chicken ≤ 1,000,000
*/

class Solution_033 {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;

        while (coupon >= 10) {
            int service = coupon / 10;
            answer += service;
            coupon = (coupon % 10) + service;
        }

        return answer;
    }
}
