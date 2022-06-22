package com.work.AdminWin;

import com.work.Music.MusicPlayer;
import com.work.login.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class AdminWin extends JFrame{
    JFrame adwin1 = new JFrame();
    public void SetAdmin_1(String number)  {
        adwin1.setTitle("管理员工作台");
        adwin1.setBounds(120, 120, 600, 700);
        adwin1.setVisible(true);
        adwin1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        adwin1.setLayout(null);


        JLabel la1 = new JLabel("输入歌手或者歌名查询");
        adwin1.add(la1);
        la1.setBounds(20, 40, 225, 65);
        la1.setFont(new Font("黑体", Font.PLAIN, 16));

        JLabel la2 = new JLabel("有空格请用-代替");
        adwin1.add(la2);
        la2.setBounds(40, 60, 225, 65);
        la2.setFont(new Font("黑体", Font.PLAIN, 14));

        JTextField ta1 = new JTextField();
        adwin1.add(ta1);
        ta1.setBounds(200, 55, 250, 35);
        ta1.setFont(new Font("微软雅黑", Font.PLAIN, 16));

//        JTextArea tAa1 = new JTextArea();
//        JScrollPane bar1 = new JScrollPane(tAa1);
//        adwin1.add(bar1);
//        bar1.setBounds(0,130,590,450);
//        bar1.setFont(new Font("黑体",Font.PLAIN,20));
//        tAa1.setFont(new Font("黑体",Font.PLAIN,20));
//        tAa1.setEditable(false);
//        tAa1.setLineWrap(true);
        // bar1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JPopupMenu popupMenu1 = new JPopupMenu();
        popupMenu1.setBounds(getX(),getY(),30,30);
        JMenuItem m1 = new JMenuItem("播放");
        m1.setFont(new Font("微软雅黑",Font.PLAIN,18));
        JMenuItem m2 = new JMenuItem("删除");
        m2.setFont(new Font("微软雅黑",Font.PLAIN,18));
        JMenuItem m3  = new JMenuItem("暂停");
        m3.setFont(new Font("微软雅黑",Font.PLAIN,18));
        JMenuItem m4  = new JMenuItem("继续");
        m4.setFont(new Font("微软雅黑",Font.PLAIN,18));
        popupMenu1.add(m1);
        popupMenu1.add(m3);
        popupMenu1.add(m4);
        popupMenu1.add(m2);

        final Vector[] vl1 = {new Vector<>()};
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        adwin1.add(bar1);
        bar1.setBounds(0, 130, 590, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
              popupMenu1.show(tAa1,e.getX(),e.getY());
            }
        });
        MusicPlayer player = new MusicPlayer();
        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                Splitstr getpath = new Splitstr();
                String path = null;
                try {
                    path = getpath.getpath(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                player.setMusicPath(path);
                player.prefetch();
                player.start(false);
            }
        });
        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.stopMusic();
            }
        });

        m2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    String str = (String) tAa1.getSelectedValue();
                    Splitstr splitstr = new Splitstr();
                    String songname = splitstr.getsongname(str);
                    String singername = splitstr.getsingername(str);
                    JDBC jdbc = new JDBC();
                    try {
                        jdbc.deletesong(songname,singername);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "删除成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
        });

        m4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.continueMusic();
            }
        });

        JButton ba1 = new JButton("查询");
        adwin1.add(ba1);
        ba1.setBounds(460, 55, 85, 35);
        ba1.setFont(new Font("黑体", Font.PLAIN, 20));
        ba1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = ta1.getText();
                JDBC jdbc = new JDBC();
                try {
                    vl1[0] = jdbc.findsonginfo(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                finally {
                    tAa1.setListData(vl1[0]);
                }
            }
        });

//        ba1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int count = 0;
//                boolean findjudge = true;
//                String str = ta1.getText();
//                JDBC findsong = new JDBC();
//                while (findjudge){
//                    try {
//                        if(findsong.FindSonginfo(str).equals("")) findjudge = false;
//                        if(!findsong.FindSonginfo(str).equals("")) {
//                            tAa1.append(findsong.FindSonginfo(str));
//                            System.out.println(findsong.FindSonginfo(str));
//                            count++;
//                        }
//                    } catch (SQLException ex) {
//                        ex.printStackTrace();
//                    }
//                }
//                System.out.println(count);
//          }
//        });


        JButton ba2 = new JButton("添加歌曲");
        adwin1.add(ba2);
        ba2.setBounds(120, 615, 125, 45);
        ba2.setFont(new Font("黑体", Font.PLAIN, 18));
        ba2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSong addSong = new AddSong();
                addSong.SetAddSong();
            }
        });

        JButton ba3 = new JButton("添加歌手");
        adwin1.add(ba3);
        ba3.setBounds(360, 615, 125, 45);
        ba3.setFont(new Font("黑体", Font.PLAIN, 18));
        ba3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddSong addSinger = new AddSong();
                addSinger.SetaddSinger();
            }
        });


        adwin1.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(adwin1, "是否退出登录?",
                        "提示!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.YES_OPTION == flag) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    String url = "jdbc:mysql://localhost:3306/information";
                    String username = "root";
                    String password = "5201314LX";
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
                    adwin1.dispose();
                }
            }
        });
    }
}
