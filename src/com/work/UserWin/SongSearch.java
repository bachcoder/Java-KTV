package com.work.UserWin;

import com.work.AdminWin.Splitstr;
import com.work.login.JDBC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class SongSearch extends JFrame {
    JFrame playersearch = new JFrame("拼音点歌");
    JPanel jp01 = new JPanel();//面板1，装字母
    JPanel jp02 = new JPanel();//面板2，装搜索框
    JPanel jp03 = new JPanel();//面板3，装列表
    JLabel jlabel = new JLabel("歌曲名首字母");
    JTextField jt = new JTextField(10);//文本框
    JButton button1 = new JButton("退格");
    JButton button2 = new JButton("清除");
    JButton button3 = new JButton("返回");
    JButton add = new JButton("加入歌单");
    boolean flag = false;
   static Vector v = new Vector();

    public void palyersearch() {
        GridLayout grid = new GridLayout(3, 9);//网格布局
        grid.setHgap(8);
        grid.setVgap(10);
//        FlowLayout flow = new FlowLayout();//流布局
        jp01.setLayout(grid);//面板1使用网格布局
        jp02.setLayout(null);//面板2使用流布局
        jp03.setLayout(null);
        jlabel.setBounds(10,2,80,30);
        jt.setBounds(90,2,155,30);
        button1.setBounds(255,2,60,30);
        button2.setBounds(330,2,60,30);
        button3.setBounds(405,2,60,30);
        add.setBounds(175,25,105,65);
        add.setFont(new Font("黑体",Font.PLAIN,16));
        playersearch.add(add);


        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        jp03.add(bar1);
        bar1.setBounds(0, 0, 480, 210);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        String[][] names = { { "A", "B", "C", "D","E","F","G","H","I"},
                { "J", "K", "L", "M","N", "O", "P", "Q","R" }, { "S", "T", "U", "V","W", "X", "Y", "Z","-"} };
        JButton[][] buttons = new JButton[3][9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                buttons[row][col] = new JButton(names[row][col]); // 创建按钮对象
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton button = (JButton) e.getSource();
                        String text = jt.getText();
                        jt.setText(text + button.getText());
                     String suoxie  = ("%"+jt.getText()+"%");
                     String s = jt.getText();
                        JDBC jdbc  = new JDBC();
                        try {
                            v = jdbc.songsearch(suoxie,s);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        tAa1.setListData(v);
                    }
                });
                jp01.add(buttons[row][col]); // 将按钮添加到面板中
            }
        }

        add.addActionListener(new ActionListener() {
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

        jp02.add(jlabel);
        jp02.add(jt);
        jp02.add(button1);
        jp02.add(button2);
        jp02.add(button3);
     //   jlist.setBounds(0, 0, 480, 210);
        tAa1.setListData(v);
        playersearch.setLayout(null);//窗口设为空布局
        playersearch.setBounds(300, 100, 490, 650);
        playersearch.add(jp01);
        playersearch.add(jp02);
        playersearch.add(jp03);
        jp01.setBounds(1, 330, 474, 200);
        jp02.setBounds(0, 550, 490, 250);
        jp03.setBounds(0, 100, 478, 388);


        button1.addActionListener(new ActionListener() {                    //点击button1时文本退格
            public void actionPerformed(ActionEvent arg0) {
                if (!jt.getText().equals("")) {
                    String str1 = jt.getText();
                    str1 = str1.substring(0, str1.length() - 1);
                    jt.setText(str1);
                    String suoxie = ("%" + jt.getText() + "%");
                    String s = jt.getText();
                    JDBC jdbc = new JDBC();
                    try {
                        v = jdbc.songsearch(suoxie, s);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    tAa1.setListData(v);
                }
            }
        });

        button2.addActionListener(new ActionListener() {                    //点击button2时文本清除
            public void actionPerformed(ActionEvent arg0) {
                jt.setText("");
            }
        });

        button3.addActionListener(new ActionListener() {                    //点击button2时关闭窗口
            public void actionPerformed(ActionEvent arg0) {
               playersearch.dispose();
            }
        });

        playersearch.setVisible(true);
        playersearch.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}