package com.work.AdminWin;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class OpenFile {
    public String open() {
        FileNameExtensionFilter filter=new FileNameExtensionFilter("WAV","wav");
        JFileChooser file=new JFileChooser("D:/JavaHomeWork");
        //设置一个文件筛选器
        file.setFileFilter(filter);
        //下面这句是去掉显示所有文件这个过滤器。
        file.setAcceptAllFileFilterUsed(false);
    /*使用showOpenDialog()方法，显示出打开选择文件的窗口，当选择了某个文件后，或者关闭此窗口那么都会返回一个
    整型数值，如果返回的是0，代表已经选择了某个文件。如果返回1代表选择了取消按钮或者直接关闭了窗口*/
        int result = file.showOpenDialog(null);
        //JFileChooser.APPROVE_OPTION是个整型常量，代表0。就是说当返回0的值我们才执行相关操作，否则什么也不做。
        if(result == JFileChooser.APPROVE_OPTION){
            //获得选择的文件绝对路径。
            String path = file.getSelectedFile().getAbsolutePath();
            return path;
        }
        return null;

    }

    public String open_2() {
        FileNameExtensionFilter filter=new FileNameExtensionFilter("图片","jpeg","png","jpg");
        JFileChooser file=new JFileChooser();
        //设置一个文件筛选器
        file.setFileFilter(filter);
        //下面这句是去掉显示所有文件这个过滤器。
        file.setAcceptAllFileFilterUsed(false);
    /*使用showOpenDialog()方法，显示出打开选择文件的窗口，当选择了某个文件后，或者关闭此窗口那么都会返回一个
    整型数值，如果返回的是0，代表已经选择了某个文件。如果返回1代表选择了取消按钮或者直接关闭了窗口*/
        int result = file.showOpenDialog(null);
        //JFileChooser.APPROVE_OPTION是个整型常量，代表0。就是说当返回0的值我们才执行相关操作，否则什么也不做。
        if(result == JFileChooser.APPROVE_OPTION){
            //获得选择的文件绝对路径。
            String path = file.getSelectedFile().getAbsolutePath();
            return path;
        }
        return null;
    }
}
