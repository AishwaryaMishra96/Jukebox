package com.niit.dao.impl;
import com.niit.dao.SongDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Song;
import com.niit.exceptions.NoSuchSongFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongDAOImpl implements SongDAO {

    private Connection connection;

    public SongDAOImpl() {
        connection = MySqlConnection.getConnection();
    }


    @Override
    public List<Song> showAllSongs()   //show all songs
    {
        List<Song> allSongs = new ArrayList<>();
        List<Song> allSongs2 = new ArrayList<>();
        try {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from song");
            while (resultSet.next())
            {
                Song song = new Song(resultSet.getInt("songId"),resultSet.getString("songName"),
                        resultSet.getString("artist"),resultSet.getString("genre"),
                        resultSet.getDouble("duration"),resultSet.getString("location"));
                allSongs.add(song);
            }
                allSongs2 = allSongs.stream().collect(Collectors.toList());
            return allSongs;
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
    public void displayAllSongs(List<Song> allSongs) {
        allSongs.stream().forEach(song -> System.out.println("SongID: "+song.getSongId()+"  Name: "+song.getSongName()+"  Artist: "+song.getArtist()+"  Genre: "+song.getGenre()+"  Duration: "+song.getDuration()+"minutes"+"  Location: "+song.getLocation()));
    }

    @Override
    public Song getSongByID(int songId) {   // fetch song by ID
        try
        {
            String query = "select * from song where songId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,songId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("songId"),resultSet.getString("songName"),
                        resultSet.getString("artist"),resultSet.getString("genre"),
                        resultSet.getDouble("duration"),resultSet.getString("location"));
                return song;
            }
            else
            {
                throw new NoSuchSongFoundException("No song found");
            }
        }
        catch(NoSuchSongFoundException ex)
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
    public Song findSongByName(String songName)   // fetch song by Name
    {
        try
        {
            String query = "select * from song where songName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("songId"),resultSet.getString("songName"),
                        resultSet.getString("artist"),resultSet.getString("genre"),
                        resultSet.getDouble("duration"),resultSet.getString("location"));
                return song;
            }
            else
            {
                throw new NoSuchSongFoundException("No song found");
            }
        }
        catch(NoSuchSongFoundException ex)
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
    public Song findSongByArtist(String artist)    // fetch song by Artist
    {
        try
        {
            String query = "select * from song where artist = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,artist);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("songId"),resultSet.getString("songName"),
                        resultSet.getString("artist"),resultSet.getString("genre"),
                        resultSet.getDouble("duration"),resultSet.getString("location"));
                return song;
            }
            else
            {
                throw new NoSuchSongFoundException("No song found with this artist");
            }
        }
        catch(NoSuchSongFoundException ex)
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
    public Song findSongByGenre(String genre)     // fetch song by Genre
    {
        try
        {
            String query = "select * from song where genre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,genre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("songId"),resultSet.getString("songName"),
                        resultSet.getString("artist"),resultSet.getString("genre"),
                        resultSet.getDouble("duration"),resultSet.getString("location"));
                return song;
            }
            else
            {
                throw new NoSuchSongFoundException("No song found with this genre");
            }
        }
        catch(NoSuchSongFoundException ex)
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
