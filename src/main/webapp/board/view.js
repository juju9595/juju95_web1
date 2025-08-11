console.log('view.js open');
const boardFind = async() => {console.log('boardFind exe');

    //1. 주소장(URL) 경로상의 쿼리스트링 가져오기
    //+ 클릭한 bno가져오기
        //(1) 경로상의 웹주소 가져오기
    const url = new URLSearchParams(location.search);
        //(2) 웹주소에서 쿼리스트링 값 가져오기
        const bno = url.get('bno');

        //2. 클릭한 bno를 fetch로 통신하기
        const response = await fetch(`/board/find?bno=${bno}`);
        const data = await response.json();
        //3. 어디에 
        const bcontentBox = document.querySelector('.bcontentBox');
        const bwriterBox = document.querySelector('.bwriterBox');
        //4. 무엇을
        const bcontent = data.bcontent;
        const bwriter = data.bwriter;
        //5. 출력
        bcontentBox.innerHTML = bcontent;
        bwriterBox.innerHTML = bwriter;
}
boardFind();

//[2] 삭제
const boardDelete = async () => {console.log('boardDelete exe');
    //1. 현재 삭제할 게시물 번호 주소에서 가져오기
    const bno = new URLSearchParams(location.search).get('bno');
    //2. 확인 
    let check = confirm('정말 삭제할까요?');
    if(check == true){
        // 3. fetch
        const option = {method : "DELETE"}
        const response = await fetch(`/board?bno=${bno}`, option);
        const data = await response.json();
        //4.
        if( data == true){alert('삭제성공');
            location.href="/board/list.jsp"
        }else{alert('삭제실패:존재하지 않는 게시물');}
    }
}

//[3] 수정페이지로 이동
const boardUpdateView =() =>{
    const bno = new URLSearchParams(location.search).get('bno');
    location.href=`/board/update.jsp?bno=${bno}`;
}