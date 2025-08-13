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
    <jsp:include page = "/member/header/jsp"></jsp:include>
    <div>
        <h3>홈쇼핑 회원 등록</h3>
        회원번호(자동발생) : <textarea class="custno" readonly></textarea><br/>
        회원성명 : <textarea class="custname"></textarea><br/>
        회원전화 : <textarea class="phone"></textarea><br/>
        회원주소 : <textarea class="address"></textarea><br/>
        가입일자 : <textarea class="joindate" readonly></textarea><br/>
        고객등급[A:VIP,B:일반,C:직원] : <textarea class="grade"></textarea><br/>
        도시코드 : <textarea class="city"></textarea><br/>
        <button type="button" onclick="memberWrite()">등록</button>
        <button type="button" onclick="memberPrint()">조회</button>
    </div>
    <script src="/member/write.js"></script>
</body>
</html>