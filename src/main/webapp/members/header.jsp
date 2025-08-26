<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>

</head>
<body>

    <div id="header">
        <h2> 쇼핑몰 회원관리 ver 1.0 </h2>
        <ul>
            <li><a href="/members/add.jsp">회원등록</a></li>
            <li><a href="/members/view.jsp">회원목록조회/수정</a></li>
            <li><a href="/members/money.jsp">회원매출조회</a></li>
            <li><a href="/members/index.jsp">홈으로</a></li>
        </ul>
    </div>
    
    <jsp:include page="/members/footer.jsp"></jsp:include>
</body>
</html>