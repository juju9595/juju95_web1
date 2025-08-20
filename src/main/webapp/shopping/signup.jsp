<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    
</head>
<body>

    <jsp:include page="/shopping/header.jsp"></jsp:include>

    <div id="container">
        <h3> 홈쇼핑 회원 등록</h3>
        회원번호(자동발생) <input type="text" class="custnoInput" id="custnoInput"/><br/>
        회원성명 <input type="text" onkeyup="namecheck()" class="custnameInput" id="custnameInput"/><br/>
        회원전화 <input type="text" class="phoneInput" id="phoneInput"/><br/>
        회원주소 <input type="text" class="addressInput" id="addressInput"/><br/>
        가입일자 <input type="text" class="joindateInput" id="joindateInput"/><br/>
        고객등급[A:VIP,B:일반,C.직원] <input type="text" class="gardeInput" id="gardeInput"/><br/>
        도시코드 <input type="text" class="cityInput" id="cityInput"/><br/>
        <button type="button" onclick="signup()">등록</button>
        <button type="button" onclick="">조회</button>
    </div>
    <script src="/js/shopping/signup.js"></script>
</body>
</html>