/*
    배열 : 값을 순서대로 나열하는 자료구조
*/

// 배열 선언
let members = ["최지원", "김수민", "박지수"];

members.push("성삼문"); // 배열의 끝에 추가
console.log(members);

console.log(members.pop()); // 배열의 끝에서 제거
console.log(members);

members.unshift("이순신"); // 배열의 앞에 추가
console.log(members);

console.log(members.shift()); // 배열의 앞에서 제거
console.log(members);

console.log(members[0]); // 배열의 첫번째 값
console.log(members[2]); // 배열의 세번째 값

members[1] = "홍길동"; // 배열의 두번째 값 변경
console.log(members);


let arr = [1,2,3,4,5];

// 배열.splice(시작인덱스, 제거할개수, 추가할값1, 추가할값2, ...)
let spliceArr = arr.splice(1, 2); // 1번 인덱스부터 2개 제거
console.log(spliceArr); // 제거된 값 반환
console.log(arr); // 제거된 값이 반영된 배열

// slice : 배열.slice(시작인덱스, 끝인덱스) : 시작인덱스부터 끝인덱스 전까지의 값 반환
arr = [1,2,3,4,5];
let sliceArr = arr.slice(1, 3); // 1번 인덱스부터 3번 인덱스 전까지
console.log(sliceArr); // 제거된 값 반환
console.log(arr); // 원본 배열은 그대로

// 배열의 길이
console.log(arr.length); // 배열의 길이 반환

// 배열의 반복문
for(let i = 0; i < arr.length; i++){
    console.log(arr[i]);
}

// 배열의 forEach : 배열.forEach((값, 인덱스, 배열) => {})
arr.forEach((value, index, array) => {
    console.log("value : " + value, "index : " + index);
});

console.log(members);
members.reverse(); // 배열의 순서를 뒤집음
console.log(members);


members.sort(); // 배열의 값을 오름차순으로 정렬
console.log(members);

// sort의 기준전달 방법
// 배열.sort(기준함수) : 기준함수의 반환값이 0보다 작으면 a가 먼저, 0보다 크면 b가 먼저, 0이면 순서 유지
let numbers = [1, 5, 3, 2, 4];
numbers.sort((a, b) => a - b); // 작은 값이 앞으로 오도록 정렬(오름차순)
console.log(numbers);


let stdList = [
    {name: "최지원", age: 20},
    {name: "김수민", age: 25},
    {name: "박지수", age: 22}
];

stdList.sort((a, b) => a.age - b.age); // 나이순으로 오름차순 정렬
console.log(stdList);