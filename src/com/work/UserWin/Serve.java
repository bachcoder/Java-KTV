package com.work.UserWin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Serve extends JFrame {
    JFrame serve;
    JButton b01;
    JButton b02;
    JButton b03;
    JButton b04;
    JScrollPane jScrollPane01;
    JScrollPane jScrollPane02;
    JPanel jp;                                                 //面板
    JList jli1;
    JList jli2;                                                //列表
    JTabbedPane jtp = new JTabbedPane();                       //选项卡
    public void beverageservice(){
        serve = new JFrame("酒水服务");
        b01 = new JButton("请求服务");
        b02 = new JButton("返回");
        b03 = new JButton("查看消费时间");
        b04 = new JButton("收费标准");
        jp = new JPanel();
        String[] str1 = {"小果盘 10 元/份", "中果盘 15 元/份", "精品大果盘 25 元/份", "薯片 6 元/包", "烤肠 4 元/根",
                "凉面 10 元/份", "凉粉 10 元/份", "小火锅 45 元/份", "鸡排 8 元/份", "鸡腿 7 元/只", "辣条 3 元/包"};
        String[] str2 = {"百威啤酒 20 元/瓶", "蓝马啤酒 20 元/瓶", "汉斯干啤 15 元/瓶", "干红葡萄酒 80 元/瓶",
                "二锅头 40 元/瓶", "果粒橙 5 元/瓶", "可口可乐 5 元/瓶", "百事可乐 5 元/瓶"};
        jli1 = new JList(str1);
        jli2 = new JList(str2);
        jli1.setFont(new Font("黑体",Font.PLAIN,16));
        jli2.setFont(new Font("黑体",Font.PLAIN,16));
        jScrollPane01 = new JScrollPane(jli1);
        jScrollPane02 = new JScrollPane(jli2);
        serve.setLayout(null);
        GridLayout gridLayout = new GridLayout(2,2);
        gridLayout.setVgap(15);
        gridLayout.setHgap(5);
        jp.setLayout(gridLayout);
        serve.setBounds(300,100,490,650);
        jp.add(b01);
        jp.add(b02);
        jp.add(b03);
        jp.add(b04);
        jtp.add("食品",jScrollPane01);
        jtp.add("酒水饮料",jScrollPane02);
        jtp.setBounds(0,100,470,370);
        jp.setBounds(35,500,400,100);
        serve.add(jtp);
        serve.add(jp);
        serve.setVisible(true);
        serve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jli1.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
                    JOptionPane.showMessageDialog(null, "服务员稍后送餐!","购买成功", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        b02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serve.dispose();
            }
        });
        jli2.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
                    JOptionPane.showMessageDialog(null, "服务员稍后送餐!","购买成功", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        b03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime dateTime2 = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String now = dateTime2.format(formatter);
                Duration duration = Duration.between(UserWin.dateTime1, dateTime2);
                long hours = duration.toHours();
                long minutes= duration.toMinutes();
                long seconds = duration.getSeconds();
                JOptionPane.showMessageDialog(null, "开始时间:"+UserWin.logtime+"\n"+"当前时间:"+now+"\n"+"消费时间:"+hours+"小时"+minutes%60+"分钟"+seconds%60+"秒","消费时间", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        b01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "服务员已收到请求!","呼叫成功", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        b04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "玲珑包:99元两小时\n小包:159元三小时\n中包:229元四小时\n大包:329元五小时\n商务包:499元六小时\n总统包:899元一天内不限时","收费标准", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }
}
