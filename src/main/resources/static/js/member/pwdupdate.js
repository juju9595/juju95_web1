console.log('pwdupdate.js open')

//[1] 패스워드 수정
const onPwdUpdate = async() =>{
    try{
        const option = { 
            method : "POST",
            headers : { "Content-Type" : "application/json"},
            body : JSON.stringify( obj )
        }
        const response = await fetch( "/member/update/password" , option );
        const data = await response.json();
    }catch{

    }
}