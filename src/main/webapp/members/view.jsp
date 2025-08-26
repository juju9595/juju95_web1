<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
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
    
    <jsp:inCloude page="/members/header.jsp"></jsp:inCloude>

    <div id="container">
        <h3> 회원목록조회/수정</h3>
        <table border="1">
            <tr>
                <th>회원번호</th>
                <th>회원성명</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>가입일자</th>
                <th>고객등급</th>
                <th>거주지역</th>
            </tr>
        </table>
        <tbody id="memberTbody">
        </tbody>
    </div>

    <jsp:include page="/members/footer.jsp"></jsp:include>
    <script src="/js/members/view.js"></script>

</body>
</html>