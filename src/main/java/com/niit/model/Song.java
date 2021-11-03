package com.niit.model;

public class Song {

    private int songId;
    private String songName;
    private String artist;
    private String genre;
    private double duration;
    private String location;

    public Song(int songId, String songName, String artist, String genre, double duration, String location) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.location = location;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return
                "songId = " + songId +
                "  name = " + songName +
                "  artist = " + artist +
                "  genre = " + genre +
                "  duration = " + duration +
                "  location = " + location ;
    }
}
