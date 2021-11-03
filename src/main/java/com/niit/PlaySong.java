package com.niit;
import com.niit.dao.impl.SongDAOImpl;
import com.niit.model.Song;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlaySong {
    Long currentFrame;
    Clip clip;
    int currentIndex;

    // current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath;


    // constructor to initialize streams and clip
    public PlaySong(String location) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(new File(location));

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);
    }

    public static void main(String[] args)
    {

        SongDAOImpl songDAOImpl = new SongDAOImpl();
        List<Song> songList = songDAOImpl.showAllSongs();

        try
        {
            int i=0;
            filePath = songList.get(0).getLocation();
            PlaySong audioPlayer =
                    new PlaySong(filePath);
            for(Song song : songList) {
                if (songList.get(i).getSongId() > songList.size()) {
                    break;
                } else {
                    audioPlayer.play();

                }
            }
            Scanner sc = new Scanner(System.in);
            while (true)
            {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                System.out.println("6. Play next song");
                System.out.println("7. Play previous song");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 4)
                    break;
            }
            sc.close();
        }

        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    // Work as the user enters his choice

    private void gotoChoice(int c)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        List<Song> songs = new ArrayList<>();
        switch (c)
        {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
            case 5:
                System.out.println("Enter time (" + 0 +
                        ", " + clip.getMicrosecondLength() + ")");
                Scanner sc = new Scanner(System.in);
                long c1 = sc.nextLong();
                jump(c1);
                break;
            case 6:
                playNext(songs);
        }

    }

    public void playNext(List<Song> songs) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
        clip.close();

        currentIndex++;
        SongDAOImpl songDAOImpl = new SongDAOImpl();
        List<Song> songList = songDAOImpl.showAllSongs();
        filePath = songList.get(currentIndex).getLocation();
        if(songList.get(currentIndex).getSongId()<songList.size()) {
            PlaySong audioPlayer =
                    new PlaySong(filePath);
            audioPlayer.play();
        }

    }

    public void playPrevious() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
        currentIndex--;
        SongDAOImpl songDAOImpl = new SongDAOImpl();
        List<Song> songList = songDAOImpl.showAllSongs();
        filePath = songList.get(currentIndex++).getLocation();
        PlaySong audioPlayer =
                new PlaySong(filePath);
        audioPlayer.play();

    }

    // Method to play the audio
    public void play()
    {
        //start the clip
        clip.start();

        status = "play";
    }

    // Method to pause the audio
    public void pause()
    {
        if (status.equals("paused"))
        {
            System.out.println("audio is already paused");
            return;
        }
        this.currentFrame =
                this.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    // Method to resume the audio
    public void resumeAudio() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+
                    "being played");
            return;
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    // Method to restart the audio
    public void restart() throws IOException, LineUnavailableException,
            UnsupportedAudioFileException
    {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
    }

    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
            IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    // Method to jump over a specific part
    public void jump(long c) throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        if (c > 0 && c < clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame = c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }

    // Method to reset audio stream
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException,
            LineUnavailableException
    {
        audioInputStream = AudioSystem.getAudioInputStream(
                new File(filePath));
        clip.open(audioInputStream);
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
