package web.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService; // @RequiredArgsConstructor 사용함으로 @Autowired 생략 한다.

    // [1] 게시물등록
    @PostMapping("")
    // method : post , url : localhost:8080/post , body : { "ptitle" : "게시물제목테스트" , "pcontent" : "게시물제목테스트" , "cno" : "1"  }
    public int writePost(@RequestBody PostDto postDto, HttpSession session) {
        // 1. 현재 로그인 상태 확인
        Object login = session.getAttribute("loginMno");
        // 2. 비로그인이면 등록 실패처리
        if (login == null) return 0;
        // 3. 로그인이면 현재 로그인한 회원번호를 postDto 대입하기
        int mno = (int) login;
        postDto.setMno(mno);
        // 4. 서비스 호출 하고 응답 반환 하기
        return postService.writePost(postDto);
    } // func end

    // [2] 게시물 전체 조회
    @GetMapping("") // method : GET   , URL : localhost:8080/post?cno=1&page=1&count=5 , 1번카테고리(뉴스)의 1페이지의 5개 게시물
    public PageDto findAllPost(@RequestParam(defaultValue = "1") int cno,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "5") int count,
                               @RequestParam(required = false) String key,
                               @RequestParam(required = false) String keyword) {
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 없으면 defaultValue 속성으로 기본값 대입 할 수 있다.
        return postService.findAllPost(cno, page, count, key, keyword);
    }

    //[3] 게시물 개별 조회
    @GetMapping("/view")
    public PostDto getPost(@RequestParam int pno, HttpSession session ){
        //HttpSession : 브라우저의 마다 별도의 (클라이언트)저장소 개념
            //1. 세션 속성내 'viewHistory'(클라이언트가 조회한 게시물정보) 값 가져오기
        Object object = session.getAttribute("viewHistory");

        Map<Integer,String> viewHistory;

        if(object == null){//2. 만약에 'viewHistory' 가 존재하지 않으면
            viewHistory = new HashMap<>();
        }else { //3. 존재하면 기존 자료를 타입변환 한다.
            viewHistory = (Map<Integer, String >)object;
        }

        //4. 오늘 날짜를 문자열로 가져옴 , LocalDate.now() : 현재 시스템 날짜 반환함수
        String today = LocalDate.now().toString();
        //5. 현재 게시물(pno)을 오늘 (today) 조합하여 본 기록을 체크한다.
        String check = viewHistory.get(pno);
        if(check == null || !check.equals(today)) {//만약에 현재 게시물의 오늘날짜가 없거나 오늘날짜가 일치하지 않으면}
            postService.incrementView(pno);       //6. 조회수 증가 서비스 호출
            //7. 세션에 조회수 기록/저장
            viewHistory.put(pno, today);
            //8. 세션 속성 업데이트
            session.setAttribute("viewHistory", viewHistory);
        }

        //2. 요청한 사람(클라이언트)이 본인인 작성한 글인지 확인
        PostDto postDto = postService.getPost(pno);

        // 로그인 세션 확인
        Object loginObject = session.getAttribute("loginMno");
        // 만약에 로그인정보가 없으면 0 있으면 타입변환
        int loginMno = loginObject == null ? 0 : (int) loginObject;
        //만약에 조회한 게시물의 작성자 회원번호가 로그인회원번호 와 같으면 host 속성을 true 설정
        if(postDto.getMno() == loginMno){postDto.setHost(true);}

        return postDto;
    }//func e

    //[4] 게시물 삭제
    @DeleteMapping("")
    public boolean deletePost(@RequestParam int pno){
     return postService.deletePost(pno);
    }

    //[5] 게시물 수정
    @PutMapping("")
    public int updatePost(@RequestBody PostDto postDto ){
        return postService.updatePost(postDto);
    }
}//class e
