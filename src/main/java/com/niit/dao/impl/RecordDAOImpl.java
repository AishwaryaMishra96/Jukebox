package com.niit.dao.impl;
import com.niit.dao.RecordDAO;
import com.niit.exceptions.NoSuchRecordFoundException;
import com.niit.exceptions.NoSuchPodcastFoundException;
import com.niit.exceptions.NoSuchSongFoundException;
import com.niit.helper.MySqlConnection;
import com.niit.model.Playlist;
import com.niit.model.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDAOImpl implements RecordDAO {

    private Connection connection;

    public RecordDAOImpl() {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public void songsAndAlbums() {    // Show album and songs
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select song.songName,album.albumName from song join record using (songid) join album using (albumid)");
            while (resultSet.next()) {
                System.out.println("Album Name : " + resultSet.getString("albumName") + " Song Name : " + resultSet.getString("songName"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void displayAllRecord(List<Record> allRecord) {
        allRecord.stream().forEach(record -> System.out.println("Record ID: "+record.getRecordId()+"  SongID: "+record.getSongId()+"  Podcast ID: "+record.getPodcastId()+"  Playlist ID: "+record.getPlaylistId()+"  Album ID: "+record.getAlbumId()));
    }

    @Override
    public List<Record> showAllRecord()   // show record table
    {
        List<Record> allRecord = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from record");
            while (resultSet.next())
            {
                Record record = new Record(resultSet.getInt("recordId"),resultSet.getInt("songId"),resultSet.getInt("podcastId"),
                        resultSet.getInt("playlistId"),resultSet.getInt("albumId"));
                allRecord.add(record);
            }
            return allRecord;
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
    public Record getRecordByID(int recordId) {  // Search record by ID
        try
        {
            String query = "select * from record where recordId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,recordId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Record record = new Record(resultSet.getInt("recordId"),resultSet.getInt("songId"),resultSet.getInt("podcastId"),
                        resultSet.getInt("playlistId"),resultSet.getInt("albumId"));
                return record;
            }
            else
            {
                throw new NoSuchRecordFoundException("Error!! No record found with this ID");
            }
        }
        catch(NoSuchRecordFoundException ex)
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
    public boolean addSongToPlaylist(Record record)  // Add song to playlist
    {
        try
        {
            String query = "insert into record(recordid, songid, podcastid, playlistid, albumid) values(?,?,null,?,null)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,record.getRecordId());
            preparedStatement.setInt(2,record.getSongId());
            preparedStatement.setInt(3,record.getPlaylistId());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                throw new NoSuchSongFoundException("Error!! The song couldn't be added");
            }
        }
        catch(NoSuchSongFoundException ex)
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
    public boolean addPodcastToPlaylist(Record record)  // Add podcast to playlist
    {
        try
        {
            String query = "insert into record(recordid, songid, podcastid, playlistid, albumid) values(?,null,?,?,null)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,record.getRecordId());
            preparedStatement.setInt(2,record.getPodcastId());
            preparedStatement.setInt(3,record.getPlaylistId());
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                throw new NoSuchPodcastFoundException("Error!! The podcast couldn't be added");
            }
        }
        catch(NoSuchPodcastFoundException ex)
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
    public boolean addSongAndPodcastToPlaylist(Record record)  // Add song and podcast to playlist
    {
        try
        {
            String query = "insert into record(recordid, songid, podcastid, playlistid, albumid) values(?,?,?,?,null)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,record.getRecordId());
            preparedStatement.setInt(2,record.getSongId());
            preparedStatement.setInt(3,record.getPodcastId());
            preparedStatement.setInt(4,record.getPlaylistId());

            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                throw new NoSuchRecordFoundException("Error!! The input detail couldn't be added");
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
    public boolean deleteSongFromPlaylist(String songName) {  //Delete song from playlist
        try
        {
            String query = "DELETE playlist FROM playlist JOIN record using (playlistId) join song using (songId) where song.songName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,songName);
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                throw new NoSuchSongFoundException("Error!! Song couldn't be deleted");
            }
        }
        catch(NoSuchSongFoundException ex)
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
    public boolean deletePodcastFromPlaylist(String podcastName) {  //Delete podcast from playlist
        try
        {
            String query = "DELETE record FROM playlist JOIN record using (playlistId) join podcast using (podcastId) where podcast.podcastName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,podcastName);
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                throw new NoSuchPodcastFoundException("Error!! Podcast couldn't be deleted");
            }
        }
        catch(NoSuchPodcastFoundException ex)
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
    public void viewPlaylistContent(String playlistName)  // View playlist content
    {
        Playlist playlist;
        try {
            String query = "select p.playlistname, s.songname from playlist p join record r on p.playlistid = r.playlistid join song s on r.songid = s.songid where p.playlistname = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,playlistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                System.out.println("Play List Name : "+resultSet.getString("playlistName")+"   Song Name : "+resultSet.getString("songName"));
            }
        } catch (Exception ex){
            ex.printStackTrace();

        }
    }
}
