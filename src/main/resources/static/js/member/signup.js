
console.log('signup.js open')

//*** 유효성검사 체크리스트 ***
const signPass = [false, false]; // 초기값은 실패, 0인텍스:아이디체크, 1인덱스 : 연락처체크

//[1] 회원가입 처리
const signup = async() =>{

    // 만약에 유효성검사 체크리스트에 false 가 존재하면 회원가입 진행 불가능.
    // JS배열에 요소찾기 함수 : 1. .indexOf() 2. .includes()
    if(signPass.includes(false)){alert('올바른 정보를 입력 후 가능합니다.')
        return;
    }
    //1. 마크업의 DOM객체 가져오기
    const idInput = document.querySelector('.idInput');
    const pwdInput = document.querySelector('.pwdInput');
    const nameInput = document.querySelector('.nameInput');
    const phoneInput = document.querySelector('.phoneInput');

    //2. DOM객체에서 입력받은 값 가져오기
    const mid = idInput.value;
    const mpwd = pwdInput.value;
    const mname = nameInput.value;
    const mphone = phoneInput.value;
    //3.객체화
    const obj = {mid, mpwd, mname, mphone};
    //4/ fetch 실행
    try{
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/signup" , option );
        const data = await response.json();
        //5. fetch 결과
        if(data > 0){alert('회원가입 성공'); location.href="/member/login.jsp"}
        else{alert('회원가입 실패');}
    }catch(error){console.log(error);}
}//func e

//<마크업> 이벤트 : onClick(해당 마크업을 클릭했을때), onkeyup(해당 마크업에 키를 떼었을때)



//[2] 아이디중복검사 : 입력할때마다 발동
const idcheck = async () =>{
    //1. //2.
    const mid = document.querySelector('.idInput').value;
    const idCheck = document.querySelector('.idCheck');
    //2. 유효성검사
    if(mid.length < 6){// 만약에 아이디가 6글자 미만이면 
        idCheck.innerHTML = "아이디는 6글자 이상으로 가능합니다."
        signPass[0] = false;
        return; // 함수 강제 종료 함으로써 아래 코드는 실행 안됨.
    }
    //2. 유효성검사2 중복검사 , /member/check?type=검사할속성명&data=${검사할데이터}
    //3.fetch 실행
    const option = { method : "GET"}
    const response = await fetch( `/member/check?type=mid&data=${mid}`, option );
    const data = await response.json();
    //4. fetch 결과
    if(data == true){
        idCheck.innerHTML = "사용중인 아이디 입니다."
        signPass[0] = false;
    }else{
    idCheck.innerHTML = "사용가능한 아이디 입니다."
    signPass[0] = true;
    }
}

//[3] 연락처중복검사 : 입력할때마다 발동
const phoneCheck = async () =>{
    //1. //2.
    const mphone = document.querySelector('.phoneInput').value; //1. 입력받은 연락처 가져오기
    const phoneCheck = document.querySelector('.phoneCheck');   //2. 결과 메세지를 출력할 dom객체 가져오기
    //2. 유효성 검사
    if(mphone.length != 13){ //3. 만약에 입력받은 연락처가 13글자가 아니면
        phoneCheck.innerHTML = "-(하이픈) 포함한 13글자 연락처를 입력해주세요." //메세지 출력
        signPass[1] = false;
        return; //함수 종료
    }
    //2. 유효성검사2 중복검사
    try{//fetch 실행
        const option = {method : "GET"}
        const response = await fetch(`/member/check?type=mphone&data=${mphone}`, option);
        const data = await response.json();
        //3.
        if(data == true)//fetch 실행 결과
            {phoneCheck.innerHTML = "사용중인 연락처 입니다.";
            signPass[1] = false;
        }else{phoneCheck.innerHTML = "사용가능한 연락처 입니다.";
            signPass[1] = true;
        }
    }catch(error){console.log(error)
    
    }
}//func e

