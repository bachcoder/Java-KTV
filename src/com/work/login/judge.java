package com.work.login;

import javax.swing.*;
import java.sql.SQLException;

public class judge {
    JDBC record = new JDBC();
   boolean flag1  = false;
   public void AccountJudge(String str1 ,String str2 ,String str3) throws SQLException {
      // System.out.println(str1+" "+str2 +" "+str3);
       String regex1 = "^[A-Za-z0-9]+$";
       flag1 = str1.matches(regex1);
       boolean flag2 = record.Findinfo(str1);
       if(!flag2)
           JOptionPane.showMessageDialog(null, "用户名已存在!","出错了",JOptionPane.ERROR_MESSAGE);
       if(!flag1||str1.length()>8)
           JOptionPane.showMessageDialog(null, "非法用户名!","出错了",JOptionPane.ERROR_MESSAGE);
       if(!str2.equals(str3))
           JOptionPane.showMessageDialog(null, "两次密码不一致!","出错了",JOptionPane.ERROR_MESSAGE);
       if(str2.equals(""))
           JOptionPane.showMessageDialog(null, "密码不能为空!","出错了",JOptionPane.ERROR_MESSAGE);
      if(flag1&&str1.length()<=8&&str2.equals(str3)&&!str2.equals("")&&flag2){
          record.addAccountNumber(str1, str2);
          JOptionPane.showMessageDialog(null, "注册成功!","提示",JOptionPane.INFORMATION_MESSAGE);
       }
   }
}
