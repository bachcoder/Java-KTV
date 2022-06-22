package com.work.login;

import java.sql.*;
import java.util.Vector;

public class JDBC {
    public void addAccountNumber(String acc, String pas) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("insert into user (accountnumber,password) "
                + "values(?,?)");
        psql.setString(1, acc);
        psql.setString(2, pas);
        psql.executeUpdate();
        //  6.释放连接
        resultSet.close();
        statement.close();
        con.close();
    }

    public boolean Findinfo(String acco) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM user";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from user where accountnumber = ?");
        psql.setString(1, acco);
        while (resultSet.next()) {
            if (resultSet.getString("accountnumber").equals(acco))
                return false;
        }
        resultSet.close();
        statement.close();
        con.close();
        return true;
    }

    public void AddSonginfo(String songname, String singername, String language, String songstyle, String suoxie, String songpath, String sort) throws SQLException {
        int Rank = 0;
        int playcount = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql, psql2;
        psql = con.prepareStatement("insert into songinfo (Songname,Singername,Language,Songstyle,suoxie,Songpath,ranks,sort,playcount)"
                + "values(?,?,?,?,?,?,?,?,?)");
        psql.setString(1, songname);
        psql.setString(2, singername);
        psql.setString(3, language);
        psql.setString(4, songstyle);
        psql.setString(5, suoxie);
        psql.setString(6, songpath);
        psql.setInt(7, Rank);
        psql.setString(8, sort);
        psql.setInt(9, playcount);
        psql.executeUpdate();
        //  6.释放连接
        resultSet.close();
        statement.close();
        con.close();
    }

    public void AddSingerinfo(String Singername, String Singerlocation, String Singersuoxie, String Photopath) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM singerinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("insert into singerinfo (Singername,Singerlocation,Singersuoxie,Photopath) "
                + "values(?,?,?,?)");
        psql.setString(1, Singername);
        psql.setString(2, Singerlocation);
        psql.setString(3, Singersuoxie);
        psql.setString(4, Photopath);
        psql.executeUpdate();
        //  6.释放连接
        resultSet.close();
        statement.close();
        con.close();
    }

    public void deletesong(String songname, String singername) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("delete from songinfo where Songname = ? and Singername = ?");
        psql.setString(1, songname);
        psql.setString(2, singername);
        psql.executeUpdate();

        resultSet.close();
        statement.close();
        con.close();
    }


    public Vector findsonginfo(String str) throws SQLException {
        Vector v = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where Songname = ? or Singername = ?");
        psql.setString(1, str);
        psql.setString(2, str);
        String songname = null;
        String singername = null;
        String songstyle = null;
        while (resultSet.next()) {
            if (resultSet.getString("Singername").equals(str) || resultSet.getString("Songname").equals(str)) {
                songname = resultSet.getString("Songname");
                singername = resultSet.getString("Singername");
                songstyle = resultSet.getString("Songstyle");
                //  System.out.println(songname+" "+singername + " "+ songstyle);
                String res = songname + " " + singername + " " + songstyle;
                v.add(res);
            }
        }
        //    psql.executeUpdate();
        resultSet.close();
        statement.close();
        con.close();
        return v;
    }

    public String getpath(String songname, String singername) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where Songname  = ? and Singername = ?");
        psql.setString(1, songname);
        psql.setString(2, singername);
        String path = null;
        while (resultSet.next()) {
            if (resultSet.getString("Singername").equals(singername) && resultSet.getString("Songname").equals(songname)) {
                path = resultSet.getString("SongPath");
                return path;
            }
        }
        // psql.executeUpdate();
        // 6.释放连接
        resultSet.close();
        statement.close();
        con.close();
        return "null";
    }

    public Vector findsort(String sort) throws SQLException {
        Vector v = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where sort = ?");
        psql.setString(1, sort);
        String songname = null;
        String singername = null;
        String songstyle = null;
        while (resultSet.next()) {
            if (resultSet.getString("sort").equals(sort)) {
                songname = resultSet.getString("Songname");
                singername = resultSet.getString("Singername");
                songstyle = resultSet.getString("Songstyle");
                //  System.out.println(songname+" "+singername + " "+ songstyle);
                String res = songname + " " + singername + " " + songstyle;
                v.add(res);
            }
        }
        //    psql.executeUpdate();
        resultSet.close();
        statement.close();
        con.close();
        return v;
    }

    public void Addrank(String songname, String singername) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("update songinfo set ranks = ranks + 1 where Songname  = ? and Singername = ?");
        psql.setString(1, songname);
        psql.setString(2, singername);
