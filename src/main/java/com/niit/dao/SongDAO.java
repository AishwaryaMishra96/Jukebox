package com.niit.dao;

import com.niit.model.Song;

import java.util.List;

public interface SongDAO {

    List<Song> showAllSongs();
    void displayAllSongs(List<Song> allSongs);
    Song getSongByID(int songId);
    Song findSongByName(String songName);
    Song findSongByArtist(String artist);
    Song findSongByGenre(String Genre);
}
