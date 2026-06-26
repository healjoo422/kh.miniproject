/*
    JSON(JavaScript Object Notation)
    - 데이터를 주고받는 텍스트형식 중 하나
    - JavaScript 객체와 유사한 구조를 가짐
    - key는 반드시 문자열, value는 문자열, 숫자, 배열, 객체, true, false, null 가능
    - 서버통신 or 로컬데이터 저장 시 사용
    - JSON.parse() : JSON 문자열 -> JS 객체
    - JSON.stringify() : JS 객체 -> JSON 문자열
*/

const user = {
    name: "최지원",
    age: 25,
    skill: ["JavaScript", "HTML", "CSS"],
}

 // 객체를 JSON 문자열로 변환 (객체 메서드는 제외됨)
const jsonString = JSON.stringify(user, null, 2); // 들여쓰기 2칸
console.log(jsonString);

// JSON 문자열을 객체로 변환
const parsedUser = JSON.parse(jsonString);
console.log(parsedUser);

