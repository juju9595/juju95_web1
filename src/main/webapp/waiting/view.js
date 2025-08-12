console.log('view.js opne');
const waitingFind = async() => {console.log('waitingFind exe');


    //+클릭한 wno가져오기
        //(1) 경로상의 웹주소 가져오기
    const url = new URLSearchParams(location.search);
    const wno = url.get('wno');

        //(2) 클릭한 wno를 fetch로 통신하기
    const response = await fetch(`/waiting/find?wno=${wno}`);
    const data = await response.json();
    //3.어디에
    const wnoBox = document.querySelector('.wnoBox');
    const wphoneBox = document.querySelector('.wphoneBox');
    const wcountBox = document.querySelector('.wcountBox');
    const wdateBox = document.querySelector('.wdateBox');
    //4.무엇을
    const wno1 = data.wno;
    const wphone = data.wphone;
    const wcount = data.wcount;
    const wdate = data.wdate;
    //5 출력
    wnoBox.innerHTML = wno1;
    wphoneBox.innerHTML = wphone;
    wcountBox.innerHTML = wcount;
    wdateBox.innerHTML = wdate;
}
waitingFind();

//[2] 삭제
const waitingDelete = async () => {console.log('waitingDelete exe');
    //현재 삭제할 게시물 번호 주소에서 가져오기
    const wno = new URLSearchParams(location.search).get('wno');
    //확인
    let check = confirm('정말 삭제할까요?');
    if(check == true){
        //fetch
        const option = {method:"DELETE"}
        const response = await fetch(`/waiting?wno=${wno}`,option);
        const data = await response.json();
        //
        if(data == true){alert('삭제성공');
            location.href="/waiting/list.jsp"
        }else{alert('삭제실패:없는 대기번호입니다');}
    }
}

//[3] 수정페이지로 이동
const waitingUpdateView = () => {
    const wno = new URLSearchParams(location.search).get('wno');
    location.href=`/waiting/update.jsp?wno=${wno}`;
}