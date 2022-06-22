package com.work.UserWin;

import com.work.AdminWin.Splitstr;
import com.work.login.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class ranking {


    static Vector v4 = new Vector();
    public static javax.swing.JOptionPane JOptionPane;
    public JFrame frame;
    boolean flag = false;

    public ranking() throws SQLException {
        initialize();
    }

    public void initialize() throws SQLException {
        frame = new JFrame();
        frame.setTitle("~~点唱排行~~");
        frame.setBounds(100, 100, 650, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(null);

        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        frame.add(bar1);
        bar1.setBounds(0, 80, 647, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JDBC jdbc = new JDBC();
        v4 = jdbc.rank();
        tAa1.setListData(v4);

        JLabel lblNewLabel = new JLabel("点 唱 排 行");
        lblNewLabel.setFont(new Font("宋体", Font.BOLD, 28));
        lblNewLabel.setBounds(230, 0, 200, 70);
        frame.add(lblNewLabel);

        JButton b1 = new JButton("加入已点");
        b1.setBounds(120, 505, 140, 50);
        frame.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                Splitstr splitstr2 = new Splitstr();
               String str2 =  splitstr2.getinfo(str);
                for(int i = 0; i < Playline.vl1.size();i++){
                    if(Playline.vl1.get(i).equals(str2))
                        flag = true;
                    else
                        flag = false;
                }
                if (!flag) {
                    JOptionPane.showMessageDialog(null, "添加成功!","提示", JOptionPane.INFORMATION_MESSAGE);
                    Playline.vl1.add(str2);
                } else
                    JOptionPane.showMessageDialog(null, "已经在列表中!", "提示", JOptionPane.INFORMATION_MESSAGE);
                Splitstr splitstr = new Splitstr();
                String songname = splitstr.getsongname(str2);
                String singername = splitstr.getsingername(str2);
                JDBC jdbc1 = new JDBC();
                try {
                    jdbc1.Addrank(songname, singername);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton b2 = new JButton("返回");
        b2.setBounds(420, 505, 140, 50);
        frame.add(b2);

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  frame.dispose();
            }
        });
    }
}
