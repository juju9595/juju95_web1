HRDKOREA Copyrightⓒ2016 All rights reserved. Human Resources Development Service Of Korea.
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
</head>
<body>
    
    <jsp:inCloud page="/assessment/header.jsp"></jsp:inCloud>

    <div id="container">
        <h2> 홈쇼핑 회원 등록 </h2>
        회원번호(자동발생) : <input type="text" class="custnoInput" id="custnoInput"/><br/>
        회원성명 : <input type="text" class="custnameInput" id="custnameInput"/><br/>
        회원주소 : <input type="text" class="phoneInput" id="phoneInput"/><br/>
        가입일자 : <input type="text" class="addressInput" id="addressInput"/><br/>
        고객등급[A:VIP,B:일반,C:직원] : <input type="text" class="gradeInput" id="gradeInput"/><br/>
        도시코드 : <input type="text" class="cityInput" id="cityInput"/><br/>
        <button type="button" onclick="addMember()">등록</button>
        <button type="button" onclick="memberInfo()">조회</button>
    </div>
    
    <jsp:inCloud page="/assessment/footer.jsp"></jsp:inCloud>
    <script src="/assessment/add.js"></script>
</body>
</html>