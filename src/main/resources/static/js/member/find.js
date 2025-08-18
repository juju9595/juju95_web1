
console.log('find.js open')

//[1] 아이디 찾기 

const findId = async()=>{
    const mname = document.querySelector('.idName').value;
    const mphone = document.querySelector('.pwdPhone').value;
    const obj = {mname, mphone};
    try{const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch("/member/find", option);
        const data = await response.json();
        if(data == true)
        {findId.innerHTML = `${mid}`+"입니다"}else{alert('회원정보 없음')}
    }catch{}
}

//[2] 비밀번호 찾기