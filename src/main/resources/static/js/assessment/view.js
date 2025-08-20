console.log('view.js open')

const memberPrint = async() =>{
    console.log('memberPrint func exe')
    const option = {method:"GET"};
    const response = await fetch("/members", option);
    const data = await response.json();

    const memberTbody = document.querySelector('#memberTbody');

    let html = "";
    data.forEach((member)=>{
        let grade = member.grade;
        if(grade == 'A'){
            grade = 'VIP'
        }else if(grade == 'B'){
            grade = '일반'
        }else if(grade == 'C'){
            grade = '직원'
        }

        html += `<tr>
                    <td><a href="/assessment/update.jsp?custno=${member.custno}">${member.custno}</a></td>
                    <td>${member.custname}</td>
                    <td>${member.phone}</td>
                    <td>${member.address}</td>
                    <td>${member.joindate}</td>
                    <td>${grade}</td>
                    <td>${member.city}</td>
                </tr>`
    });
    memberTbody.innerHTML = html;
}
memberPrint();
