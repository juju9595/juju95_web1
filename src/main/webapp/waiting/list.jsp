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
    <!--헤더.jsp 불러오기-->
    <jsp:include page="/waiting/header/jsp"></jsp:include>
    <div>
        <h3>대기현황 전체 조회</h3>
        <a href="/waiting/write.jsp">등록</a>
        <table border="1">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>연락처</th>
                    <th>인원</th>
                    <th>등록날짜</th>
                </tr>
            </thead>
            <tbody id="waitingTbody">

            </tbody>
        </table>
    </div>

    <script src ="/waiting/list.js"></script>
</body>
</html>