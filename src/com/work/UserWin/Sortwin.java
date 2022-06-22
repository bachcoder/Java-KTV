package com.work.UserWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Sortwin {
    JFrame sor =  new JFrame();
    public void Setsor(){
        sor.setTitle("分类点歌");
        sor.setVisible(true);
        sor.setBounds(150,150,690,520);
        sor.setResizable(false);
        sor.setLayout(null);

        JButton sb1 = new JButton();
        sor.add(sb1);
        sb1.setBounds(35,65,105,85);
        ImageIcon imageIcon1 = new ImageIcon("D:/JavaHomeWork/file/流行.png");
        Image image1 = imageIcon1.getImage();
        Image smallImage1 = image1.getScaledInstance(105, 70, Image.SCALE_FAST);
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        sb1.setIcon(smallIcon1);
        sb1.setContentAreaFilled(false);
        sb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               everysort sort = new everysort();
                try {
                    sort.Setliuxing();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sor.dispose();
            }
        });


        JLabel sl1 = new JLabel("流行");
        sor.add(sl1);
        sl1.setFont(new Font("黑体",Font.PLAIN,20));
        sl1.setBounds(65,135,85,65);


        JButton sb2 = new JButton();
        sor.add(sb2);
        sb2.setBounds(275,65,105,85);
        ImageIcon imageIcon2 = new ImageIcon("D:/JavaHomeWork/file/欧美.png");
        Image image2 = imageIcon2.getImage();
        Image smallImage2 = image2.getScaledInstance(105, 70, Image.SCALE_FAST);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        sb2.setIcon(smallIcon2);
        sb2.setContentAreaFilled(false);
        sb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                everysort sort = new everysort();
                try {
                    sort.Setoumei();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sor.dispose();
            }
        });

        JLabel sl2 = new JLabel("欧美");
        sor.add(sl2);
        sl2.setFont(new Font("黑体",Font.PLAIN,20));
        sl2.setBounds(305,135,85,65);


        JButton sb3 = new JButton();
        sor.add(sb3);
        sb3.setBounds(495,65,105,85);
        ImageIcon imageIcon3 = new ImageIcon("D:/JavaHomeWork/file/热门歌曲.png");
        Image image3 = imageIcon3.getImage();
        Image smallImage3 = image3.getScaledInstance(105, 70, Image.SCALE_FAST);
        ImageIcon smallIcon3 = new ImageIcon(smallImage3);
        sb3.setIcon(smallIcon3);
        sb3.setContentAreaFilled(false);
        sb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                everysort sort = new everysort();
                try {
                    sort.Setremen();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sor.dispose();
            }
        });

        JLabel sl3 = new JLabel("热门歌曲");
        sor.add(sl3);
        sl3.setFont(new Font("黑体",Font.PLAIN,20));
        sl3.setBounds(510,135,85,65);

        JButton sb4 = new JButton();
        sor.add(sb4);
        sb4.setBounds(35,265,105,85);
        ImageIcon imageIcon4 = new ImageIcon("D:/JavaHomeWork/file/古典 .png");
        Image image4 = imageIcon4.getImage();
        Image smallImage4 = image4.getScaledInstance(105, 75, Image.SCALE_FAST);
        ImageIcon smallIcon4 = new ImageIcon(smallImage4);
        sb4.setIcon(smallIcon4);
        sb4.setContentAreaFilled(false);
        sb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                everysort sort = new everysort();
                try {
                    sort.Setgudian();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sor.dispose();
            }
        });

        JLabel sl4 = new JLabel("古典");
        sor.add(sl4);
        sl4.setFont(new Font("黑体",Font.PLAIN,20));
        sl4.setBounds(65,335,85,65);

        JButton sb5 = new JButton();
        sor.add(sb5);
        sb5.setBounds(275,265,105,85);
        ImageIcon imageIcon5 = new ImageIcon("D:/JavaHomeWork/file/钢琴曲.png");
        Image image5 = imageIcon5.getImage();
        Image smallImage5 = image5.getScaledInstance(105, 75, Image.SCALE_FAST);
        ImageIcon smallIcon5 = new ImageIcon(smallImage5);
        sb5.setIcon(smallIcon5);
        sb5.setContentAreaFilled(false);
        sb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                everysort sort = new everysort();
                try {
                    sort.Setgudian();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sor.dispose();
            }
        });

        JLabel sl5 = new JLabel("钢琴曲");
        sor.add(sl5);
        sl5.setFont(new Font("黑体",Font.PLAIN,20));
        sl5.setBounds(295,335,85,65);

        JButton sb6 = new JButton();
        sor.add(sb6);
        sb6.setBounds(495,265,105,85);
        ImageIcon imageIcon6 = new ImageIcon("D:/JavaHomeWork/file/经典老歌.png");
        Image image6 = imageIcon6.getImage();
        Image smallImage6 = image6.getScaledInstance(105, 75, Image.SCALE_FAST);
        ImageIcon smallIcon6 = new ImageIcon(smallImage6);
        sb6.setIcon(smallIcon6);
        sb6.setContentAreaFilled(false);
        sb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                everysort sort = new everysort();
                try {
                    sort.Setpiano();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                sor.dispose();
            }
        });

        JLabel sl6 = new JLabel("经典老歌");
        sor.add(sl6);
        sl6.setFont(new Font("黑体",Font.PLAIN,20));
        sl6.setBounds(505,335,85,65);

    }
}
