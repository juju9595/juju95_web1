<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' href='/css/member/find.css'>

</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>

    <div id="container">
        <h3> 아이디 찾기 기능 </h3>
        이름 : <input type="text" class="nameInput" id="nameInput" placeholder="이름입력"/><br/>
        연락처 :<input type="text" class="phoneInput" id="phoneInput" placeholder="연락처입력"/><br/>
        <button type="button" onclick="findId()">아이디찾기</button>

        <h3> 비밀번호 찾기 기능 </h3>
        아이디 : <input type="text" class="idInput" id="idInput" placeholder="아이디입력"/><br/>
        연락처 :<input type="text" class="phoneInput" id="phoneInput" placeholder="연락처입력"/><br/>
        <button type="button" onclick="findPwd()">비밀번호찾기</button>
    </div>

    <script src="/js/member/find.js"></script>
</body>
</html>