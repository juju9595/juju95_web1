package web.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.model.dto.MemberDto;
import web.service.MemberService;

import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    //회원가입 구현
    @PostMapping("/signup")
    public int signUp(@RequestBody MemberDto memberDto){
        int result = memberService.signUp(memberDto);
        return result;
    }

    //로그인 구현
    @PostMapping("/login")
    public int login(@RequestBody MemberDto memberDto, HttpServletRequest request){
        //1. 세션 정보 가져오기
        HttpSession session = request.getSession();
        //2. 로그인 성공한 회원번호 확인
        int result = memberService.login(memberDto);
        if(result > 0){
            //3. 세션 정보에 속성 추가하기.
            session.setAttribute("loginMno" , result);
        }
        //4. 반환
        return result;
    }

    //로그아웃 구현
    @GetMapping("/logout")
    public boolean logout(HttpServletRequest request){
        //1. 요청 객체내 세션 정보 꺼내기
        HttpSession session = request.getSession();
        //2. 만약에 세션이 없거나 특정한 속성값이 없으면 (유효성검사)
        if(session == null || session.getAttribute("loginMno")==null){
            return false;//비로그인상태; //로그아웃 실패
        }
        //3. 로그인상태이면 속성값 제거하기
        session.removeAttribute("loginMno");
        return true; // 로그아웃 성공
    }

    // 내정보 조회 구현
    @GetMapping("/info")
    public MemberDto info(HttpServletRequest request){
        //1. HttpServletRequest(요청정보)객체 세션 객체 꺼내기
        HttpSession session = request.getSession();
        //2. 만약에 비어있으면 비로그인상태
        if(session == null || session.getAttribute("loginMno") == null){
            return null;
        }
        //3. 로그인상태이면 세션 정보내 로그인상태 속성값 호출
        Object obj = session.getAttribute("loginMno"); //로그인시 정의 속성명과 동일하게 작성
        //Object타입은 자바의 최사위 클래스로써 모든 자료를 저장한다. 세션은 Object 타입으로 저장한다.
        //즉] 세션은 모든 타입의 자료를 저장할 수 있다.
        //4. 타입변환 , 강제타입변환이란? (변환할타입명)변수명; , **태생!!** : Object가 되기전에 타입있냐?
        int loginMno = (int)obj;
        //5. 서비스에게 전달하고 응답받기
        MemberDto result = memberService.info(loginMno);
        return result;
    }

    //중복검사
    @GetMapping ("/check")
    public boolean check(@RequestParam String type, @RequestParam String data){
        boolean result = memberService.check(type, data);
        return result;
    }


    //회원정보수정
    @PutMapping("/update")
    public boolean update(@RequestBody MemberDto memberDto, HttpServletRequest request){
        //1. 세션 객체 꺼내기
        HttpSession session = request.getSession();
        //2. 만약에 세션이 없다면 비로그인상태 :*수정불가능
        if(session == null || session.getAttribute("loginMno") == null){
            return false;
        }
        //3. 로그인된 회원번호 꺼내기 = 수정하는 회원의 번호
        Object obj = session.getAttribute("loginMno");
        int loginMno = (int)obj;
        //4. dto 담아주기
        memberDto.setMno(loginMno);
        //5. 서비스에게 전달 후 응답받기
        boolean result = memberService.update(memberDto);
        return result;
    }

    //비밀번호 수정
    @PutMapping("/update/password")
    public boolean updatePassword(@RequestBody Map<String,String> map, HttpServletRequest request){
        //1. 요청 객체에서 세션 정보 꺼내기
        HttpSession session = request.getSession();
        //2.
        if(session == null || session.getAttribute("loginMno") == null)return false;
        //3.
        Object obj = session.getAttribute("loginMno");
        int loginMno = (int)obj;
        //4.
        boolean result = memberService.updatePassword(loginMno, map);
        session.removeAttribute("loginMno");
        return result;
    }

    // 회원탈퇴
    @DeleteMapping("/delete")
    public boolean updatePassword(@RequestParam String oldpwd, HttpSession session){
        //1. 매개변수로 받은 요청정보내 세션객체를 확인
        if(session == null || session.getAttribute("loginMno") == null)return false;
        //2.
        int loginMno = (int)session.getAttribute("loginMno");
        //3.
        boolean result = memberService.delete(loginMno, oldpwd);
        if(result == true) session.removeAttribute("loginMno");
        return result;
    }
}//class e
