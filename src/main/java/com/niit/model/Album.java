package com.niit.model;
import java.sql.Date;

public class Album {

    private int albumId;
    private String albumName;
    private Date releaseDate;

    public Album(int albumId, String albumName, Date releaseDate) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return
                "AlbumId = " + albumId +
                "   Name = " + albumName +
                "   ReleaseDate = " + releaseDate;
    }
}
