package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao {

    // [1] 등록
    public boolean boardWrite(BoardDto boardDto){
        try{
            String sql = "INSERT INTO board ( bcontent, bwriter ) VALUES (?, ?);";  // 1. SQL 작성한다.
            PreparedStatement ps = conn.prepareStatement( sql );  // 2. SQL 기재한다..
            // 3. SQL 매개변수 대입 , 현재 ? 2개
            ps.setString( 1 , boardDto.getBcontent() ); // SQL내 1번 ? 에 매개변수로 받은 boardDto의 bcontent 값 대입
            ps.setString( 2 , boardDto.getBwriter() ); // SQL내 2번 ? 에 매개변수로 받은 boardDto의 bwriter 값 대입
            // 4. SQL 실행  , insert/update/delete 은 .executeUpdate();
            int count = ps.executeUpdate();
            // 5. sql 결과에 따른 로직/리턴/확인
            if( count >= 1 ) return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

    //[2] 조회
    public List<BoardDto> boardPrint(){
        System.out.println("BoardDao.boardPrint");
        List<BoardDto> list = new ArrayList<>(); // 1. 여러개 레코드를 dto로 변환해서 dto들을 저장할 리스트
        try {
            String sql = "select * from board"; // 2. SQL 작성
            PreparedStatement ps = conn.prepareStatement(sql); //3.sql 기재
            ResultSet rs = ps.executeQuery();  // 4. SQL 실행   , select = executeQuery()
            while ( rs.next() ) { // rs.next() : ResultSet 인터페이스가 갖는 (조회)결과테이블에서 다음레코드 이동 뜻
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(rs.getInt("bno")); //6. rs.getlnt() 현재조회중인 레코드에서 bno 속성값 호출
                boardDto.setBcontent(rs.getString("bcontent"));
                boardDto.setBwriter(rs.getNString("bwriter"));
                list.add(boardDto); //7. 생성된 dto를 리스트에 저장
            } // while 반복문 종료
        } catch (Exception e) { System.out.println(e); }
        return list;
    }

    //[3] 개별조회
    public BoardDto boardFind(int bno){
        try {
            String sql = "select * from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                //while(rs.next()) : 여러개 조회
                //if(rs.next()) : 한개 조회
                BoardDto boardDto = new BoardDto();
                boardDto.setBno(rs.getInt(1));
                boardDto.setBcontent(rs.getString(2));
                boardDto.setBwriter(rs.getNString(3));
                return boardDto;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; // 실패시 null
    }

    //[4] 삭제
    public boolean boardDelete(int bno){
        try{
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,bno);
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }

    //[5] 수정
    public boolean boardUpdate(BoardDto boardDto){
        try{
            String sql = "update board set bcontent =? where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBcontent());
            ps.setInt(2,boardDto.getBno());
            int count = ps.executeUpdate();
            if(count == 1)return true;
        }catch (Exception e){
            System.out.println(e);
        }return false;
    }
}
