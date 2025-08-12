console.log('대기현황 리스트')

//[1] 전체조회
const waitingPrint = async () => {console.log('waitingPrint');
    const response = await fetch("/waiting");
    const data = await response.json();
    //어디에
    const waitingTbody = document.querySelector('#waitingTbody')

    //무엇을
    let html = '';
    for(let i = 0; i<data.length; i++){
        const waiting = data[i];
        html += `<tr>
                    <td> 
                        <a href="/waiting/view.jsp?wno=${waiting.wno}">
                        ${waiting.wno}</td>
                        </a>
                    <td>
                        ${waiting.wphone}
                    </td>
                    <td> ${waiting.wcount}</td>
                    <td> ${waiting.wdate}</td>
                </tr>`
    }
    //출력
    waitingTbody.innerHTML =html;
}
waitingPrint();