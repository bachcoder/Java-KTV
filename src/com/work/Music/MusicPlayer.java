package com.work.Music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
     protected String musicPath; //音频文件
     protected volatile boolean run = true; //记录音频是否播放
     protected Thread mainThread;  //播放音频的任务线程

     protected AudioInputStream audioStream;
     protected AudioFormat audioFormat;
     protected SourceDataLine sourceDataLine;


    public void setMusicPath(String path){
        this.musicPath = path;
    }

    //数据准备
    public void prefetch(){
        try{
            synchronized(this) {
                run = true;
            }
            //获取音频输入流
            audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
            //获取音频的编码对象
            audioFormat = audioStream.getFormat();
            //包装音频信息
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class,
                    audioFormat,AudioSystem.NOT_SPECIFIED);
            //使用包装音频信息后的Info类创建源数据行，充当混频器的源
            sourceDataLine = (SourceDataLine)AudioSystem.getLine(dataLineInfo);

            sourceDataLine.open(audioFormat);
            sourceDataLine.start();

        }catch(UnsupportedAudioFileException ex){
            ex.printStackTrace();
        }catch(LineUnavailableException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
//    //析构函数:关闭音频读取流和数据行
//    public void finalize() throws Throwable{
//        super.finalize();
//        sourceDataLine.drain();
//        sourceDataLine.close();
//        audioStream.close();
//    }

    //播放音频:通过loop参数设置是否循环播放
    public void playMusic(boolean loop)throws InterruptedException {
        try{
            if(loop){
                while(true){
                    playMusic();
                }
            }else{
                playMusic();
                //清空数据行并关闭
                sourceDataLine.drain();
                sourceDataLine.close();
                audioStream.close();
            }

        }catch(IOException ex){
            ex.printStackTrace();
        }


    }
    public void playMusic(){
        try{
            synchronized(this){
                run = true;
            }
            //通过数据行读取音频数据流，发送到混音器;
            //数据流传输过程：AudioInputStream -> SourceDataLine;
            audioStream = AudioSystem.getAudioInputStream(new File(musicPath));
            int count;
            byte tempBuff[] = new byte[1024];

            while((count = audioStream.read(tempBuff,0,tempBuff.length)) != -1){
                synchronized(this){
                    while(!run)
                        wait();
                }
                sourceDataLine.write(tempBuff,0,count);

            }

        }catch(UnsupportedAudioFileException ex){
            ex.printStackTrace();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

    }


    //暂停播放音频
    public void stopMusic(){
        synchronized(this){
            run = false;
            notifyAll();
        }
    }
    //继续播放音乐
    public void continueMusic(){
        synchronized(this){
            run = true;
            notifyAll();
        }
    }


    //外部调用控制方法:生成音频主线程；
    public void start(boolean loop){
        mainThread = new Thread(new Runnable(){
            public void run(){
                try {
                    playMusic(loop);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        mainThread.start();
    }

    //外部调用控制方法：暂停音频线程
    public void stop(){
        new Thread(new Runnable(){
            public void run(){
                stopMusic();

            }
        }).start();
    }
    //外部调用控制方法：继续音频线程
    public void continues(){
        new Thread(new Runnable(){
            public void run(){
                continueMusic();
            }
        }).start();
    }
}