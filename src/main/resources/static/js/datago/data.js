
console.log("data.js exe")

// [2] 사업자등록정보 상태조회 서비스
const dataAPI2 = async () =>{
    //1. 데이터 준비
    const b_no = document.querySelector('.b_no').value;
    const obj = {
        "b_no" : [b_no] // - 없는 사없자번호, 더조은학원으로 테스트
    } //var : 중복가능한 변수 타입, 과거 많이 사용됨, 최근에는 let 키워드가 사용됨.
    //2.fecth
    const option = {
        method : "POST", headers : {"Content-Type" : "application/json"} , body:JSON.stringify(obj)
    }
    const serviceKey = "3uwx9wGPzX%2F%2B%2FYVOMPTQ2oiUjJHnLJzu1vBMc1XPblNR5TdAZliYLPkjkbBYOizfOY6%2Fna5vbrKYjfUuCbVflg%3D%3D"
    const URL = "https://api.odcloud.kr/api/nts-businessman/v1/status?serviceKey="
    const response = await fetch( URL+serviceKey, option);
    const data = await response.json();
    alert(data.data[0]["tax_type"]) // 속성명이 특수문자가 포함된 경우 
} //

//[1] 인천 부평구 주유소 현황
const dataAPI1 = async() =>{ 
    
    //(1) 요청 URL , perPage=10 -> perPage=38 변경
    const serviceKey = "3uwx9wGPzX%2F%2B%2FYVOMPTQ2oiUjJHnLJzu1vBMc1XPblNR5TdAZliYLPkjkbBYOizfOY6%2Fna5vbrKYjfUuCbVflg%3D%3D"
    const URL = "https://api.odcloud.kr/api/15102672/v1/uddi:d26dabc4-e094-463d-a4b1-cab3af66bb6d?page=1&perPage=38&serviceKey="
    //(2) fetch 활용한 공공데이터 API 요청
    const option = { method : "GET"}
    const response = await fetch(URL+serviceKey, option);
    const data = await response.json();
    console.log(data); // 요청 결과값을 CONSOLE **출력후 분석**하여 사용한다.
    // perPage : 페이지당 가져올 데이터수, data: 실질적인 데이터가 들어오는 속성명 (주유소 목록)
    // data : 실질적인 데이터가 들어오는 속성명
    console.log(data.data);
    // (3) JSP(html) 표에 출력하기
        //1. 어디에
        const dataTbody = document.querySelector('#dataTbody');
        //2. 무엇을 array/forEach( (value) => {}) : 리스트내 요소를 하나씩 변수(value)에 반복대입
        let html = '';
        data.data.forEach((value)=> {
            html += `<tr>
                        <td> ${value.연번}</td>
                        <td> ${value.상호}</td>
                        <td> ${value.업종}</td>
                        <td> ${value.전화번호}</td>
                        <td> ${value['주소']}</td>
                </tr>`
            
        });
        //3. 출력
        dataTbody.innerHTML = html;
}//func e
dataAPI1(); // JSP 열릴때 최초 1번 실행