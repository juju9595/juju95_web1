package 종합.과제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.과제12.model.dto.WaitingDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao {

    //[1] 등록
    public boolean waitingWrite(WaitingDto waitingDto){
        try{
            String sql = "INSERT INTO waiting (wphone, wcount) VALUES (?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getWphone());
            ps.setString(2, waitingDto.getWcount());
            int count = ps.executeUpdate();
            if(count >=1) return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

    //[2] 조회
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingDao.waitingPrint");
        List<WaitingDto> list = new ArrayList<>();
        try{
            String sql = "select * from waiting";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){ // 여러개 조회
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt("wno"));
                waitingDto.setWphone(rs.getString("wphone"));
                waitingDto.setWcount(rs.getString("wcount"));
                waitingDto.setWdate(rs.getString("wdate"));
                list.add(waitingDto);
            }//while e
        }catch (Exception e){
            System.out.println(e);
        }return list;
    }

    //[3] 개별조회
    public WaitingDto waitingFind(int wno){
        try {
            String sql = "select * from waiting where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, wno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){// 한개 조회
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt(1));
                waitingDto.setWphone(rs.getString(2));
                waitingDto.setWcount(rs.getString(3));
                waitingDto.setWdate(rs.getString(4));
                return waitingDto;
            }
        }catch (Exception e){
            System.out.println(e);
        }return null; //실패시 null
    }

    //[4] 삭제
    public boolean waitingDelete(int wno){
        try{
            String sql = "delete from waiting where wno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,wno);
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

    //[5] 수정
    public boolean waitingUpdate(WaitingDto waitingDto){
        try{
            String sql = "update waiting set wphone =? , wcount=? where wno =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getWphone());
            ps.setString(2, waitingDto.getWcount());
            ps.setInt(3,waitingDto.getWno());
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }




}//class e
