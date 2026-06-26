/*
    예외처리
    - try, catch, finally, throw, Error객체

    - try : 예외가 발생할 가능성이 있는 코드 블록을 정의
    - catch : 예외가 발생했을 때 실행할 코드 블록을 정의
    - finally : 예외 발생 여부와 상관없이 항상 실행되는 코드 블록을 정의
    - throw : 예외를 발생시키는 키워드
    - Error 객체 : 예외에 대한 정보를 담고 있는 객체
*/ 

try{
    const data = JSON.parse("문자열");
    console.log(data);
} catch(e){
    console.log("예외 발생 : " + e.message);
} finally{
    console.log("예외 발생 여부와 상관없이 항상 실행");
}

// throw : 예외를 발생시키는 키워드
function divide(a, b){
    if(b === 0){
        throw new Error("0으로 나눌 수 없습니다.");
    }
    return a / b;
}

try{
    console.log(divide(10, 2));
    console.log(divide(10, 0));
} catch(e){
    console.log("예외 발생 : " + e.message);
}

