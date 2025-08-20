package 종합.평가3.model.dao;

import org.springframework.stereotype.Repository;
import 종합.평가3.model.dto.MoneyDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoneyDao extends Dao {

    public ArrayList<MoneyDto> moneyInfo(){
        ArrayList<MoneyDto> list = new ArrayList<>();
        try{
            String sql = "select A.custno, A.custname, A.grade, sum(B.price) totalprice from member_tbl_02 A join money_tbl_02 B using(custno) group by totalprice desc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                MoneyDto moneyDto = new MoneyDto(rs.getInt("custno"), rs.getString("custname"), rs.getString("garde"), rs.getInt("totalprice"));
                list.add(moneyDto);
            }
        }catch (Exception e){
            System.out.println(e);
        }return list;
    }

}//class e
