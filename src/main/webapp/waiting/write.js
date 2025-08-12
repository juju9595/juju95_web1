console.log("write.js open");

//등록
const waitingWrite = async () => {console.log("waitingWrite exe")
    //입력받은 데이터 가져오기
    const wphone = document.querySelector('.wphone').value;
    const wcount = document.querySelector('.wcount').value;
    //입력받은 데이터를 객체화 한다.
    const obj = {'wphone' : wphone, 'wcount' : wcount};
    //fetch
    const option = {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    //fetch 실행
    const response = await fetch("/waiting", option);
    //타입변환
    const data = await response.json();
    //응답자료 확인
    if(data==true){
        alert("글쓰기 성공");
        location.href="/waiting/list.jsp"
    }else{alert("글쓰기 실패");}
}