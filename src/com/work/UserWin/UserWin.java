package com.work.UserWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserWin extends JFrame {
    static LocalDateTime dateTime1 = LocalDateTime.now();
    static String logtime;
    JFrame Mainwin = new JFrame();
    public void openwin(String number) throws SQLException {

        Mainwin.setTitle("KTV");
        Mainwin.setLayout(null);
        Mainwin.setBounds(120, 120, 800, 600);
        Mainwin.setVisible(true);
        Mainwin.setResizable(false);
        Mainwin.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        Mainwin.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(Mainwin, "是否退出登录?",
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
                    Mainwin.dispose();
                }
            }
        });

        JLabel lu1 = new JLabel("包厢选择");
        Mainwin.add(lu1);
        lu1.setBounds(310, 0, 125, 65);
        lu1.setFont(new Font("黑体", Font.PLAIN, 30));

        JLabel lu2 = new JLabel("选择您想要的包间类型,点击即可了解收费标准以及服务内容");
        Mainwin.add(lu2);
        lu2.setBounds(200, 45, 450, 55);
        lu2.setFont(new Font("微软雅黑", Font.PLAIN, 15));

        JButton bu1 = new JButton("玲珑包");
        Mainwin.add(bu1);
        bu1.setBounds(100,110,150,55);
        bu1.setFont(new Font("黑体",Font.PLAIN,20));
        bu1.setContentAreaFilled(false);
        bu1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "可容纳3人的包房"+"\n"+"唱K时长:两个小时"+"\n"+"赠送的饮品:无赠送"+"\n"+"赠送的餐品:无"+"\n"+"价格:99元", "玲珑包内容", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton bu2 = new JButton("小包");
        Mainwin.add(bu2);
        bu2.setBounds(320,110,150,55);
        bu2.setFont(new Font("黑体",Font.PLAIN,20));
        bu2.setContentAreaFilled(false);
        bu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "可容纳5人的包房"+"\n"+"唱K时长:三个小时"+"\n"+"赠送的饮品:六听啤酒"+"\n"+"赠送的餐品:无"+"\n"+"价格:159元", "小包内容", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton bu3 = new JButton("中包");
        Mainwin.add(bu3);
        bu3.setBounds(550,110,150,55);
        bu3.setFont(new Font("黑体",Font.PLAIN,20));
        bu3.setContentAreaFilled(false);
        bu3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "可容纳7人的包房"+"\n"+"唱K时长:四个小时"+"\n"+"赠送的饮品:九听啤酒"+"\n"+"赠送的餐品:小果盘"+"\n"+"价格:229元", "中包内容", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton bu4 = new JButton("大包");
        Mainwin.add(bu4);
        bu4.setBounds(100,275,150,55);
        bu4.setFont(new Font("黑体",Font.PLAIN,20));
        bu4.setContentAreaFilled(false);
        bu4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "可容纳9人的包房"+"\n"+"唱K时长:五个小时"+"\n"+"赠送的饮品:九听啤酒+两杯金酒+两杯长岛冰茶"+"\n"+"赠送的餐品:大果盘"+"\n"+"价格:329元", "大包内容", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton bu5 = new JButton("商务包");
        Mainwin.add(bu5);
        bu5.setBounds(320,275,150,55);
        bu5.setFont(new Font("黑体",Font.PLAIN,20));
        bu5.setContentAreaFilled(false);
        bu5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "可容纳12人的包房"+"\n"+"唱K时长:六个小时"+"\n"+"赠送的饮品:啤酒随便喝+两杯金酒+两杯长岛冰茶"+"\n"+"赠送的餐品:精品大果盘"+"\n"+"价格:499元", "商务包内容", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton bu6 = new JButton("总统包");
        Mainwin.add(bu6);
        bu6.setBounds(550,275,150,55);
        bu6.setFont(new Font("黑体",Font.PLAIN,20));
        bu6.setContentAreaFilled(false);
        bu6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "可容纳15人的包房"+"\n"+"唱K时长:下单24小时内"+"\n"+"赠送的饮品:所有饮品畅快喝不限量"+"\n"+"赠送的餐品:精品大果盘+精美雪花牛排"+"\n"+"热门DJ现场打碟!"+"\n"+"价格:899元", "总统包内容", JOptionPane.INFORMATION_MESSAGE);
            }
        });



        JLabel lu3 = new JLabel("选择您的想要的包房并点击确定");
        Mainwin.add(lu3);
        lu3.setBounds(90,400,600,45);
        lu3.setFont(new Font("微软雅黑",Font.PLAIN,20));

        JComboBox<String> cu1 = new JComboBox<String>();
        Mainwin.add(cu1);
        cu1.addItem("玲珑包");
        cu1.addItem("小包");
        cu1.addItem("中包");
        cu1.addItem("大包");
        cu1.addItem("商务包");
        cu1.addItem("总统包");
        cu1.setBounds(390,400,150,45);
        cu1.setFont(new Font("黑体",Font.PLAIN,20));

        JButton bu7 = new JButton("确定");
        Mainwin.add(bu7);
        bu7.setBounds(560,400,120,45);
        bu7.setFont(new Font("黑体",Font.PLAIN,20));
        bu7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserKTV userKTV = new UserKTV();
                String a = cu1.getSelectedItem().toString();
                int flag = JOptionPane.showConfirmDialog(Mainwin, "您确定要选择"+a+"吗?",
                        "提示!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.YES_OPTION == flag) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                     logtime = dateTime1.format(formatter);
                          userKTV.SetWin_1(a,number);
                          Mainwin.dispose();
                }
                else
                    return;
            }
        });
    }

    }
