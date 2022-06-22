package com.work.UserWin;

import com.work.AdminWin.Splitstr;
import com.work.login.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class everysort {
    JFrame liuxing = new JFrame();
    JFrame oumei = new JFrame();
    JFrame remen = new JFrame();
    JFrame gudian = new JFrame();
    JFrame piano = new JFrame();
    JFrame old = new JFrame();
   public static Vector vsor = new Vector();
   Playline playline = new Playline();
   boolean flag = false;

    public Vector Setliuxing() throws SQLException {
        liuxing.setTitle("流行音乐");
        liuxing.setVisible(true);
        liuxing.setBounds(150, 150, 607, 700);
        liuxing.setResizable(false);
        liuxing.setLayout(null);

        Vector vl1 = new Vector();
        JDBC jdbc = new JDBC();
        vl1 = jdbc.findsort("流行");
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        liuxing.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(vl1);


        JButton l1 = new JButton("加入已点");
        liuxing.add(l1);
        l1.setBounds(80, 570, 125, 50);
        l1.setFont(new Font("黑体", Font.PLAIN, 18));

                l1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String str = (String) tAa1.getSelectedValue();
                        for(int i = 0; i < vsor.size();i++){
                            if(vsor.get(i).equals(str))
                                flag = true;
                            else
                                flag = false;
                        }
                        if (!flag) {
                            JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                            vsor.add(str);
                        } else
                            JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                        Splitstr splitstr = new Splitstr();
                        String songname = splitstr.getsongname(str);
                        String singername = splitstr.getsingername(str);
                        JDBC jdbc1 = new JDBC();
                        try {
                            jdbc1.Addrank(songname, singername);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
        });

        JButton l2 = new JButton("返回");
        liuxing.add(l2);
        l2.setBounds(360, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liuxing.dispose();
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });
         return vsor;
    }

    public Vector Setoumei() throws SQLException {
        oumei.setTitle("欧美音乐");
        oumei.setVisible(true);
        oumei.setBounds(150, 150, 607, 700);
        oumei.setLayout(null);
        oumei.setResizable(false);

        Vector vl1 = new Vector();
        JDBC jdbc = new JDBC();
        vl1 = jdbc.findsort("欧美");
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        oumei.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(vl1);


        JButton l1 = new JButton("加入已点");
        oumei.add(l1);
        l1.setBounds(80, 570, 125, 50);
        l1.setFont(new Font("黑体", Font.PLAIN, 18));
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                for(int i = 0; i < vsor.size();i++){
                    if(vsor.get(i).equals(str))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    vsor.add(str);
                } else
                    JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                Splitstr splitstr = new Splitstr();
                String songname = splitstr.getsongname(str);
                String singername = splitstr.getsingername(str);
                JDBC jdbc1 = new JDBC();
                try {
                    jdbc1.Addrank(songname, singername);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton l2 = new JButton("返回");
        oumei.add(l2);
        l2.setBounds(360, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oumei.dispose();
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });
          return vsor;
    }

    public Vector Setremen() throws SQLException {
        remen.setTitle("热门音乐");
        remen.setVisible(true);
        remen.setBounds(150, 150, 607, 700);
        remen.setLayout(null);
        remen.setResizable(false);

        Vector vl1 = new Vector();
        JDBC jdbc = new JDBC();
        vl1 = jdbc.findsort("热门");
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        remen.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(vl1);


        JButton l1 = new JButton("加入已点");
        remen.add(l1);
        l1.setBounds(80, 570, 125, 50);
        l1.setFont(new Font("黑体", Font.PLAIN, 18));
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                for(int i = 0; i < vsor.size();i++){
                    if(vsor.get(i).equals(str))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    vsor.add(str);
                } else
                    JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                Splitstr splitstr = new Splitstr();
                String songname = splitstr.getsongname(str);
                String singername = splitstr.getsingername(str);
                JDBC jdbc1 = new JDBC();
                try {
                    jdbc1.Addrank(songname, singername);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton l2 = new JButton("返回");
        remen.add(l2);
        l2.setBounds(360, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remen.dispose();
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });
          return vsor;
    }

    public Vector Setgudian() throws SQLException {
        gudian.setTitle("古典音乐");
        gudian.setVisible(true);
        gudian.setBounds(150, 150, 607, 700);
        gudian.setLayout(null);
        gudian.setResizable(false);

        Vector vl1 = new Vector();
        JDBC jdbc = new JDBC();
        vl1 = jdbc.findsort("古典");
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        gudian.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(vl1);


        JButton l1 = new JButton("加入已点");
        gudian.add(l1);
        l1.setBounds(80, 570, 125, 50);
        l1.setFont(new Font("黑体", Font.PLAIN, 18));
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                for(int i = 0; i < vsor.size();i++){
                    if(vsor.get(i).equals(str))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    vsor.add(str);
                } else
                    JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                Splitstr splitstr = new Splitstr();
                String songname = splitstr.getsongname(str);
                String singername = splitstr.getsingername(str);
                JDBC jdbc1 = new JDBC();
                try {
                    jdbc1.Addrank(songname, singername);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton l2 = new JButton("返回");
        gudian.add(l2);
        l2.setBounds(360, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gudian.dispose();
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });
         return vsor;
    }

    public Vector Setpiano() throws SQLException {
        piano.setTitle("钢琴曲");
        piano.setVisible(true);
        piano.setBounds(150, 150, 607, 700);
        piano.setLayout(null);
        piano.setResizable(false);

        Vector vl1 = new Vector();
        JDBC jdbc = new JDBC();
        vl1 = jdbc.findsort("钢琴");
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        piano.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(vl1);


        JButton l1 = new JButton("加入已点");
        piano.add(l1);
        l1.setBounds(80, 570, 125, 50);
        l1.setFont(new Font("黑体", Font.PLAIN, 18));
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                for(int i = 0; i < vsor.size();i++){
                    if(vsor.get(i).equals(str))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    vsor.add(str);
                } else
                    JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                Splitstr splitstr = new Splitstr();
                String songname = splitstr.getsongname(str);
                String singername = splitstr.getsingername(str);
                JDBC jdbc1 = new JDBC();
                try {
                    jdbc1.Addrank(songname, singername);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton l2 = new JButton("返回");
        piano.add(l2);
        l2.setBounds(360, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                piano.dispose();
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });
         return vsor;
    }

    public Vector Setold() throws SQLException {
        old.setTitle("经典老歌");
        old.setVisible(true);
        old.setBounds(150, 150, 607, 700);
        old.setLayout(null);
        old.setResizable(false);

        Vector vl1 = new Vector();
        JDBC jdbc = new JDBC();
        vl1 = jdbc.findsort("老歌");
        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        old.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(vl1);


        JButton l1 = new JButton("加入已点");
        old.add(l1);
        l1.setBounds(80, 570, 125, 50);
        l1.setFont(new Font("黑体", Font.PLAIN, 18));
        l1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                for(int i = 0; i < vsor.size();i++){
                    if(vsor.get(i).equals(str))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    vsor.add(str);
                } else
                    JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                Splitstr splitstr = new Splitstr();
                String songname = splitstr.getsongname(str);
                String singername = splitstr.getsingername(str);
                JDBC jdbc1 = new JDBC();
                try {
                    jdbc1.Addrank(songname, singername);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });


        JButton l2 = new JButton("返回");
        old.add(l2);
        l2.setBounds(360, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                old.dispose();
                Sortwin sortwin = new Sortwin();
                sortwin.Setsor();
            }
        });
          return vsor;
    }
}