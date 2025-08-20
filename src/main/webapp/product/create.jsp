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

     <jsp:include page="/header.jsp"></jsp:include>

     <div id="container">
        <h3> 제품등록 </h3>
        <form id="productForm">
            제품명 : <input name="pname"/> <br/>
            제품가격 : <input name="pprice"/> <br/>
            제품설명 : <textarea name="pcomment"></textarea> <br/>
            제품이미지 : <input type="file" multiple name="uploads"/> <br/>
        
            판매위치(카카오지도API)
        <div id="map" style="width:100%;height:350px;"></div>
        <p><em>지도를 클릭해주세요!</em></p> 
        <div id="clickLatlng"></div>
    

        <button type="button" onclick="onCreate()"> 제품 등록 </button>
        </form>
    </div>

    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=9b34dee7a8e92b455b69ea54a454404b"></script>
    <script src="/js/product/product.js"></script>
    
</body>
</html>