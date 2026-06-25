
const list = ["최지원", "김수민", "박지수"];

// 배열의 각 요소를 변수로 만들어서 사용
const [first, second, third] = list;
console.log(first); // "최지원"
console.log(second); // "김수민"
console.log(third); // "박지수"

// 일부 건너뛰기
const [first2, , third2] = list;
console.log(first2); // "최지원"
console.log(third2); // "박지수"

// 일부만 가져오고 나머지는 합치기
const [first3, ...rest] = list;
console.log(first3); // "최지원"
console.log(rest); // ["김수민", "박지수"]



// 객체 구조분해 (key 기반)
const person = {
    name: "최지원",
    age: 25,
    height: 180.5
};
const {name, height } = person;
console.log(name); // "최지원"
console.log(height); // 180.5

// key 가 없을 경우 기본값 설정
const {weight = 70} = person;
console.log(weight); // 70

//