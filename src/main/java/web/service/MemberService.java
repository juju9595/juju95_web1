package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service // 스프링 컨테이너(메모리) 빈(객체) 등록
public class MemberService {
    @Autowired // 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기
    private MemberDao memberDao;

    // [1] 회원가입
    public int signUp(MemberDto memberDto){
        int result = memberDao.signUp(memberDto);
        return result;
    }

    // [2] 로그인
    public int login(MemberDto memberDto){
        int result = memberDao.login(memberDto);
        return result;
    }

    // [4] 내정보 조회
    public MemberDto info(int mno){
        MemberDto result = memberDao.info(mno);
        return result;
    }

    // [5] 중복검사
    public boolean check(String type, String data){
        boolean result = memberDao.check(type, data);
        return result;
    }

    //[6] 회원정보수정
    public boolean update(MemberDto memberDto){
        boolean result = memberDao.update(memberDto);
        return result;
    }

    //[7] 비밀번호수정
    public boolean updatePassword(int mno, Map<String, String > map){
        boolean result = memberDao.updatePassword(mno, map);
        return result;
    }

    //[8] 회원탈퇴
    public boolean delete(int mno, String oldpwd){
        boolean result = memberDao.delete(mno, oldpwd);
        return result;
    }


    //[9] 아이디/비밀번호 찾기
    public Map<String,String> findId(Map<String,String > map) {
        String result = memberDao.findId(map);
        Map<String, String> resultMap = new HashMap<>();
        if (result == null) {
            resultMap.put("msg", null);
        } else {
            resultMap.put("msg", result);
        }
        return resultMap;
    }
    public Map<String,String> findPwd(Map<String,String > map) {
        //1. 컨트롤러로부터 사용자에게 입력받은 아이디와 연락처와 매개변수로 받아
        // ****** 유효성검사, 추가적인 이벤트 *****
        //* 난수 생성, 간단하게 0~9 사이의 6자리 난수 생성, 주의할점 : 문자열타입 한다, 숫자는 앞에 003365 -> 3365
        String mpwd = "";
        for(int i = 1; i<=6; i++){//6회전
            Random random = new Random();
            mpwd += random.nextInt(10); //0~9 까지의 난수 생성한다.
        }
        map.put("mpwd", mpwd); // 생성된 난수 비밀번호 map 속성 대입
        //2. 다오에게 입력받은 매개변수를 전달하여 결과를 확인한다
        boolean result = memberDao.findPwd(map);
        //3. 만약에 result 가 성공이면
        Map<String, String> resultMap = new HashMap<>();
        if( result == true){
            resultMap.put("msg" , mpwd);
        }else {resultMap.put("msg", "회원정보없음");}
        // 반환
        return resultMap;
    }

}
