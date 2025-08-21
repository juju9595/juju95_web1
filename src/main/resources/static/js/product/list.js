console.log('list.js open')
let productList = [];

//[1] 모든 제품 정보 가져오기
const getlist = async() => {
    //fetch
    const respons = await fetch('/product/list');
    const data = await respons.json();
    console.log(data);
    productList = data; // 전역변수로 제품 정보 저장
}//func e

//[2] 카카오지도,(마커클러스터)
const getMap = async() =>{


    //1.지도 생성
    var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
        center : new kakao.maps.LatLng(37.4905335508 , 126.7244907601), // 지도의 중심좌표
        level : 8 // 지도의 확대 레벨
    });

    //2. 마커 클러스터러를 생성합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom 값을 true로 지정하지 않은 경우
    // 클러스터 마커를 클릭했을 때 클러스터 객체가 포함하는 마커들이 모두 잘 보이도록 지도의 레벨과 영역을 변경합니다
    // 이 예제에서는 disableClickZoom 값을 true로 설정하여 기본 클릭 동작을 막고
    // 클러스터 마커를 클릭했을 때 클릭된 클러스터 마커의 위치를 기준으로 지도를 1레벨씩 확대합니다
    var clusterer = new kakao.maps.MarkerClusterer({
        map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체
        averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정
        minLevel: 10, // 클러스터 할 최소 지도 레벨
        disableClickZoom: true // 클러스터 마커를 클릭했을 때 지도가 확대되지 않도록 설정한다
    });

    
    // 3. 전역변수에 있는 제품리스트를 마커를 생성하고 클러스터러 객체에 넘겨줍니다
    let markers = productList.map((product) => {
        //3-1 마커 생성 
         let marker = new kakao.maps.Marker({
                position : new kakao.maps.LatLng(product.plat, product.plng)
            });

    //3-2 마커 클릭 이벤트 
           // 3-2 마커 클릭 이벤트 , kakao.maps.event.addListener( marker , 'click' , ()=>{} )
        kakao.maps.event.addListener( marker , 'click' , ()=>{
            alert( `클릭한 제품명은 : ${ product.pname } ` );

            //*********** 업로드 된 이미지 출력 */
            //1. 어디에
            const productDiv = document.querySelector('#productDiv');
            //2. 무엇을 , JSP(wepapp이하) , css/js/img들을(static이하), jave/string(controller)
            let html = '';

            //* 이미지가 없는 경우 기본이미지 만들기
            if(product.images.length==0){
                html += `<img src="/upload/default.png"/>`
            }else{// * 이미지 다수일때 반복문을 이용한 여러개 img 마크업 만들기
                for(let i = 0; i < product.images.length; i++){
                    let img = product.images[i];//i번째 이미지
                    html += `<img src="/upload/${img}" />`
                }

            }
            //3. 출력
            productDiv.innerHTML = html;


        });
        // 3-3 마커를 반환 
        return marker;        
    });
    //3-2 : 반복문 끝나고 마커들을 클러스터에 넣기 
    clusterer.addMarkers(markers);//클러스터러에 마커들을 추가합니다.
  

    // 마커 클러스터러에 클릭이벤트를 등록합니다
    // 마커 클러스터러를 생성할 때 disableClickZoom을 true로 설정하지 않은 경우
    // 이벤트 헨들러로 cluster 객체가 넘어오지 않을 수도 있습니다
    kakao.maps.event.addListener(clusterer, 'clusterclick', function(cluster) {

        // 현재 지도 레벨에서 1레벨 확대한 레벨
        var level = map.getLevel()-1;

        // 지도를 클릭된 클러스터의 마커의 위치를 기준으로 확대합니다
        map.setLevel(level, {anchor: cluster.getCenter()});
    });
}//func e


//[*] 함수 동기화
const _init = async() =>{
    await getlist(); // 카카오 맵이 실행되기 전에 제품정보 가져오기 먼저 실행
    await getMap();
}
_init();


/*
//3-1 : map 반복문을 이용한 전역변수의 제품리스트 반복하기
        let markerList = []; // 여러개 마커를 저장하는 배열
        for(let i = 0; i< productList.length; i++){
            //3-2 : 제품리스트에서 i번째 제품객체 1개 반환
            const product = productList[i]; 
            //3-3 : 카카오 api 의 마커 객체 생성
            let maker = new kakao.maps.maker({position : new kakao.maps.LatLng(product.plat, product.plng)});
            //3-4 : 마커들은 저장하는 마커리스트에 .push 
            markerList.push(maker)
        }

        //3-5 : 반복문이 끝나고 마커들을 클러스터에 넣기
        clusterer.addMarkers(markerList);// 클러스터리에 마커들을 추가합니다

----------------------------------vs-----------------------------------------

    let markers = productList.map((product) => {
         return new kakao.maps.Marker({
                position : new kakao.maps.LatLng(product.plat, product.plng)
            });
    });
         clusterer.addMarkers(markers);
        
*/