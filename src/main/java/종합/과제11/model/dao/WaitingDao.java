package 종합.과제11.model.dao;


import 종합.과제11.model.dto.WaitingDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class WaitingDao {
    private WaitingDao(){connect();}
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }
    private String db_url = "jdbc:mysql://localhost:3306/exam12";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user,db_password);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    //(1) 등록 기능 구현
    public boolean waitingWrite(WaitingDto waitingDto){
        try{
            String sql = "INSERT INTO waiting (wphone, wcount) VALUES (?, ?);"; //SQL를 작성한다.
            PreparedStatement ps = conn.prepareStatement(sql); //SQL 기재한다.
            ps.setString(1, waitingDto.getWphone());//SQL내 1번?에 매개변수로 받은 waitingDto의 Wphone 값 대입
            ps.setString(2, waitingDto.getWcount());//SQL내 2번?에 매개변수로 받은 waitingDto의 Wcount 값 대입
            //SQL 실행
            int count = ps.executeUpdate();
            //sql 결과에 따른 로직/리턴/확인
            if(count >=1)return true;//1개 이상 insert 했으면 저장 성공
            return false;//1게 이상 insert 못했으면 저장 실패
        }catch(Exception e){System.out.println(e);}//catch e
        return false; // 예외 발생시 저장 실패.
    }//func e

    //(2) 전체조회 기능 구현
    public ArrayList<WaitingDto> waitingPrint(){
        ArrayList<WaitingDto> list = new ArrayList<>();
        try{
            String sql ="select *from waiting"; //SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql); //SQL 기재
            //SQL 매개변수 대입, SQL 문법에 ?(매개변수)가 없어서 생략
            ResultSet rs = ps.executeQuery(); //SQL 실행
            //SQL 결과에 따른 로직/리턴/확인
            while (rs.next()){
                //현재 조회중인 레코드의 속성값 호출해서 dto 만들기
                int wno = rs.getInt("wno");
                String wphone = rs.getString("wphone");
                String wcount = rs.getString("wcount");
                WaitingDto waitingDto = new WaitingDto(wno,wphone,wcount);
                //생성된 dto를 리스트에 담아주기
                list.add( waitingDto);
            }//while 반복문 종료
        }catch (Exception e){System.out.println(e);}
        return list;
    }//func e

    //(3) 삭제 기능 구현
    public boolean waitingDelete(int wno){
        try{
            String sql = "delete from waiting where wno =?"; //SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql);//SQL 기재
            ps.setInt(1, wno);//SQL문법내 첫번째? 의 INT타이으로 wno 값 대입
            //SQL실행
            int count = ps.executeUpdate();
            //SQL 결과에 따른 로직/리턴/확인
            if(count == 1){return true;}//sql 결과 1이면 성공
            else { return false;}//sql 결과가 1이 아니면 실패
        }catch (Exception e){
            System.out.println(e);
        }return false; // 예외 발생시 삭제 실패
    }

    //(4) 수정 기능 구현
    public boolean waitingUpdate(WaitingDto waitingDto){
        try{
            String sql = "update waiting set wcount =? where wno =?";//sql생성
            PreparedStatement ps = conn.prepareStatement(sql);//sql기재
            ps.setString(1, waitingDto.getWcount());
            ps.setInt(2, waitingDto.getWno());
            //sql실행
            int count = ps.executeUpdate();
            if(count == 1)return true;
            return false;
        }catch (Exception e){
            System.out.println(e);
        }return false; //예외 발생시 수정 실패
    }


}//class e
