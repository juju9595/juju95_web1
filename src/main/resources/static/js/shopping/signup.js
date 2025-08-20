console.log('signup.js open')

//[1] 회원가입 처리
const signup = async() =>{
    const custnameInput = document.querySelector('.custnameInput')
    const phoneInput = document.querySelector('.phoneInput')
    const addressInput = document.querySelector('.addressInput')
    const gardeInput = document.querySelector('.gardeInput')
    const cityInput = document.querySelector('.cityInput')

    const custname = custnameInput.value;
    const phone = phoneInput.value;
    const address = addressInput.value;
    const garde = gardeInput.value;
    const city = cityInput.value;

    const obj = {custname, phone, address, garde, city};

    try{
        const option = {
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch("/shopping/signup", option);
        const data = await response.json();
        if(data > 0){alert('회원등록이 완료 되었습니다.'); location.href="/shopping/header.jsp"}
        else{alert('회원등록에 실패하였습니다.')}
        }catch(error){console.log(error);}
    }
    
