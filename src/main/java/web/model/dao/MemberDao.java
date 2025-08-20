package web.model.dao;

import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;
import 종합.과제12.model.dto.WaitingDto;

import java.lang.reflect.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

@Repository
public class MemberDao extends Dao{

    // 회원가입
    public int signUp(MemberDto memberDto){
        try{
            String sql = "INSERT INTO member (mid, mpwd, mname, mphone) VALUES (?,?,?,?);";
            // SQL기재한다. + ** auto_increment(자동PK) 값 결과를 반환 설정**
            PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, memberDto.getMid());
            ps.setString(2,memberDto.getMpwd());
            ps.setString(3,memberDto.getMname());
            ps.setString(4,memberDto.getMphone());
            int count = ps.executeUpdate();
            if(count == 1){
                // auto_increment 로 자동 할당된 pk 값 반환하여 rs로 조작하기
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){//자동 할당된 pk값중에 첫번째 pk값으로 이동
                    int mno = rs.getInt(1);//pk값 가져오기
                    return mno; //회원가입 성공한 회원의 번호를 반환한다.
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }return 0; // 회원가입 실패시 0 반환한다.
    }//func e

    // 로그인
    public int login(MemberDto memberDto){
        try{
            String sql = "select *from member where mid =? and mpwd =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getMid());
            ps.setString(2,memberDto.getMpwd());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int mno = rs.getInt("mno");
                return mno; // 로그인 성공시 조회한 회원번호 반환
            }
        }catch (Exception e){
            System.out.println(e);
        }return 0;
    }//func e

    // 내정보 조회
    public MemberDto info(int mno){
        try{
          String sql = "select *from member where mno =?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, mno);
          ResultSet rs = ps.executeQuery();
          if (rs.next()){
              MemberDto memberDto = new MemberDto(); //패스워드 제외한
              memberDto.setMno(rs.getInt("mno"));
              memberDto.setMid(rs.getString("mid"));
              memberDto.setMname(rs.getString("mname"));
              memberDto.setMphone(rs.getString("mphone"));
              memberDto.setMdate(rs.getString("mdate"));
              return memberDto;
          }
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }

    // 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check(String type, String data){
        try {
            //String sql = "select *from member where mid = ? ";
            //String sql = "select *from member where "+type+" = ? ";
                // --> 필드/열/컬럼/속성 명 여러개로 매개변수 사용시
            String sql = "select *from member where "+type+" = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }//중복이면 true
        }catch (Exception e){
            System.out.println(e);
        }return false; //중복이 아니면 false
    }

    // 회원정보수정
    public boolean update(MemberDto memberDto){
        try{
            String sql = "update member set mname=? , mphone=? where mno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getMname());
            ps.setString(2,memberDto.getMphone());
            ps.setInt(3,memberDto.getMno());
            int count = ps.executeUpdate();
            return count == 1;
        }catch (Exception e){
            System.out.println(e);
        }return false;

    }

    // 비밀번호 수정 : 현재 로그인된 회원의 패스워드와 일치하면 패스워드 수정
    public boolean updatePassword(int mno, Map<String, String > map){
        try{
            String sql = "update member set mpwd =? where mno =? and mpwd =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, map.get("newpwd"));//새로운 패스워드 (수정용)
            ps.setInt(2, mno);
            ps.setString(3,map.get("oldpwd"));//기존 패스워드 (확인용)
            int count = ps.executeUpdate();
            return count == 1;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

    // 회원탈퇴
    public boolean delete(int mno, String oldpwd){ // oldpwd(삭제하기전확인용)
        try{
            String sql = "delete from member where mno =? and mpwd =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            ps.setString(2, oldpwd);
            return ps.executeUpdate() == 1;
        }catch (Exception e){
            System.out.println(e);
        }return false;

    }

    // 아이디찾기
    public MemberDto findId(MemberDto memberDto){
        try{
            String sql = "select *from member where mname=? and mphone=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());
            ps.setString(2,memberDto.getMphone());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                memberDto.setMid(rs.getString("mid"));
                return memberDto; // 일치할 경우 조회한 회원번호 반환
            }
        } catch (Exception e) {
            System.out.println(e);
        }return null;
    }
    // 비밀번호 찾기





}//class e
