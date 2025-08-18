<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="/css/header.css" rel="stylesheet">
</head>
<body>
    
    <jsp:include page="/header.jsp"></jsp:include>
    <div id="container">

        <!-- KAKAO 지도가 출력되는 DIV -->
        <div id="map" style="width:500px;height:400px;"></div>
    </div>
        
<!-- KAKAO 지도 API JS : 개발자정의 JS보다 먼저 호출 권장 -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b34dee7a8e92b455b69ea54a454404b"></script>
<!-- 개발자정의 JS -->    
<script src="/js/kakao/map.js"></script>
</body>
</html>