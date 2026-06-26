// 배열의 고차함수
// 고차함수 : 다른 함수를 인자로 받거나, 함수를 반환하는 함수
// 대체적으로 원본을 변경하지 않고 새로운 배열을 반환하는 경우가 많음

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

// 1) forEach: 각 요소 순회
console.log("[forEach] 각 요소 출력");
numbers.forEach((num, idx) => {
	console.log(`${idx}: ${num}`);
});

// 2) map: 각 요소를 변환한 새 배열 생성
const squared = numbers.map((num) => num * num);
console.log("\n[map] 제곱 배열:", squared);

// 3) filter: 조건에 맞는 요소만 추출
const evenNumbers = numbers.filter((num) => num % 2 === 0);
console.log("\n[filter] 짝수 배열:", evenNumbers);

// 4) reduce: 누적 계산
// 배열.reduce((누적값, 현재값) => 누적값 + 현재값, 초기값)
const sum = numbers.reduce((acc, cur) => acc + cur, 0);
console.log("\n[reduce] 합계:", sum);

// 5) find: 조건에 맞는 첫 번째 요소 찾기
const firstOverSeven = numbers.find((num) => num > 7);
console.log("\n[find] 7보다 큰 첫 번째 값:", firstOverSeven);

// 6) some: 하나라도 조건을 만족하는지 확인
const hasMultipleOf7 = numbers.some((num) => num % 7 === 0);
console.log("\n[some] 7의 배수가 있는가?:", hasMultipleOf7);

// 7) every: 모두 조건을 만족하는지 확인
const allPositive = numbers.every((num) => num > 0);
console.log("\n[every] 모두 양수인가?:", allPositive);

// 8) sort: 정렬 (원본 배열 변경 주의)
// 스프레드 : [...객체]를 이용해 원본을 유지하면서 얕은복사로 새로운 객체를 생성하는데 사용할 수 있다
const shuffled = [5, 2, 9, 1, 7];
const asc = [...shuffled].sort((a, b) => a - b);
const desc = [...shuffled].sort((a, b) => b - a);
console.log("\n[sort] 오름차순:", asc);
console.log("[sort] 내림차순:", desc);

// 9) 실습형 예제: 학생 점수 처리
const students = [
	{ name: "민수", score: 82 },
	{ name: "지연", score: 95 },
	{ name: "현우", score: 67 },
	{ name: "수빈", score: 88 },
];

const passed = students.filter((s) => s.score >= 80).map((s) => s.name);
const average = students.reduce((acc, s) => acc + s.score, 0) / students.length;

console.log("\n[실습] 80점 이상 학생:", passed);
console.log("[실습] 평균 점수:", average.toFixed(2));


// 스프레드 활용법
let user1 = {
    id: "user1",
    pwd: "1234",
    age: 20,
};
// user.pwd = "5678";
user1 = {...user1, pwd: "5678"}; // user1 객체를 복사하면서 pwd만 변경

