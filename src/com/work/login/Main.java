package com.work.login;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginwin login = new loginwin();
    }
}
