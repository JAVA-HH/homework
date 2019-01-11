package com.westos.web;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet(urlPatterns = "/mform")
public class MyForm extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        String user="[a-zA-Z0-9]{4,14}";
        if (username.matches(user)  && password.matches(user)){
            useMysql(username,password);
        }else {
            System.out.println("用户名或密码格式不合理");
        }

    }
    public static void useMysql(String p,String u){
        try(Connection conn = Utils.getConnection()) {
            System.out.println(conn.isClosed());
            String sql="insert into user(username,password)values(?,?)";
            try(PreparedStatement psmt = conn.prepareStatement(sql)){
                psmt.setString(1,p);
                psmt.setString(2,u);
                int i = psmt.executeUpdate();
                System.out.println(i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
