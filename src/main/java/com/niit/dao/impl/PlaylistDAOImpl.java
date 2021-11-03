package com.niit.dao.impl;
import com.niit.dao.PlaylistDAO;
import com.niit.exceptions.NoSuchPlaylistFoundException;
import com.niit.exceptions.NoSuchRecordFoundException;
import com.niit.helper.MySqlConnection;
import com.niit.model.Playlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAOImpl implements PlaylistDAO {

    private Connection connection;

    public PlaylistDAOImpl() {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public void displayAllPlaylists(List<Playlist> allPlaylist) {
        allPlaylist.stream().forEach(playlist -> System.out.println("PlaylistID: "+playlist.getPlaylistId()+"  Name: "+playlist.getPlaylistName()+"  Date created: "+playlist.getCreatedDate()));
    }

    @Override
    public List<Playlist> showAllPlaylists()  // show all playlists
    {
        List<Playlist> allPlaylists = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from playlist");
            while (resultSet.next())
            {
                Playlist playlist = new Playlist(resultSet.getInt("playlistId"),resultSet.getString("playlistName"),resultSet.getDate("createdDate"));
                allPlaylists.add(playlist);
            }
            return allPlaylists;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createPlaylist(Playlist playlist) {      // create playlist
        try
        {
            String query = "insert into playlist(playlistId, playlistName, createdDate) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,playlist.getPlaylistId());
            preparedStatement.setString(2,playlist.getPlaylistName());
            preparedStatement.setDate(3, playlist.getCreatedDate());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                throw new NoSuchRecordFoundException("Error!! Playlist couldn't be created");
            }
        }
        catch(NoSuchRecordFoundException ex)
        {
            ex.printStackTrace();
            return false;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Playlist getPlaylistByID(int playlistId) {    //Search playlist by ID
        try
        {
            String query = "select * from playlist where playlistId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,playlistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Playlist playlist = new Playlist(resultSet.getInt("playlistId"),resultSet.getString("playlistName"),resultSet.getDate("createdDate"));
                return playlist;
            }
            else
            {
                throw new NoSuchPlaylistFoundException("Error!! The playlist couldn't be fetched");
            }
        }
        catch(NoSuchPlaylistFoundException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
