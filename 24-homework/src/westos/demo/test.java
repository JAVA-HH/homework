package westos.demo;

import java.sql.*;

public class test {
    public static void main(String[] args) throws SQLException {
        //1、创建连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test3", "root", "root");
        System.out.println(conn.isClosed());
        //2、准备sql语句
        Statement stat = conn.createStatement();
        //3、执行sql语句
       // stat.executeUpdate("insert into dept(deptno,dname,loc) values (60,'市场部','西安')");//执行增删改
        ResultSet rs = stat.executeQuery("select * from dept");
        while (rs.next()){
            System.out.println(rs.getInt("deptno")+"...."+rs.getString("dname")+"..."+rs.getString("loc"));
        }
        //4、清理资源
        stat.close();
        conn.close();

    }
}
