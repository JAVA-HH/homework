package westos.demo;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        //1.创建连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3","root","root");
        Statement stat = conn.createStatement();

        String sql ="insert into student(sid,sname,birthday,sex)values(null,'小明','2018-9-9','男')";
        stat.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stat.getGeneratedKeys();
        rs.next();//获取自增列的值
        System.out.println(rs.getInt(1));

    }
}
