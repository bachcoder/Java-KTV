package com.work.UserWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class already {
JFrame already = new JFrame();
    Vector v = new Vector();
    public void Setalready() {
        already.setTitle("已播音乐");
        already.setVisible(true);
        already.setBounds(150, 150, 607, 700);
        already.setLayout(null);
        already.setResizable(false);

        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        already.add(bar1);
        bar1.setBounds(0, 130, 600, 420);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        v = Playline.already ;
        tAa1.setListData(v);


        JButton l2 = new JButton("退出查看");
        already.add(l2);
        l2.setBounds(230, 570, 115, 50);
        l2.setFont(new Font("黑体", Font.PLAIN, 18));
        l2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                already.dispose();
            }
        });
    }

    public static void main(String[] args) {
        com.work.UserWin.already already = new already();
        already.Setalready();
    }

}