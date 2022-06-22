package com.work.AdminWin;

import com.work.login.JDBC;

import java.sql.SQLException;

public class Splitstr {
    public String getpath(String str) throws SQLException {
        String songname;
        String singername;
        String [] res = str.split("\\s+");
        songname  = res[0];
        singername = res[1];
     //   System.out.println(songname);
      //  System.out.println(singername);
        JDBC getpath = new JDBC();
       String playpath =  getpath.getpath(songname,singername);
//       PlayMusic playMusic = new PlayMusic();
//       playMusic.Playmusic(playpath);
        return playpath;
    }

    public String getsongname(String str){
        String songname;
        String [] res = str.split("\\s+");
        songname  = res[0];
        return  songname;
    }
    public String getsingername(String str){
        String singername;
        String [] res = str.split("\\s+");
        singername = res[1];
        return  singername;
    }

    public String getinfo(String str)  {
        String songname;
        String singername;
        String songstyle;
        String [] res = str.split("\\s+");
        songname  = res[0];
        singername = res[1];
        songstyle = res[2];
        return songname + " " + singername+ " " + songstyle;
    }


}
