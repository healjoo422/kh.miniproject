
// 문제 1. 1부터 100까지의 정수 중에서 "3의 배수이면서 5의 배수가 아닌 수"의 개수를 세어 출력하세요.
let count = 0;
for (let i=1; i<=100; i++){
    if(i%3 === 0 && i%5 !== 0){
        count++;
    }
}
console.log(count);


// 문제 2. 문자열을 받아 거꾸로 뒤집은 문자열을 반환하는 함수 reverseStr(str) 을 작성하세요. (배열의 reverse() 사용 금지, 반복문으로 직접 구현)
function reverseStr(str){
    let rStr = "";
    for(let i=0; i<str.length; i++){
        rStr = str[i] + rStr;
    }   
    return rStr;
}
console.log(reverseStr("hello"));


// 문제 3. 양의 정수를 받아 각 자리 숫자의 합을 반환하는 함수 digitSum(n) 을 작성하세요. (반복문과 %, 나눗셈 활용)
function digitSum(n){
    let sum = 0;
    while(n > 0){
        sum += n % 10;
        n = Math.floor(n / 10);
    }
    return sum;
}
console.log(digitSum(1234));


// 문제 4. 아래 코드의 출력을 "실행하기 전에" 예측해 주석으로 적으세요.
/*
console.log(typeof a);
var a = 5;

let x = 1;
function outer() {
  let x = 2;
  return function () { console.log(x); };
}
const fn = outer();
fn();
x = 100;
fn();
*/
/*
정답 
정의되지않음
2
2
*/


// 문제 5. 호출할 때마다 "user_1", "user_2", "user_3" … 처럼 1씩 증가하는 아이디를 반환하는 함수 makeIdGenerator() 를 클로저로 작성하세요. (내부 카운터는 외부에서 접근 불가)
function makeIdGenerator(){
    let count = 1;
    return function() {
        return `user_${count++}`;
    }
}
const nextID = makeIdGenerator();
console.log(nextID());
console.log(nextID());
console.log(nextID());


// 문제 6. 함수 fn 과 횟수 n 을 받아, fn 을 n 번 실행하는 고차함수 repeat(fn, n) 을 작성하세요. fn 에는 현재 회차(0부터)가 인자로 전달되도록 하세요.
function repeat(fn, n){
    for(let i=0; i<n; i++){
        fn(i);
    }
}

repeat((i) => console.log(i + "번째 실행"), 3);


//문제 7~9번용 데이터
const products = [
  { name: "노트북", price: 1500000 },
  { name: "마우스", price: 30000 },
  { name: "키보드", price: 90000 },
  { name: "모니터", price: 350000 },
  { name: "USB", price: 8000 },
];


// 문제 7. 가격이 100000원 이상인 상품의 name 만 모아 배열로 만들어 출력하세요. (filter + map 활용)
const result7 = products.filter(product =>
    product.price >= 100000)
    .map(product => product.name);
console.log(result7);


// 문제 8. 전체 상품 가격의 "합계"와 "평균"을 reduce 를 사용해 구해 출력하세요.
const result8_sum = products.reduce((sum, product) =>
    sum + product.price, 0);
const result8_avg = result8_sum / products.length;
console.log(result8_sum);
console.log(result8_avg);


// 문제 9. 가장 비싼 상품의 객체를 찾아 출력하세요. (Math.max 없이 reduce 또는 반복문으로)
const result9 = products.reduce((max, product)=> {
    if(product.price > max.price) {
        return product;
    } else {
        return max;
    }
}, products[0]);
console.log(result9);


// 문제 10. 아래 두 객체를 병합하되, 같은 key는 update 의 값이 우선되도록 스프레드로 새 객체 merged 를 만드세요. 그 후 구조분해로 name 과 age 만 추출해 출력하세요.
const base = { name: "최지원", age: 20, city: "안양" };
const update = { age: 21, job: "강사" };
const merged = {...base, ...update};
const {name, age} = merged;
console.log(name, age);


// 문제 11. 문자열 배열을 받아 각 요소(단어)의 등장 횟수를 객체로 집계하는 함수 countWords(arr) 를 작성하세요.
function countWords(arr){
    const wordCount = {};
    arr.forEach(word => {
        if(wordCount[word]){
            wordCount[word]++;
        } else {
            wordCount[word] = 1;
        } 
    });
    return wordCount;
}
const result11 = countWords(["a", "b", "a", "c", "a", "b"]); // {a: 3, b: 2, c: 1}
console.log(result11); 


