package lib.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @date 2018年6月8日
 * @time 上午10:34:43
 */
public class Dbutil {
	
	String url = "jdbc:mysql://localhost:3306/sc?"
            + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";

    private String jdbcName="com.mysql.jdbc.Driver";

    public Connection getCon() throws Exception{
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args){
        Dbutil dbutil = new Dbutil();
        System.out.println(dbutil.hashCode());

        try {
            dbutil.getCon();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
