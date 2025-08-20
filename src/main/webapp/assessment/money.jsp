<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
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

    <jsp:inCloude page="/assessment/header.jsp"></jsp:inCloude>
    
    <div id="container">
        <h3>회원매출조회</h3>
        <table>
            <thead border="1">
                <tr>
                    <th>회원번호</th>
                    <th>회원성명</th>
                    <th>고객등급</th>
                    <th>매출</th>
                </tr>
            </thead>
            <tbody id="moneyTbody">

            </tbody>
        </table>
    </div>
    

    <jsp:include page="/assessment/footer.jsp"></jsp:include>
    <script src="/assessment/money.js"></script>
</body>
</html>