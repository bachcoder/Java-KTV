package com.work.UserWin;

import com.work.AdminWin.Splitstr;
import com.work.login.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class LanguageSearch {


    static   Vector v3 = new Vector();
    public JFrame frame;
    boolean flag = false;
    public LanguageSearch() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setTitle("语别点歌");
        frame.setBounds(100, 100, 537, 620);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

//        JPanel panel = new JPanel();
//        frame.getContentPane().add(panel, BorderLayout.CENTER);
//        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("语  别  点  歌");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 28));
        lblNewLabel.setBounds(150, 10, 250, 76);
        frame.add(lblNewLabel);

        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        frame.add(bar1);
        bar1.setBounds(0, 85, 532, 320);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tAa1.setListData(v3);
//        list.addMouseListener(new MouseAdapter(){
//
//        });

        JButton b1 = new JButton("华  语");
        b1.setFont(new Font("宋体", Font.BOLD, 18));
        b1.setToolTipText("");
        b1.setBounds(20, 430, 110, 70);
        frame.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC jdbc = new JDBC();
                try {
                    v3 =  jdbc.language("华语");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                tAa1.setListData(v3);
            }
        });

        JButton b2 = new JButton("英  语");
        b2.setFont(new Font("宋体", Font.BOLD, 18));
        b2.setBounds(140, 430, 110, 70);
        frame.add(b2);

        JButton b3 = new JButton("日  语");
        b3.setFont(new Font("宋体", Font.BOLD, 18));
        b3.setBounds(260, 430, 110, 70);
        frame.add(b3);

        JButton b4 = new JButton("韩  语");
        b4.setFont(new Font("宋体", Font.BOLD, 18));
        b4.setBounds(380, 430, 110, 70);
        frame.add(b4);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC jdbc = new JDBC();
                try {
                    v3 =  jdbc.language("英语");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                tAa1.setListData(v3);
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC jdbc = new JDBC();
                try {
                    v3 =  jdbc.language("日语");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                tAa1.setListData(v3);
            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC jdbc = new JDBC();
                try {
                    v3 =  jdbc.language("韩语");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                tAa1.setListData(v3);
            }
        });

        JButton b5 = new JButton("返回");
        b5.setFont(new Font("宋体", Font.BOLD, 18));
        b5.setBounds(210, 510, 100, 50);
        frame.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JButton b6 = new JButton("加入已点");
        frame.add(b6);
        b6.setBounds(75,510,105,50);
        b6.setFont(new Font("宋体",Font.BOLD,16));
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                for(int i = 0; i < Playline.vl1.size();i++){
                    if(Playline.vl1.get(i).equals(str))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    Playline.vl1.add(str);
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


    }

}