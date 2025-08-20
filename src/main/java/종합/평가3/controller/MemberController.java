package 종합.평가3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.평가3.model.dto.MemberDto;
import 종합.평가3.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired private MemberService memberService;

    //(1) 회원 등록 기능 구현
    @PostMapping("")
    public int memberWrite(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.memberWrite");
        System.out.println("memberDto = " + memberDto);
        int result = memberService.memberWrite(memberDto);
        return result;
    }

    //(2) 회원 전체 기능 구현
    @GetMapping("")
    public List<MemberDto> memberPrint(){
        List<MemberDto> result = memberService.memberPrint();
        return result;
    }

    //(3)회원개별 조회
    @GetMapping("/info")
    public MemberDto memberinfo(int custno){
        MemberDto result =  memberService.memberinfo(custno);
        return result;
    }

    //(4) 회원 정보 수정 기능 구현
    @PutMapping("")
    public boolean memberUpdate(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.memberUpdate(memberDto);
        return result;
    }

}//class e
