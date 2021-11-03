package com.niit.dao;
import com.niit.model.Album;
import java.util.List;

public interface AlbumDAO {

    List<Album> showAllAlbums();
    void displayAllAlbums(List<Album> allAlbums);
}
