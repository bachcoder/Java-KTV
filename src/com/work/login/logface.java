package com.work.login;

import com.work.AdminWin.AdminWin;
import com.work.UserWin.*;
import javax.swing.*;
import java.sql.*;

public class  logface {
    UserWin logging = new UserWin();
    AdminWin adlog  = new AdminWin();
    public void loginwindow(String number,String pass) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username="root";
        String password="";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url,username,password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement( "select * from user where accountnumber = ?" );
        psql.setString(1,number);
        boolean flagging = false;
        while(resultSet.next()){
            if(resultSet.getString("accountnumber").equals(number)) {
                flagging = true;
            }
        }
      //  System.out.println(flagging);
      //  System.out.println(number+pass+"123");
        if(flagging)
           MatchPassword(number,pass);
        else
            JOptionPane.showMessageDialog(null, "用户名不存在!", "出错了", JOptionPane.ERROR_MESSAGE);
        resultSet.close();
        statement.close();
        con.close();
    }
    public void MatchPassword(String number , String pass) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username="root";
        String password="";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url,username,password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql , psql2;
        psql = con.prepareStatement( "select * from user where accountnumber = ? and password  = ?" );
        psql.setString(1,number);
        psql.setString(2,pass);
        boolean flagpa = false;
        onlineJudge ojud = new onlineJudge();
        boolean flagonline = ojud.Findinfo(number);  //方法里面写的是如果有则返回false;
        while(resultSet.next()){
            if(resultSet.getString("accountnumber").equals(number)&&resultSet.getString("password").equals(pass)) {
                flagpa = true;
                if(flagonline) {
                    JOptionPane.showMessageDialog(null, "登录成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                    logging.openwin(number);
//                    loginwin loginwin = new loginwin();
//                    loginwin.dispose();
//                    loginwin.dispose();
                    String sql2 = "SELECT * FROM online";
                    ResultSet resultSet1 = statement.executeQuery(sql2);
                    psql2 = con.prepareStatement("insert into online (accountnumber)" + " values(?)");
                    psql2.setString(1, number);
                    psql2.executeUpdate();
                    break;
                }
                else
                    JOptionPane.showMessageDialog(null, "用户已经在线!", "出错了", JOptionPane.ERROR_MESSAGE);
            }
        }
      //  System.out.println(flagpa);
        if(!flagpa)
            JOptionPane.showMessageDialog(null, "密码错误!", "出错了", JOptionPane.ERROR_MESSAGE);
        resultSet.close();
        statement.close();
        con.close();
    }
    public void loginwindow_2(String number,String pass) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username="root";
        String password="";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url,username,password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM admin";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement( "select * from admin where accountnumber = ?" );
        psql.setString(1,number);
        boolean flagging = false;
        while(resultSet.next()){
            if(resultSet.getString("accountnumber").equals(number)) {
                flagging = true;
            }
        }
        //  System.out.println(flagging);
        //  System.out.println(number+pass+"123");
        if(flagging)
            MatchPassword_2(number,pass);
        else
            JOptionPane.showMessageDialog(null, "管理员不存在!", "出错了", JOptionPane.ERROR_MESSAGE);
        resultSet.close();
        statement.close();
        con.close();
    }
    public void MatchPassword_2(String number , String pass) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username="root";
        String password="";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url,username,password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM admin";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql , psql2;
        psql = con.prepareStatement( "select * from admin where accountnumber = ? and password  = ?" );
        psql.setString(1,number);
        psql.setString(2,pass);
        boolean flagpa = false;
        onlineJudge ojud = new onlineJudge();
        boolean flagonline = ojud.Findinfo(number);  //方法里面写的是如果有则返回false;
        while(resultSet.next()){
            if(resultSet.getString("accountnumber").equals(number)&&resultSet.getString("password").equals(pass)) {
                flagpa = true;
                if(flagonline) {
                    JOptionPane.showMessageDialog(null, "登录成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                    adlog.SetAdmin_1(number);
                    loginwin loginwin = new loginwin();
                    loginwin.dispose();
                    String sql2 = "SELECT * FROM online";
                    ResultSet resultSet1 = statement.executeQuery(sql2);
                    psql2 = con.prepareStatement("insert into online (accountnumber)" + " values(?)");
                    psql2.setString(1, number);
                    psql2.executeUpdate();
                    break;
                }
                else
                    JOptionPane.showMessageDialog(null, "用户已经在线!", "出错了", JOptionPane.ERROR_MESSAGE);
            }
        }
        //  System.out.println(flagpa);
        if(!flagpa)
            JOptionPane.showMessageDialog(null, "密码错误!", "出错了", JOptionPane.ERROR_MESSAGE);
        resultSet.close();
        statement.close();
        con.close();
    }
}
