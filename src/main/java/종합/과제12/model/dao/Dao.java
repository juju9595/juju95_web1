package 종합.과제12.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
    private String db_url = "jdbc:mysql://localhost:3306/exam13";
    private String db_user = "root";
    private String db_password = "1234";
    public Connection conn;
    public Dao(){connect();}
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("Dao.connect");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
