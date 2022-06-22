package com.work.login;

import java.sql.*;
public class onlineJudge {
    public boolean Findinfo(String acco) throws SQLException {
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
        String sql = "SELECT *FROM online";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement( "select * from online where accountnumber = ?" );
        psql.setString(1,acco);
        while(resultSet.next()){
            if(resultSet.getString("accountnumber").equals(acco))
                return false;
        }
        resultSet.close();
        statement.close();
        con.close();
        return true;
    }
}
