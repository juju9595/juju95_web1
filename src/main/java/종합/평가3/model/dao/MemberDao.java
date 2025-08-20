package 종합.평가3.model.dao;

import org.springframework.stereotype.Repository;
import 종합.평가3.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDao extends Dao{

    //[1] 회원 등록
    public int memberWrite(MemberDto memberDto){
        try{
            String sql = "INSERT INTO MEMBER_TBL_02 (custname, phone, address, grade, city) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getGrade());
            ps.setString(5,memberDto.getCity());
            int count = ps.executeUpdate();
            if (count == 1){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int custno = rs.getInt(1);
                    return custno;
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }return 0;
    }

    //[2] 회원 조회
    public List<MemberDto> memberPrint(){
        System.out.println("MemberDao.memberPrint");
        List<MemberDto> list = new ArrayList<>();
        try{
            String sql = "select *from MEMBER_TBL_02";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){//여러개 조회
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustname(rs.getNString("custname"));
                memberDto.setPhone(rs.getNString("phone"));
                memberDto.setAddress(rs.getNString("address"));
                memberDto.setJoindate(rs.getDate("joindate"));
                memberDto.setGrade(rs.getNString("grade"));
                memberDto.setCity(rs.getNString("city"));
                list.add(memberDto);
            }//while e
        }catch (Exception e){
            System.out.println(e);
        }return list;
    }

    //[3] 수정
    public boolean memberUpdate(MemberDto memberDto){
        try{
            String sql = "update MEMBER_TBL_02 set custname=? , phone=?, address=?, grade=?, city=? where custno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getCustname());
            ps.setString(2, memberDto.getPhone());
            ps.setString(3, memberDto.getAddress());
            ps.setString(5,memberDto.getGrade());
            ps.setString(6, memberDto.getCity());
            ps.setInt(7,memberDto.getCustno());
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

    //[4] 선택 회원정보 출력
    public MemberDto memberinfo( int custno ){
        try{
            String sql = "select *from member_tbl_02 where custno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,custno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustname(rs.getNString("custname"));
                memberDto.setPhone(rs.getNString("phone"));
                memberDto.setAddress(rs.getNString("address"));
                memberDto.setJoindate(rs.getDate("joindate"));
                memberDto.setGrade(rs.getNString("grade"));
                memberDto.setCity(rs.getNString("city"));
                return memberDto;
            }
        }catch (Exception e){
            System.out.println(e);
        }return null;
    }

}//class e