// 문제 12. 아래 origin 객체를 JSON 문자열로 변환했다가 다시 객체 copy 로 복원하세요. 그 후 copy.skills 에 "React" 를 추가했을 때, 원본 origin.skills 가 영향을 받지 않는 것을 출력으로 확인하세요. (JSON을 이용한 깊은 복사)
const origin = { name: "최지원", skills: ["JS", "Java"] };
const jsonStr = JSON.stringify(origin);
const copy = JSON.parse(jsonStr);
copy.skills.push("React");
console.log(origin.skills);
console.log(copy.skills);


// 문제 13. 나이를 받아 검사하는 함수 checkAge(age) 를 작성하세요.
function checkAge(age){
        if(age < 0){
            throw new Error("나이는 음수일 수 없습니다.");
        }
        else if(age < 18){
            throw new Error("미성년자입니다");
        }
        else{
            return "성인입니다";
        }
}
try{
    console.log(checkAge(-5));
} catch (e) {
    console.log("예외 발생 : " + e.message);
}
try{
    console.log(checkAge(15));
} catch (e) {
    console.log("예외 발생 : " + e.message);
}
try{
    console.log(checkAge(25));
} catch (e) {
    console.log("예외 발생 : " + e.message);
}


// 문제 14. 다음을 순서대로 수행하세요.
const stdList = [
  { name: "최지원", java: 90, db: 85, front: 95 },
  { name: "김지원", java: 80, db: 80, front: 80 },
  { name: "이지원", java: 75, db: 90, front: 88 },
  { name: "박지원", java: 100, db: 95, front: 90 },
];

// 1. 각 학생 객체에 `total`(세 과목 총점) 속성을 추가한다.
stdList.forEach(std => {
    std.total = std.java + std.db + std.front;
});

// 2. 총점 기준 내림차순으로 정렬한다.
stdList.sort((a, b) => b.total - a.total);

// 3. `"1등 박지원 285점"` 형식으로 등수와 함께 전원 출력한다.
stdList.forEach((std, index) =>{
    console.log(index+1 +"등 "+ std.name +" "+ std.total +"점");
});

// 4. 전체 평균 총점을 구하고, 평균 이상인 학생의 이름만 출력한다.
const avg = stdList.reduce(((sum, std) => sum + std.total), 0) / stdList.length;
stdList.forEach(std => {
    if(std.total >= avg){
        console.log(std.name);
    }
});

//문제 15. createGradeBook() 함수를 작성하세요. 클로저를 이용해 내부에 학생 목록을 private하게 보관하고, 다음 메서드를 가진 객체를 반환합니다. (내부 학생 배열은 외부에서 직접 접근할 수 없어야 합니다.)
// addStudent(name, scores) : scores 는 { java, db, front } 형태. name 이 비어 있거나 점수가 누락되면 에러를 throw 하고, 정상이면 목록에 추가
// getRankList() : 총점 기준 내림차순으로 정렬된 [{ name, total }] 배열 반환
// getAverage() : 전체 학생의 평균 총점 반환 (목록이 비어 있으면 0)
// toJSON() : 내부 학생 목록을 JSON 문자열로 반환
function createGradeBook() {
    const students = [];

    return {
        addStudent: (name, scores) => {
            if (!name || !scores || !scores.java || !scores.db || !scores.front) {
                throw new Error("이름 또는 점수가 올바르지 않습니다.");
            }
            students.push({ name, scores });
        },
        getRankList: () => {
            const rankStd = [...students].sort((a, b) => {
                const totalA = a.scores.java + a.scores.db + a.scores.front;
                const totalB = b.scores.java + b.scores.db + b.scores.front;
                return totalB - totalA;
            });
            return rankStd.map(student => ({
                name: student.name,
                total: student.scores.java + student.scores.db + student.scores.front
            }));
        },
        getAverage: () => {
            const allSum = students.reduce((sum, student) => {
                return sum + student.scores.java + student.scores.db + student.scores.front;
            }, 0);
            return allSum / students.length;
        },
        toJSON: () => {
            return JSON.stringify(students);
        }
    };
}

const book = createGradeBook();
book.addStudent("최지원", { java: 90, db: 85, front: 95 });
book.addStudent("김지원", { java: 80, db: 80, front: 80 });
book.addStudent("박지원", { java: 100, db: 95, front: 90 });

const result15_1 = book.getRankList(); // [{ name:"박지원", total:285 }, ...] 내림차순
console.log(result15_1);

const result15_2 = book.getAverage();  // 265
console.log(result15_2);

const result15_3 = book.toJSON();      // 학생 목록 JSON 문자열
console.log(result15_3);

try{
    book.addStudent("");  // -> 에러 발생 (이름 누락)
} catch (e) {
    console.log("예외 발생 : " + e.message);
}


