package com.work.AdminWin;

import com.work.login.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

public class AddSong extends JFrame {
    JFrame as  = new JFrame();
    JFrame asr = new JFrame();
    public void SetAddSong(){
        as.setTitle("添加歌曲");
        as.setVisible(true);
        as.setBounds(150,150,550,600);
        as.setLayout(null);

        JLabel al1 = new JLabel("歌曲名:");
        as.add(al1);
        al1.setFont(new Font("黑体",Font.PLAIN,20));
        al1.setBounds(60,30,85,65);

        JLabel al2 = new JLabel("  歌手:");
        as.add(al2);
        al2.setFont(new Font("黑体",Font.PLAIN,20));
        al2.setBounds(60,100,85,65);


        JLabel al3 = new JLabel("歌曲语种:");
        as.add(al3);
        al3.setFont(new Font("黑体",Font.PLAIN,20));
        al3.setBounds(40,170,105,65);

        JLabel al4 = new JLabel("歌曲风格:");
        as.add(al4);
        al4.setFont(new Font("黑体",Font.PLAIN,20));
        al4.setBounds(40,240,105,65);

        JLabel al5 = new JLabel("歌曲名缩写:");
        as.add(al5);
        al5.setFont(new Font("黑体",Font.PLAIN,20));
        al5.setBounds(20,310,125,65);

        JLabel al6 = new JLabel("  资源:");
        as.add(al6);
        al6.setFont(new Font("黑体",Font.PLAIN,20));
        al6.setBounds(60,380,85,65);

        JLabel al7 = new JLabel("  分类:");
        as.add(al7);
        al7.setFont(new Font("黑体",Font.PLAIN,20));
        al7.setBounds(60,450,85,65);

        JTextField at1 = new JTextField();
        as.add(at1);
        at1.setBounds(140,48,250,30);
        at1.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at2 = new JTextField();
        as.add(at2);
        at2.setBounds(140,118,250,30);
        at2.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at3 = new JTextField();
        as.add(at3);
        at3.setBounds(140,188,250,30);
        at3.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at4 = new JTextField();
        as.add(at4);
        at4.setBounds(140,258,250,30);
        at4.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at5 = new JTextField();
        as.add(at5);
        at5.setBounds(140,328,250,30);
        at5.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at6 = new JTextField();
        as.add(at6);
        at6.setBounds(140,398,250,30);
        at6.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at7 = new JTextField();
        as.add(at7);
        at7.setBounds(140,468,250,30);
        at7.setFont(new Font("黑体",Font.PLAIN,18));


        JButton asb1 = new JButton("浏览文件");
        as.add(asb1);
        asb1.setBounds(400,398,120,30);
        asb1.setFont(new Font("黑体",Font.PLAIN,18));
        asb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenFile openFile = new OpenFile();
                String paths  = openFile.open();
                at6.setText(paths);
            }
        });

        JButton asb2 = new JButton("添加");
        as.add(asb2);
        asb2.setBounds(120,505,100,35);
        asb2.setFont(new Font("黑体",Font.PLAIN,18));
        asb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String r1 = at1.getText();
                String r2 = at2.getText();
                String r3 = at3.getText();
                String r4 = at4.getText();
                String r5 = at5.getText();
                String r6 = at6.getText();
                String r7 = at7.getText();
                boolean fexit = true;
                boolean findsong = false;
                File songpath = new File(r6);
                fexit = songpath.exists();
                if (r1.equals("") || r2.equals("") || r3.equals("") || r4.equals("") || r5.equals("") || r6.equals("")||r7.equals(""))
                    JOptionPane.showMessageDialog(null, "信息未填写完整!", "出错了", JOptionPane.ERROR_MESSAGE);
                 if(!fexit)
                    JOptionPane.showMessageDialog(null, "路径不存在!", "出错了", JOptionPane.ERROR_MESSAGE);
                    JDBC addsong = new JDBC();
                try {
                   findsong =  addsong.findsonginfo(r1,r2);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if(findsong&&fexit) {
                    try {
                        addsong.AddSonginfo(r1, r2, r3, r4, r5, r6, r7);
                        JOptionPane.showMessageDialog(null, "添加成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if(!findsong)
                    JOptionPane.showMessageDialog(null, "歌曲已存在!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
        });

        JButton asb3 = new JButton("重置");
        as.add(asb3);
        asb3.setBounds(300,505,100,35);
        asb3.setFont(new Font("黑体",Font.PLAIN,18));
        asb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                at1.setText("");
                at2.setText("");
                at3.setText("");
                at4.setText("");
                at5.setText("");
                at6.setText("");
            }
        });

    }

    public void SetaddSinger(){
        asr.setTitle("添加歌手");
        asr.setVisible(true);
        asr.setBounds(150,150,550,500);
        asr.setLayout(null);

        JLabel al1 = new JLabel("歌手名:");
        asr.add(al1);
        al1.setFont(new Font("黑体",Font.PLAIN,20));
        al1.setBounds(60,30,85,65);

        JLabel al2 = new JLabel("歌手地区:");
        asr.add(al2);
        al2.setFont(new Font("黑体",Font.PLAIN,20));
        al2.setBounds(40,100,125,65);

        JLabel al3 = new JLabel("歌手名缩写:");
        asr.add(al3);
        al3.setFont(new Font("黑体",Font.PLAIN,20));
        al3.setBounds(20,170,125,65);

        JLabel al4 = new JLabel("海报:");
        asr.add(al4);
        al4.setFont(new Font("黑体",Font.PLAIN,20));
        al4.setBounds(80,240,125,65);

        JTextField at1 = new JTextField();
        asr.add(at1);
        at1.setBounds(140,48,250,30);
        at1.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at2 = new JTextField();
        asr.add(at2);
        at2.setBounds(140,118,250,30);
        at2.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at3 = new JTextField();
        asr.add(at3);
        at3.setBounds(140,188,250,30);
        at3.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField at4 = new JTextField();
        asr.add(at4);
        at4.setBounds(140,258,250,30);
        at4.setFont(new Font("黑体",Font.PLAIN,18));

        JButton asb1 = new JButton("浏览文件");
        asr.add(asb1);
        asb1.setBounds(400,258,110,30);
        asb1.setFont(new Font("黑体",Font.PLAIN,18));
        asb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenFile openFile = new OpenFile();
                String paths  = openFile.open_2();
                at4.setText(paths);
            }
        });

        JButton asb2 = new JButton("添加");
        asr.add(asb2);
        asb2.setBounds(115,348,110,32);
        asb2.setFont(new Font("黑体",Font.PLAIN,18));
        asb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String r1 = at1.getText();
                String r2 = at2.getText();
                String r3 = at3.getText();
                String r4 = at4.getText();
                boolean fexit = true;
                boolean findsinger = false;
                File songpath = new File(r4);
                fexit = songpath.exists();
                if (r1.equals("") || r2.equals("") || r3.equals("") || r4.equals(""))
                    JOptionPane.showMessageDialog(null, "信息未填写完整!", "出错了", JOptionPane.ERROR_MESSAGE);
                 if(!fexit)
                    JOptionPane.showMessageDialog(null, "路径不存在!", "出错了", JOptionPane.ERROR_MESSAGE);

                    JDBC addsong = new JDBC();
                try {
                   findsinger = addsong.findsingerinfo(r1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if(findsinger&&fexit) {
                    try {
                        addsong.AddSingerinfo(r1, r2, r3, r4);
                        JOptionPane.showMessageDialog(null, "添加成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if(!findsinger)
                    JOptionPane.showMessageDialog(null, "歌手已存在!", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton asb3 = new JButton("重置");
        asr.add(asb3);
        asb3.setBounds(320,348,110,32);
        asb3.setFont(new Font("黑体",Font.PLAIN,18));
        asb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                at1.setText("");
                at2.setText("");
                at3.setText("");
                at4.setText("");
            }
        });



    }
}

