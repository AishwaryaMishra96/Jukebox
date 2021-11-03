package com.niit.dao;

import com.niit.model.Playlist;

import java.util.List;

public interface PlaylistDAO {

    List<Playlist> showAllPlaylists();
    void displayAllPlaylists(List<Playlist> allPlaylist);
    boolean createPlaylist(Playlist playlist);
    Playlist getPlaylistByID(int playlistId);

}
