console.log('update.js exe');

//[1] 개별 조회(수정하기 전 내용을 확인)
const waitingFind = async () => {console.log('find exe')
    //1. 현재 게시물 번호 가져오기
    const wno = new URLSearchParams(location.search).get('wno');
    // fetch 이용한 wno의 게시물 정보 요청
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    //현재 게시물의 수정하기 전 내용 출력
    document.querySelector('.wphone').innerHTML = data.wphone;
    document.querySelector('.wcount').innerHTML = data.wcount;
}
waitingFind();

//[2] 개별 수정
const waitingUpdate = async () => {console.log("waitingUpdate exe")
    //현재 수정할 게시물 번호 가져오기
    const wno = new URLSearchParams(location.search).get('wno');
    //수정할 입력받은 값 가져오기
    const wphone = document.querySelector('.wphone').value;
    const wcount = document.querySelector('.wcount').value;
    //객체화
    const obj = {"wno" :wno, "wphone" : wphone, "wcount" : wcount};
    //fetch 옵션
    const option = {
        method :"PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    }
    //fetch 실행
    const response = await fetch("/waiting", option);
    const data = await response.json();
    //fetch 결과
    if(data == true){
        alert('수정 성공');
        location.href =`/waiting/view.jsp?wno=${wno}`
    }else{alert('수정실패');}
}