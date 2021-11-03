package com.niit.dao.impl;
import com.niit.dao.AlbumDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Album;
import com.niit.model.Playlist;
import com.niit.model.Song;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumDAOImpl implements AlbumDAO  {

    private Connection connection;

    public AlbumDAOImpl() {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public List<Album> showAllAlbums() {   //show all albums
        List<Album> allAlbums = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from album");
            while (resultSet.next()) {
                Album album = new Album(resultSet.getInt("albumId"),resultSet.getString("albumName"),resultSet.getDate("releaseDate"));
                allAlbums.add(album);
            }
            return allAlbums;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void displayAllAlbums(List<Album> allAlbums) {
        allAlbums.stream().forEach(album ->System.out.println("AlbumID: "+album.getAlbumId()+"  Name: "+album.getAlbumName()+"  Release Date: "+album.getReleaseDate()));
        }
}

