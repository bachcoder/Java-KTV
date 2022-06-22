package com.work.UserWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class UserKTV extends JFrame {
    JFrame uwin1 = new JFrame();
    public void SetWin_1(String str , String number){
        uwin1.setTitle(str+"自助点歌台");
        uwin1.setBounds(200, 120, 850, 700);
        uwin1.setVisible(true);
        uwin1.setResizable(false);
        uwin1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        uwin1.setLayout(null);
        uwin1.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(uwin1, "是否退出登录?",
                        "提示!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.YES_OPTION == flag) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    String url = "jdbc:mysql://localhost:3306/information";
                    String username = "root";
                    String password = "";
//        3.连接成功，数据库对象 Connection
                    Connection con = null;
                    try {
                        con = DriverManager.getConnection(url, username, password);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
//        4.执行SQL对象Statement，执行SQL的对象
                    Statement statement = null;
                    try {
                        statement = con.createStatement();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    String sql2 = "SELECT * FROM online";
                    try {
                        ResultSet resultSet1 = statement.executeQuery(sql2);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    PreparedStatement psql = null;
                    try {
                        psql = con.prepareStatement("delete from online where accountnumber = ?");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        psql.setString(1, number);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    try {
                        psql.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    // System.exit(0);
                    uwin1.dispose();
                }
            }
        });
        JButton bk1 = new JButton("分类");
        uwin1.add(bk1);
        bk1.setBounds(120,280,105,65);
        bk1.setFont(new Font("黑体",Font.PLAIN,20));
        bk1.setContentAreaFilled(false);
        bk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });

        JButton bk2 = new JButton("已点歌曲");
        uwin1.add(bk2);
        bk2.setBounds(320,280,145,65);
        bk2.setFont(new Font("黑体",Font.PLAIN,20));
        bk2.setContentAreaFilled(false);
        bk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Playline playline = new Playline();
                playline.Setplayline();
            }
        });

        JButton bk3 = new JButton("排行");
        uwin1.add(bk3);
        bk3.setBounds(560,280,105,65);
        bk3.setFont(new Font("黑体",Font.PLAIN,20));
        bk3.setContentAreaFilled(false);
        bk3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ranking ranking = null;
                try {
                    ranking = new ranking();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton bk4 = new JButton("酒水服务");
        uwin1.add(bk4);
        bk4.setBounds(120,420,125,65);
        bk4.setFont(new Font("黑体",Font.PLAIN,20));
        bk4.setContentAreaFilled(false);
        bk4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Serve serve = new Serve();
                serve.beverageservice();
            }
        });

        JButton bk5 = new JButton("已播");
        uwin1.add(bk5);
        bk5.setBounds(340,420,125,65);
        bk5.setFont(new Font("黑体",Font.PLAIN,20));
        bk5.setContentAreaFilled(false);
        bk5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                already already = new already();
                already.Setalready();
            }
        });

//        JButton bk6 = new JButton("重唱");
//        uwin1.add(bk6);
//        bk6.setBounds(540,420,125,65);
//        bk6.setFont(new Font("黑体",Font.PLAIN,20));
//        bk6.setContentAreaFilled(false);

        JButton bk7 = new JButton("拼音点歌");
        uwin1.add(bk7);
        bk7.setBounds(545,550,125,65);
        bk7.setFont(new Font("黑体",Font.PLAIN,20));
        bk7.setContentAreaFilled(false);
        bk7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SongSearch playerSearch = new SongSearch();
                playerSearch.palyersearch();
            }
        });


        JButton bk8 = new JButton("歌星点歌");
        uwin1.add(bk8);
        bk8.setBounds(340,550,125,65);
        bk8.setFont(new Font("黑体",Font.PLAIN,20));
        bk8.setContentAreaFilled(false);
        bk8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SingerSearch songSearch = new SingerSearch();
                songSearch.namesearch();
            }
        });

        JButton bk9 = new JButton("语别点歌");
        uwin1.add(bk9);
        bk9.setBounds(115,550,125,65);
        bk9.setFont(new Font("黑体",Font.PLAIN,20));
        bk9.setContentAreaFilled(false);
        bk9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LanguageSearch languageSearch = new LanguageSearch();
            }
        });

    }
}
