package com.work.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class register extends JFrame {
    public register(){
        setTitle("注册账号");
        setBounds(630,300,400,600);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel imPanel=(JPanel) this.getContentPane();//注意内容面板必须强转为JPanel才可以实现下面的设置透明
        imPanel.setOpaque(false);//将内容面板设为透明
        ImageIcon icon=new ImageIcon("D:/JavaHomeWork/file/p2.jpg");
        JLabel label = new JLabel(icon);//往一个标签中加入图片
        label.setBounds(0, 0, 400,600);//设置标签位置大小，记得大小要和窗口一样大
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));//标签添加到层面板

        setLayout(null);


        JLabel ar1 = new JLabel("用户名:");
        add(ar1);
        ar1.setBounds(75,110,75,25);
        ar1.setFont(new Font("黑体",Font.PLAIN,18));

        JLabel ar2 = new JLabel("(用户名由数字或字母组成,长度不超过8个字符)");
        add(ar2);
        ar2.setBounds(75,140,275,25);
        ar2.setFont(new Font("黑体",Font.PLAIN,13));

        JLabel ar3 = new JLabel(" 密码:");
        add(ar3);
        ar3.setBounds(75,170,75,25);
        ar3.setFont(new Font("黑体",Font.PLAIN,18));

        JLabel ar4 = new JLabel("再次输入密码:");
        add(ar4);
        ar4.setBounds(20,210,125,25);
        ar4.setFont(new Font("黑体",Font.PLAIN,18));

        JTextField tr1 = new JTextField();
        add(tr1);
        tr1.setBounds(145,110,180,25);

        Panel panel1 = new Panel(null);
        add(panel1);


        JPasswordField tr2 = new JPasswordField();
        add(tr2);
        tr2.setEchoChar('●');
        tr2.setBounds(145,170,180,25);

        JPasswordField tr3 = new JPasswordField();
        add(tr3);
        tr3.setEchoChar('●');
        tr3.setBounds(145,210,180,25);

        JButton br1 = new JButton("注册");
        add(br1);
        br1.setBounds(175,300,75,40);
        br1.setFont(new Font("黑体",Font.PLAIN,15));
        br1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String r1 =tr1.getText();
                String r2 =tr2.getText();
                String r3 =tr3.getText();
                judge rr1 = new judge();
                try {
                    rr1.AccountJudge(r1,r2,r3);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
