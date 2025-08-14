console.log('write.js exe');

//등록
const memberWrite = async () => {console.log('memberWrite exe');
    const custno = new URLSearchParams(location.search).get('custno');
    const response = await fetch(`/member/custno=${custno}`);
    const data = await response.json();
    document.querySelector('.custno').innerHTML = data.custno;
    document.querySelector('.joindate').innerHTML = data.joindate;
}
memberWrite();