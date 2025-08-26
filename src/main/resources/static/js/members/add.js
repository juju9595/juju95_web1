console.log('add.js open');

const memberWrite = async() => {
    const custnoInput = document.querySelector('.custnoInput');
    const custnameInput = document.querySelector('.custnameInput');
    const phoneInput = document.querySelector('.phoneInput');
    const addressInput = document.querySelector('.addressInput');
    const gradeInput = document.querySelector('.gradeInput');
    const cityInput = document.querySelector('.cityInput');

    const custno = custnoInput.value;
    const custname = custnameInput.value;
    const phone = phoneInput.value;
    const address = addressInput.value;
    const grade = gradeInput.value;
    const city = cityInput.value;

    const obj = {custno,custname,phone,address,grade,city};

        const option = {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(option)
        }//option e
        const response = await fetch("/members", option)
        const data = await response.json();

         if ( data == 0 ){
        alert('등록 성공'); location.href ="/assessment/view.jsp"
        } else if ( data == 1 ){
            alert('등록 실패')
        } else if ( data == 2 ){
            alert('회원성명이 입력되지 않았습니다.')
        } else if ( data == 3 ){
            alert('회원전화가 입력되지 않았습니다.')
        } else if ( data == 4 ){
            alert('회원주소가 입력되지 않았습니다.')
        } else if ( data == 5 ){
            alert('가입일자가 입력되지 않았습니다.')
        } else if ( data == 6 ){
            alert('고객등급이 입력되지 않았습니다.')
        } else if ( data == 7 ){
            alert('도시코드가 입력되지 않았습니다.')
        } else if ( data == 8 ){
            alert('회원번호가 입력되지 않았습니다.')
        } // if end
    }

 


