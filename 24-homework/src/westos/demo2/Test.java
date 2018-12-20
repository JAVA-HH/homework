package westos.demo2;

import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        PreparedStatement stmt = conn.prepareStatement("select * from xx_user where username = ? and password = ? ");
// 2) 给?占位符赋值
        stmt.setString(1, "wang");
        stmt.setString(2, "123"); // 会将整个值当做一个整体，把or当做了值而不是关键字
// 3) 运行sql
        ResultSet rs = stmt.executeQuery(); // 会将sql语句以及通过set方法设置的参数值，一起发送给数据库服务器
        if(rs.next()) {
            System.out.println("查询到了");
        } else {
            System.out.println("没查询到");
        }
    }
}
