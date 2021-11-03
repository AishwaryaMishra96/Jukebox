package com.niit.model;

public class Record {

    private int recordId;
    private int songId;
    private int podcastId;
    private int playlistId;
    private int albumId;

    public Record(int recordId, int songId, int podcastId, int playlistId, int albumId) {
        this.recordId = recordId;
        this.songId = songId;
        this.podcastId = podcastId;
        this.playlistId = playlistId;
        this.albumId = albumId;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public String toString() {
        return
                "RecordId = " + recordId +
                "   songId = " + songId +
                "   podcastId = " + podcastId +
                "   playlistId = " + playlistId +
                "   albumId = " + albumId ;
    }
}
