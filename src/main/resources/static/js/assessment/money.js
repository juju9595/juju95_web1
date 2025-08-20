console.log('money.js open')

const moneyInfo = async() =>{
    console.log('moneyInfo func exe');
    const option = { method : "GET"};
    const response = await fetch("/money", option);
    const data = await response.json();
    const moneyTbody = document.querySelector('#moneyTbody');

    let html = "";
    data.forEach((money)=>{
        let grade = money.grade;
        if(grade == 'A'){
            grade = 'VIP'
        }else if(grade == 'B'){
            grade = '일반'
        }else if(grade == 'C'){
            grade = '직원'
        }

        html += `<tr>
                    <td>${money.custno}</td>
                    <td>${money.custname}</td>
                    <td>${grade}</td>
                    <td>${money.totalPrice}</td>
                </tr>`
    });
    moneyTbody.innerHTML = html;
}
moneyInfo();