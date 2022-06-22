package com.work.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class loginwin  extends JFrame  {
    public  loginwin(){
        setTitle("登录界面");
        setBounds(550,370,600,500);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        JPanel imPanel=(JPanel) this.getContentPane();//注意内容面板必须强转为JPanel才可以实现下面的设置透明
        imPanel.setOpaque(false);//将内容面板设为透明
        ImageIcon icon=new ImageIcon("D:/JavaHomeWork/file/p1.jpg");
        JLabel label = new JLabel(icon);//往一个标签中加入图片
        label.setBounds(0, 0, 600,500);//设置标签位置大小，记得大小要和窗口一样大
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));//标签添加到层面板

        setLayout(null);

        JRadioButton rab1 = new JRadioButton("用户");
        add(rab1);
        rab1.setBounds(240,190,75,25);
        rab1.setFont(new Font("黑体",Font.PLAIN,16));
        rab1.setOpaque(false);

        JRadioButton rab2 = new JRadioButton("管理员");
        add(rab2);
        rab2.setBounds(310,190,125,25);
        rab2.setFont(new Font("黑体",Font.PLAIN,16));
        rab2.setOpaque(false);

        ButtonGroup groupRa = new ButtonGroup();
        groupRa.add(rab1);
        groupRa.add(rab2);

        JLabel a1 = new JLabel("用户名:");
        add(a1);
        a1.setBounds(160,100,75,25);
        a1.setFont(new Font("黑体",Font.PLAIN,18));

        JLabel a2 = new JLabel(" 密码:");
        add(a2);
        a2.setBounds(160,145,75,25);
        a2.setFont(new Font("黑体",Font.PLAIN,18));

        JLabel a3 = new JLabel("登录身份:");
        add(a3);
        a3.setBounds(160,188,75,25);
        a3.setFont(new Font("黑体",Font.PLAIN,16));


        JTextField t1 = new JTextField();
        add(t1);
        t1.setBounds(225,100,180,25);

        JPasswordField t2 = new JPasswordField();
        add(t2);
        t2.setEchoChar('●');
        t2.setBounds(225,145,180,25);

        JButton b1 = new JButton("登录");
        add(b1);
        b1.setBounds(200,220,75,40);
        b1.setFont(new Font("黑体",Font.PLAIN,15));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = t1.getText();
                String pass = t2.getText();
                logface log = new logface();
                boolean raflag = false;
                if (rab1.isSelected()) {
                    raflag = true;
                    try {
                     log.loginwindow(number, pass);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if (rab2.isSelected()) {
                    raflag = true;
                    try {
                        log.loginwindow_2(number, pass);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                if (!raflag) {
                    JOptionPane.showMessageDialog(null, "请选择你的身份!", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        JButton b2 = new JButton("注册");
        add(b2);
        b2.setBounds(340,220,75,40);
        b2.setFont(new Font("黑体",Font.PLAIN,15));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              register reg =  new register();
            }
        });
    }
}
