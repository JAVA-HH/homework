package westos.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test3 {
    public static void main(String[] args) throws SQLException {
        //建立连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        Statement stat = conn.createStatement();
//        String sql="create table xx_user (\n" +
//               "   username varchar(20) primary key,\n" +
//                "   password varchar(20) not null\n)";
        String sql ="insert into xx_user values('wang', '123');\n";
        stat.executeUpdate(sql);
        conn.close();
        stat.close();
    }
}
