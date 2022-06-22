package com.work.UserWin;

import com.work.AdminWin.Splitstr;
import com.work.Music.MusicPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Vector;

public class Playline extends JFrame {
    JPanel photo;
    JFrame playline = new JFrame();
  static   Vector vl1 = new Vector<>();
    static  Vector  already = new Vector<>();
    boolean flag = false;
    public Vector Setplayline() {
        playline.setTitle("已点歌曲");
        playline.setVisible(true);
        playline.setBounds(150, 150, 607, 700);
        playline.setLayout(null);
        playline.setResizable(false);
        playline.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

//        ImageIcon icon=new ImageIcon("D:/JavaHomeWork/file/play.jpg");
//        JLabel label = new JLabel(icon);//往一个标签中加入图片
//        label.setBounds(450, 120, 120,210);//设置标签位置大小，记得大小要和窗口一样大
//        playline.getLayeredPane().add(label, Integer.valueOf(Integer.MAX_VALUE));//标签添加到层面板


        JList tAa1 = new JList();
        JScrollPane bar1 = new JScrollPane(tAa1);
        playline.add(bar1);
        bar1.setBounds(0, 130, 600, 390);
        bar1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setFont(new Font("黑体", Font.PLAIN, 20));
        tAa1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vl1 = everysort.vsor;
        tAa1.setListData(vl1);
        MusicPlayer player = new MusicPlayer();
        final boolean[] first = {true};
        final boolean[] isplaying = {false};

        JPopupMenu popupMenu1 = new JPopupMenu();
        popupMenu1.setBounds(getX(), getY(), 30, 30);
        JMenuItem m1 = new JMenuItem("优先");
        m1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        JMenuItem m2 = new JMenuItem("删除");
        m2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
        popupMenu1.add(m1);
        popupMenu1.add(m2);

        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vl1.removeElementAt(tAa1.getSelectedIndex());
                //   everysort.vsor.removeElementAt(tAa1.getSelectedIndex());
                JOptionPane.showMessageDialog(null, "删除成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select = (String) tAa1.getSelectedValue();
                for (int i = tAa1.getSelectedIndex() - 1; i > -1; i--) {
                    tAa1.setSelectedIndex(i);
                    String str = (String) tAa1.getSelectedValue();
                    vl1.setElementAt(str, i + 1);
                }
                vl1.setElementAt(select, 0);
            }
        });


        JButton bk7 = new JButton();
        playline.add(bk7);
        ImageIcon imageIcon1 = new ImageIcon("D:/JavaHomeWork/file/pause.png");
        Image image1 = imageIcon1.getImage();
        Image smallImage1 = image1.getScaledInstance(80, 80, Image.SCALE_FAST);
        ImageIcon smallIcon1 = new ImageIcon(smallImage1);
        bk7.setIcon(smallIcon1);
        bk7.setContentAreaFilled(false);
        bk7.setBounds(255, 570, 80, 80);

        JButton bk8 = new JButton();
        playline.add(bk8);
        ImageIcon imageIcon2 = new ImageIcon("D:/JavaHomeWork/file/continue.png");
        Image image2 = imageIcon2.getImage();
        Image smallImage2 = image2.getScaledInstance(80, 80, Image.SCALE_FAST);
        ImageIcon smallIcon2 = new ImageIcon(smallImage2);
        bk8.setIcon(smallIcon2);
        bk8.setContentAreaFilled(false);
        bk8.setBounds(255, 570, 80, 80);  //375
        bk8.setVisible(false);


        tAa1.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
                    first[0] = false;
                    String str = (String) tAa1.getSelectedValue();
                    for (int i = 0; i < already.size(); i++) {
                        if (already.get(i).equals(str))
                            flag = true;
                    }
                    if (!flag)
                        already.add(str);
                    Splitstr getpath = new Splitstr();
                    String path = null;
                    try {
                        path = getpath.getpath(str);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    player.setMusicPath(path);
                    player.prefetch();
                    player.start(false);
                    isplaying[0] = true;
                    bk7.setVisible(true);
                    bk8.setVisible(false);
                }
                if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu1.show(tAa1, e.getX(), e.getY());
                }
            }
        });


        if (isplaying[0]) {
            bk7.setVisible(true);
            bk8.setVisible(false);
        } else {
            bk7.setVisible(false);
            bk8.setVisible(true);
        }

        bk7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bk7.setVisible(false);
                bk8.setVisible(true);
                player.stopMusic();
                isplaying[0] = false;
            }
        });

        bk8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = (String) tAa1.getSelectedValue();
                Splitstr getpath = new Splitstr();
                String path = null;
                try {
                    path = getpath.getpath(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                bk8.setVisible(false);
                bk7.setVisible(true);
                if (first[0]) {
                    player.setMusicPath(path);
                    player.prefetch();
                    player.stop();
                    player.start(false);
                    isplaying[0] = true;
                    first[0] = false;
                } else {
                    player.continueMusic();
                    isplaying[0] = true;
                }
                for (int i = 0; i < already.size(); i++) {
                    if (already.get(i).equals(str))
                        flag = true;
                }
                if (!flag)
                    already.add(str);
            }
        });

        if (isplaying[0]) {
            bk7.setVisible(true);
            bk8.setVisible(false);
        } else {
            bk7.setVisible(false);
            bk8.setVisible(true);
        }

        JButton bk9 = new JButton();
        playline.add(bk9);
        ImageIcon imageIcon3 = new ImageIcon("D:/JavaHomeWork/file/next.png");
        Image image3 = imageIcon3.getImage();
        Image smallImage3 = image3.getScaledInstance(80, 80, Image.SCALE_FAST);
        ImageIcon smallIcon3 = new ImageIcon(smallImage3);
        bk9.setIcon(smallIcon3);
        bk9.setContentAreaFilled(false);
        bk9.setBounds(370, 570, 80, 80);
        bk9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tAa1.setSelectedIndex(tAa1.getSelectedIndex() + 1);
                String str = (String) tAa1.getSelectedValue();
                Splitstr getpath = new Splitstr();
                String path = null;
                try {
                    path = getpath.getpath(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                //  player.stop();
                player.setMusicPath(path);
                player.prefetch();
                player.stop();
                player.start(false);
                for (int i = 0; i < already.size(); i++) {
                    if (already.get(i).equals(str))
                        flag = true;
                }
                if (!flag)
                    already.add(str);
            }
        });

        JButton bk10 = new JButton();
        playline.add(bk10);
        ImageIcon imageIcon4 = new ImageIcon("D:/JavaHomeWork/file/上一首.png");
        Image image4 = imageIcon4.getImage();
        Image smallImage4 = image4.getScaledInstance(80, 80, Image.SCALE_FAST);
        ImageIcon smallIcon4 = new ImageIcon(smallImage4);
        bk10.setIcon(smallIcon4);
        bk10.setContentAreaFilled(false);
        bk10.setBounds(140, 570, 80, 80);
        bk10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tAa1.setSelectedIndex(tAa1.getSelectedIndex() - 1);
                String str = (String) tAa1.getSelectedValue();
                Splitstr getpath = new Splitstr();
                String path = null;
                try {
                    path = getpath.getpath(str);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                player.setMusicPath(path);
                player.prefetch();
                player.stop();
                player.start(false);
                for (int i = 0; i < already.size(); i++) {
                    if (already.get(i).equals(str))
                        flag = true;
                }
                if (!flag)
                    already.add(str);
            }
        });

        playline.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                int flag = JOptionPane.showConfirmDialog(playline, "是否退出?",
                        "提示!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (JOptionPane.YES_OPTION == flag) {
                    player.stop();
                    playline.dispose();
                }
            }
        });
        return already;
    }

    public static void main(String[] args) {
        Playline playline = new Playline();
        playline.Setplayline();
    }
}