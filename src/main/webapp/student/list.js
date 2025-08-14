console.log('list.js exe');

//[1] 전체조회
const memberPrint = async() => {console.log('memberPrint')
    const response = await fetch("/member");
    const data = await response.json();
    //어디에
    const memberTbody = document.querySelector('#memberTbody')

    //무엇을
    let html = '';
    for(let i = 0; i<data.length; i++){
        const member = data[i];
        html += `<tr>
                    <td>

                        ${member.custno}</td>
                     
                    <td>${member.custname}</td>
                    <td>${member.phone}</td>
                    <td>${member.address}</td>
                    <td>${member.joindate}</td>
                    <td>${member.grade}</td>
                    <td>${member.city}</td>
                </tr>`
    }
    //출력
    memberTbody.innerHTML = html;
}
memberPrint();