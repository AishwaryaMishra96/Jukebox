package com.niit.model;

import java.sql.Date;

public class Podcast {

    private int podcastId;
    private String podcastName;
    private String celebrity;
    private String genre;
    private Date date;
    private String location;

    public Podcast(int podcastId, String podcastName, String celebrity, String genre, Date date, String location) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.celebrity = celebrity;
        this.genre = genre;
        this.date = date;
        this.location = location;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(String celebrity) {
        this.celebrity = celebrity;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                "podcastId = " + podcastId +
                "   name = " + podcastName +
                "   celebrity = " + celebrity +
                "   genre = " + genre +
                "   date = " + date +
                "   location = " + location;
    }
}
