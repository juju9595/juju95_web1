<%@ page language = "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>
</head>
<body>
    
    <jsp:include page="/waiting/header.jsp"></jsp:include>
    <div>
        <h3>대기 상세 페이지</h3>
            번호 : <div class ="wnoBox"></div>
            연락처 : <div class="wphoneBox"></div>
            인원 : <div class="wcountBox"></div>
            등록날짜 : <div class="wdateBox"></div>
        <button type="button" onclick="waitingDelete()">삭제</button>
        <button type="button" onclick="waitingUpdateView()">수정</button>
    </div>

    <script src="/waiting/view.js"></script>
</body>
</html>