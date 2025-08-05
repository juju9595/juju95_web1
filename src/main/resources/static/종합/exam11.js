//1. 연동 확인
console.log("exam11.js")

//2. 함수 연동 확인
//일반 함수 선언 : function 함수명(){}
//람다식 함수 선언 : const 함수명 = () => {}
const boardWrite= () => {
    console.log("boardWrite() exe");
    // 3. 함수 기능 구현 - fetch
    // (1) 보낼 데이터 객체 준비 - 샘플
    let data ={"bcontent" : "JS테스트중", "bwriter" : "유재석"}
    // (2) fetch 옵션 : 3가지 (method, header, body)
    let option = {
    method : "POST",//(1) method
    headers : {"Content-Type" : "application/json"},//(2) header
    body : JSON.stringify(data)//(3) body
    }//option e
    //(3) fetch(url,option)
    //  .then(response => response.json())
    //  .then(date => {})
    //  .catch(error =>{})
    fetch("/board",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//class e

//3. 조회 함수
const boardPrint = () =>{
    console.log("boardPrint() exe");
    //(1) 보낼 데이터 - 없음
    //(2) fetch option -
    let option = {method : "GET" }
    //(3) fetch 실행
    fetch("/board", option)
    .then(response => response.json())
    .then(data =>{console.log(data)})
    .catch(error => {console.log(error)})
}

//4. 삭제 함수
const boardDelete = () =>{
    console.log("테스트 테스트");
    // (1) 보낼 데이터 준비 - 샘플
    let bno = 3; // 존재하는 bno 아무거나
    //(2) fetch option -
    let option = {method : "DELETE"}
    //(3) fetch 실행 , `백틱
    fetch(`/board?bno=${bno}`,option)
        .then(response => response.json())
        .then(data =>{console.log(data)})
        .catch(error =>{console.log(error)})
}

//5. 수정 함수
const boardUpdate = () =>{
    console.log("수정수정");
    //임의값
    let data = {"bno" : 4 , "bcontent" : "만나서반가워요!"}
    //fetch option = {method , headers, body}
    let option = {
    method : "PUT",
    headers : {"Content-Type" : "application/json"},
    body : JSON.stringify(data)
    }//option e
    fetch("/board",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//class e