//        while(resultSet.next()){
//            if(resultSet.getString("Singername").equals(singername) && resultSet.getString("Songname").equals(songname)){
//                path = resultSet.getString("SongPath");
//            }
//        }
        psql.executeUpdate();
        // 6.释放连接
        resultSet.close();
        statement.close();
        con.close();
    }

    public boolean findsonginfo(String songname, String singername) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where Songname = ? or Singername = ?");
        psql.setString(1, songname);
        psql.setString(2, singername);
        ;
        while (resultSet.next()) {
            if (resultSet.getString("Singername").equals(singername) && resultSet.getString("Songname").equals(songname)) {
                return false;
            }
        }
        //    psql.executeUpdate();
        resultSet.close();
        statement.close();
        con.close();
        return true;
    }

    public boolean findsingerinfo(String singername) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM singerinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from singerinfo where Singername = ?");
        psql.setString(1, singername);
        while (resultSet.next()) {
            if (resultSet.getString("Singername").equals(singername)) {
                return false;
            }
        }
        //    psql.executeUpdate();
        resultSet.close();
        statement.close();
        con.close();
        return true;
    }

    public Vector songsearch(String str, String s) throws SQLException {
        Vector vector = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where suoxie like ?");
        psql.setString(1, str);
        String songname = null;
        String singername = null;
        String songstyle = null;
        while (resultSet.next()) {
            if (resultSet.getString("suoxie").contains(s)) {
                songname = resultSet.getString("Songname");
                singername = resultSet.getString("Singername");
                songstyle = resultSet.getString("Songstyle");
                String res = songname + " " + singername + " " + songstyle;
                vector.add(res);
            }
        }
        //    psql.executeUpdate();
        resultSet.close();
        statement.close();
        con.close();
        return vector;
    }

    public Vector singersearch(String str, String s) throws SQLException {
        Vector vector = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM singerinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from singerinfo where Singersuoxie like ?");
        psql.setString(1, str);
        String singername = null;
        while (resultSet.next()) {
            if (resultSet.getString("Singersuoxie").contains(s)) {
                singername = resultSet.getString("Singername");
                vector.add(singername);
            }
        }
        return vector;
    }

    public Vector singerfinfo(String str) throws SQLException {
        Vector vector = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where Singername = ?");
        psql.setString(1, str);
        String songname = null;
        String singername = null;
        String songstyle = null;
        while (resultSet.next()) {
            if (resultSet.getString("Singername").equals(str)) {
                songname = resultSet.getString("Songname");
                singername = resultSet.getString("Singername");
                songstyle = resultSet.getString("songstyle");
                String res = songname + " " + singername + " " + songstyle;
                vector.add(res);
            }
        }
        return vector;
    }

    public Vector language(String str) throws SQLException {
        Vector vector = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from songinfo where Language = ?");
        psql.setString(1, str);
        String songname = null;
        String singername = null;
        String songstyle = null;
        while (resultSet.next()) {
            if (resultSet.getString("Language").equals(str)) {
                songname = resultSet.getString("Songname");
                singername = resultSet.getString("Singername");
                songstyle = resultSet.getString("songstyle");
                String res = songname + " " + singername + " " + songstyle;
                vector.add(res);
            }
        }
        return vector;
    }

    public Vector rank() throws SQLException {
        Vector vector = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM songinfo order by  ranks desc";
        ResultSet resultSet = statement.executeQuery(sql);
//        PreparedStatement psql;
//        psql = con.prepareStatement("select * from songinfo order by ranks desc");
        String songname = null;
        String singername = null;
        String songstyle = null;
        int ranks;
        while (resultSet.next()) {
            songname = resultSet.getString("Songname");
            singername = resultSet.getString("Singername");
            songstyle = resultSet.getString("songstyle");
            ranks = resultSet.getInt("ranks");
            String res = songname + " " + singername + " " + songstyle + "         " + "累积播放次数" + ranks;
            vector.add(res);
        }
        return vector;
    }

    public String getsingerpath(String singername) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        2.用户信息和url
        String url = "jdbc:mysql://localhost:3306/information";
        String username = "root";
        String password = "";
//        3.连接成功，数据库对象 Connection
        Connection con = DriverManager.getConnection(url, username, password);
//        4.执行SQL对象Statement，执行SQL的对象
        Statement statement = con.createStatement();
//        5.执行SQL的对象去执行SQL，返回结果集
        String sql = "SELECT *FROM singerinfo";
        ResultSet resultSet = statement.executeQuery(sql);
        PreparedStatement psql;
        psql = con.prepareStatement("select * from singerinfo where Singername = ?");
        psql.setString(1, singername);
        String singerpath = null;
        while (resultSet.next()) {
            if (resultSet.getString("Singername").equals(singername)) {
                singerpath = resultSet.getString("Photopath");
                break;
            }
        }
        return singerpath;
    }
}
