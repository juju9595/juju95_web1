//1.연동확인
console.log("exam12.js")

// 등록 함수
const waitingWrite= () => {
    console.log("등록기능");
    let data = {"wphone" : "010-3857-0000" , "wcount" : "3"}
    let option = {
    method : "POST",
    headers : {"Content-Type" : "application/json"},
    body : JSON.stringify(data)}
    fetch("/waiting", option)
    .then(response => response.json())
    .then(date =>{console.log(data)})
    .catch(error => {console.log(error)})
}//class e

// 조회 함수
const waitingPrint = () => {
    console.log("조회기능");
    //보낼 데이터 없을때는 메소드만
    let option = {method : "GET"}
    fetch("/waiting", option)
    .then(response => response.json())
    .then(data =>{console.log(data)})
    .catch(error => {console.log(error)})
}//class e

// 삭제 함수
const waitingDelete = () =>{
    console.log("삭제기능");
    let wno = 5;
    let option = { method : "DELETE"}
    fetch(`/waiting?wno=${wno}`, option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}

//수정 함수
const waitingUpdate = () =>{
    console.log("수정기능");
    let data = {"wno" : "6" , "wcount" : "2"}
    let option = {
    method : "PUT",
    headers : {"Content-Type" : "application/json"},
    body : JSON.stringify(data)
    }//optione
    fetch("/waiting",option)
    .then(response => response.json())
    .then(data => {console.log(data)})
    .catch(error => {console.log(error)})
}//class e