/*
문제명: 로그인 성공?
링크: https://school.programmers.co.kr/learn/courses/30/lessons/120883
요약: 입력한 아이디와 비밀번호를 회원 정보 목록과 비교해 로그인 결과를 판별하는 문제입니다. 아이디와 비밀번호가 모두 맞으면 성공, 아이디만 맞고 비밀번호가 다르면 비밀번호 오류, 아이디 자체가 없으면 실패를 반환하면 됩니다.
접근: 회원 정보를 하나씩 확인하면서 아이디가 같은 항목을 찾습니다. 같은 아이디에서 비밀번호까지 같으면 바로 "login"을 반환하고, 아이디만 같으면 "wrong pw"를 반환합니다. 끝까지 아이디가 없으면 "fail"을 반환합니다.
제한사항:
- 회원들의 아이디는 문자열입니다.
- 회원들의 아이디는 알파벳 소문자와 숫자로만 이루어져 있습니다.
- 회원들의 패스워드는 숫자로 구성된 문자열입니다.
- 회원들의 비밀번호는 같을 수 있지만 아이디는 같을 수 없습니다.
- id_pw의 길이는 2입니다.
- id_pw와 db의 원소는 [아이디, 패스워드] 형태입니다.
- 1 ≤ 아이디의 길이 ≤ 15
- 1 ≤ 비밀번호의 길이 ≤ 6
- 1 ≤ db의 길이 ≤ 10
- db의 원소의 길이는 2입니다.
*/

class Solution_030 {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] user : db) {
            if (user[0].equals(id_pw[0])) {
                if (user[1].equals(id_pw[1])) {
                    return "login";
                }
                return "wrong pw";
            }
        }
        return "fail";
    }
}
