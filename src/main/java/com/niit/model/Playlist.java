package com.niit.model;

import java.sql.Date;

public class Playlist {

    private int playlistId;
    private String playlistName;
    private Date createdDate;

    public Playlist(int playlistId, String playlistName, Date createdDate) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.createdDate = createdDate;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return
                "PlaylistId = " + playlistId +
                "   name = " + playlistName +
                "   CreatedDate = " + createdDate;
    }
}
