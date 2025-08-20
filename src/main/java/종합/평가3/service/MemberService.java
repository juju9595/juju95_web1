package 종합.평가3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.평가3.model.dao.MemberDao;
import 종합.평가3.model.dto.MemberDto;

import java.util.List;

@Service
public class MemberService {

    //등록
    @Autowired private MemberDao memberDao;
    public int memberWrite(MemberDto memberDto){
        System.out.println("MemberService.memberWrite");
        System.out.println("memberDto = " + memberDto);
        int result = memberDao.memberWrite(memberDto);
        return result;
    }

    //회원전체 조회
    public List<MemberDto> memberPrint(){
        System.out.println("MemberService.memberPrint");
        List<MemberDto> result = memberDao.memberPrint();
        return result;
    }

    //회원매출 조회
    public List<>
    //회원정보 수정
    public boolean memberUpdate(MemberDto memberDto){
        System.out.println("MemberService.memberUpdate");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberDao.memberUpdate(memberDto);
        return result;
    }
}//class e
