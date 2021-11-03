package com.niit.dao;

import com.niit.model.Record;

import java.util.List;

public interface RecordDAO {
    void songsAndAlbums();
    void displayAllRecord(List<Record> allRecord);
    List<Record> showAllRecord();
    Record getRecordByID(int recordId);
    boolean addSongToPlaylist(Record record);
    boolean addPodcastToPlaylist(Record record);
    boolean addSongAndPodcastToPlaylist(Record record);
    boolean deleteSongFromPlaylist(String songName);
    boolean deletePodcastFromPlaylist(String podcastName);
    void viewPlaylistContent(String playlistName);
}
