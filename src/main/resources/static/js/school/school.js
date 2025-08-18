
console.log('school.js open')
//[1] 공공데이터
const dataAPI = async () =>{
    //1. 공공데이터 준비
    const serviceKey = "3uwx9wGPzX%2F%2B%2FYVOMPTQ2oiUjJHnLJzu1vBMc1XPblNR5TdAZliYLPkjkbBYOizfOY6%2Fna5vbrKYjfUuCbVflg%3D%3D"
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=10&serviceKey="
    //2. fetch 실행
    const response = await fetch( URL+serviceKey, {method : "GET"});
    const data = await response.json();
    console.log(data);
    const sidebar = document.querySelector('#sidebar');
    let html = '';
        data.data.forEach(value => {
            html +=`<div id="school">
                        <span> 학교명 ${value.학교명}</span>
                        <span> 전화번호 ${value.교무실}</span>
                        <span> 주소 ${value.주소}</span>
                    </div>`
        });
        sidebar.innerHTML = html;
}
dataAPI();



//[2] 마커 클릭 이벤트 바
const schoolMap = async () =>{
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.3839111, 126.6438556), // 지도의 중심좌표
        level : 8 // 지도의 확대 레벨
    });

    // 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 4, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    // AJAX --> fetch 변경
    const serviceKey = "3uwx9wGPzX%2F%2B%2FYVOMPTQ2oiUjJHnLJzu1vBMc1XPblNR5TdAZliYLPkjkbBYOizfOY6%2Fna5vbrKYjfUuCbVflg%3D%3D"
    const URL = "https://api.odcloud.kr/api/15039731/v1/uddi:1fcb72a0-ba75-4c97-a045-9ef7e3ef43c0?page=1&perPage=10&serviceKey="
    //2. fetch 실행
    const response = await fetch( URL+serviceKey, {method : "GET"});
    const data = await response.json();
    console.log(data);

    // map 반복문을 이용하여 마커를 하나씩 생성하여 return 한 마커를 markers 변수 배열에 대입한다.
    let markers = data.data.map((value)=>{
        // 마커 생성
        let marker =  new kakao.maps.Marker({
                position : new kakao.maps.LatLng(value.위도, value.경도)
            });

        // 마커 클릭 이벤트 넣기
         kakao.maps.event.addListener(marker, 'click', () => {
            const sidebar = document.querySelector('#sidebar');
            let html =`<div id="school">
                        <span> 학교명 ${value.학교명}</span>
                        <span> 전화번호 ${value.교무실}</span>
                        <span> 주소 ${value.주소}</span>
                    </div>`
            sidebar.innerHTML = html;
        });
        
        // 마커 생성 후 리턴(반환)
        return marker;
    });
        // 클러스터러에 마커들을 추가합니다
        clusterer.addMarkers(markers);


    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
};
schoolMap();
