package com.niit.dao.impl;
import com.niit.dao.PodcastDAO;
import com.niit.exceptions.NoSuchPodcastFoundException;
import com.niit.helper.MySqlConnection;
import com.niit.model.Podcast;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastDAOImpl implements PodcastDAO {

    private Connection connection;

    public PodcastDAOImpl() {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public List<Podcast> showAllPodcast() {      //show all podcasts
        List<Podcast> allPodcasts = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from podcast");
            while (resultSet.next()) {
                Podcast podcast = new Podcast(resultSet.getInt("podcastId"), resultSet.getString("podcastName"),
                        resultSet.getString("celebrity"), resultSet.getString("genre"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                allPodcasts.add(podcast);
            }
            return allPodcasts;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public void displayAllPodcast(List<Podcast> allPodcast) {
        allPodcast.stream().forEach(podcast -> System.out.println("PodcastID: " + podcast.getPodcastId() + "  Name: " + podcast.getPodcastName() + "  Celebrity: " + podcast.getCelebrity() + "  Genre: " + podcast.getGenre() + "  Date of recording: " + podcast.getDate() + "  Location: " + podcast.getLocation()));
    }

    public Podcast findPodcastByName(String podcastName) {   // fetch podcast by Name
        try {
            String query = "select * from podcast where podcastName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, podcastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Podcast podcast = new Podcast(resultSet.getInt("podcastId"), resultSet.getString("podcastName"),
                        resultSet.getString("celebrity"), resultSet.getString("genre"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                return podcast;
            } else {
                throw new NoSuchPodcastFoundException("No podcast found");
            }
        } catch (NoSuchPodcastFoundException ex){
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Podcast findPodcastByCelebrity(String celebrity) {   // fetch podcast by Celebrity
        try {
            String query = "select * from podcast where celebrity = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, celebrity);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Podcast podcast = new Podcast(resultSet.getInt("podcastId"), resultSet.getString("podcastName"),
                        resultSet.getString("celebrity"), resultSet.getString("genre"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                return podcast;
            } else {
                throw new NoSuchPodcastFoundException("No podcast found");
            }
        } catch (NoSuchPodcastFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Podcast findPodcastByGenre(String genre) {    // fetch podcast by Genre
        try {
            String query = "select * from podcast where genre = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, genre);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Podcast podcast = new Podcast(resultSet.getInt("podcastId"), resultSet.getString("podcastName"),
                        resultSet.getString("celebrity"), resultSet.getString("genre"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                return podcast;
            } else {
                throw new NoSuchPodcastFoundException("No podcast found");
            }
        } catch (NoSuchPodcastFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Podcast findPodcastByDate(Date date) {   // fetch podcast by Date recorded
        try {
            String query = "select * from podcast where date = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDate(1, date);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Podcast podcast = new Podcast(resultSet.getInt("podcastId"), resultSet.getString("podcastName"),
                        resultSet.getString("celebrity"), resultSet.getString("genre"),
                        resultSet.getDate("date"), resultSet.getString("location"));
                return podcast;
            } else {
                throw new NoSuchPodcastFoundException("No podcast found");
            }
        } catch (NoSuchPodcastFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}


