package 종합.평가3.model.dao;

import org.springframework.stereotype.Repository;
import 종합.평가3.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberDao extends Dao{

    //[1] 회원 등록
    public boolean memberWrite(MemberDto memberDto){
        try{
            String sql = "INSERT INTO MEMBER_TBL_02 (custname, phone, address, grade, city) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getGrade());
            ps.setString(5,memberDto.getCity());
            int count = ps.executeUpdate();
            if (count >=1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
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

    //[3] 회원 매출 조회
    public List<MemberDto> moneyPrint(){
        System.out.println("MemberDao.moneyPrint");
        List<MemberDto> list = new ArrayList<>();
        try{
            String sql = "select custno, sum(amount*price) from MONEY_TBL_02 order by sum(amount*price) desc limit 4";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MemberDto memberDto = new MemberDto();
                memberDto.setCustno(rs.getInt("custno"));
                memberDto.setCustname(rs.getNString("custname"));
                memberDto.setGrade(rs.getNString("grade"));
            }
        }catch (Exception e){
            System.out.println(e);
        }return list;
    }
    //[4] 수정
    public boolean memberUpdate(MemberDto memberDto){
        try{
            String sql = "update MEMBER_TBL_02 set custname=? , phone=?, address=?, grade=?, city=? where custno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getCustname());
            ps.setString(2, memberDto.getPhone());
            ps.setString(3, memberDto.getAddress());
            ps.setString(4,memberDto.getGrade());
            ps.setString(5, memberDto.getCity());
            ps.setInt(6,memberDto.getCustno());
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

}//class e
