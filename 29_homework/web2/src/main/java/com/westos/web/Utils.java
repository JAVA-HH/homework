package com.westos.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
    static final String URL="jdbc:mysql://localhost:3306/test?";
    static final String USERNAME="root";
    static final String PASSWORD="root";


    //建立数据库连接
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
}