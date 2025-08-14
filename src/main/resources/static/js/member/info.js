console.log('info.js open');

// [1] 내 정보 조회 
const onInfo = async () => {
    try{ // fetch 실행 
        const option = { method : "GET" }
        const response = await fetch( "/member/info" , option );
        const data = await response.json(); // 비로그인상태이면 null 이므로 예외/오류 발생
        // fetch 결과 : 로그인상태
        document.querySelector('.mno').innerHTML = data.mno;
        document.querySelector('.mid').innerHTML = data.mid;
        document.querySelector('.mname').innerHTML = data.mname;
        document.querySelector('.mphone').innerHTML = data.mphone;
        document.querySelector('.mdate').innerHTML = data.mdate;
    }catch(error){   console.log( error ); // 비로그인상태이면 catch 이동 
        location.href = "/member/login.jsp"; // 로그인페이지로 
    }
} // func end 
onInfo(); // 최초 1번 실행!!

// [2] 회원 탈퇴 : alert(_ : 확인 알림창, prompt() : 입력상자 알림창 , confirm : 확인/취소 알람창
    //1. 삭제 확인
const onDelete = async () => {
    let result = confirm('정말 탈퇴 할까요?');
    if(result == false){return;}//[취소] 버튼 클릭시 함수 종료;
    //2. 삭제하기 위한 기존 패스워드 확인
    let oldpwd = prompt('현재 비밀번호 입력 해주세요.');
    try{
        const option = {method : "DELETE"}
        const response = await fetch (`/member/delete?oldpwd=${oldpwd}`, option);
        const data = await response.json();
        if(data == true){
            alert('탈퇴 성공'); location.href="/index.jsp"
        }else{alert('탈퇴 실패 : 현재 비밀번호가 일치하지 않습니다.')}
    }catch(error){console.log(error);}
}