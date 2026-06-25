
/*
    객체 : 중괄호 안에 key와 value를 쌍으로 넣어 만든 데이터 타입
    - key : 문자열
    - value : 모든 자료형 가능  
*/

const product = {
    pName: "김밥",
    price: 3000,
    kind: "한식",
    ingredients: ["밥", "김", "단무지", "햄"],
    // 객체의 메서드 : 객체 안에 정의된 함수
    printInfo: function(){
        console.log(this.pName + " : " + this.price + "원");
    }
};
product.printInfo(); // 객체의 메서드 호출

// 객체의 속성 접근
console.log(product.pName);
console.log(product["price"]); // key를 문자열로 접근 가능

//유연하게 key: value 추가 가능
product.isSoldOut = false;
console.log(product);