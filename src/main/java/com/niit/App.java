package com.niit;

import com.niit.dao.*;
import com.niit.dao.impl.*;

import com.niit.model.Playlist;
import com.niit.model.Record;

import java.sql.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SongDAO songDAOImpl = new SongDAOImpl();
        AlbumDAO albumDAOImpl = new AlbumDAOImpl();
        PodcastDAO podcastDAOImpl = new PodcastDAOImpl();
        PlaylistDAO playlistDAOImpl = new PlaylistDAOImpl();
        RecordDAO recordDAOImpl = new RecordDAOImpl();
        System.out.println("\n");
        System.out.println("*********** WELCOME TO JUKEBOX ************");
        System.out.println("     Below are all the available items\n");
        System.out.println("------------Songs------------");
        songDAOImpl.displayAllSongs(songDAOImpl.showAllSongs());
        System.out.println("\n");
        System.out.println("----------Podcasts----------");
        podcastDAOImpl.displayAllPodcast(podcastDAOImpl.showAllPodcast());
        System.out.println("\n");
        System.out.println("-----------Albums-------------");
        albumDAOImpl.displayAllAlbums(albumDAOImpl.showAllAlbums());
        System.out.println("\n");
        // System.out.println("Songs with album name \n");
        //  recordImpl.songsAndAlbums();
        int choice;
        int choice1;
        int choice2;
        int choice3;
        int choice4;
        do {
            System.out.println("Select what do you want to search/play\n1.Songs\n2.Podcasts\n3.Album\n4.Playlists\n5.Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    do {
                        System.out.println("Search a song by:\n1.Name\n2.Artist\n3.Genre\n4.Podcast");
                        choice1 = scanner.nextInt();
                        switch (choice1) {
                            case 1:
                                System.out.println("Enter name of song");
                                String songName = scanner.next();
                                System.out.println(songDAOImpl.findSongByName(songName));
                                break;
                            case 2:
                                System.out.println("Enter name of artist");
                                String artist = scanner.next();
                                System.out.println(songDAOImpl.findSongByArtist(artist));
                                break;
                            case 3:
                                System.out.println("Enter genre");
                                String genre = scanner.next();
                                System.out.println(songDAOImpl.findSongByGenre(genre));
                                break;
                            case 4:break;
                            default:
                                System.out.println("Incorrect choice!");
                                break;
                        }
                    } while (choice1 != 4);

                case 2:
                    do {
                        System.out.println("Search a Podcast by:\n1.Name\n2.Celebrity\n3.Genre\n4.Date\n5.Album");
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter name of podcast");
                                String podcastName = scanner.next();
                                System.out.println(podcastDAOImpl.findPodcastByName(podcastName));
                                break;
                            case 2:
                                System.out.println("Enter name of Celebrity");
                                String celebrity = scanner.next();
                                System.out.println(podcastDAOImpl.findPodcastByCelebrity(celebrity));
                                break;
                            case 3:
                                System.out.println("Enter genre");
                                String genre = scanner.next();
                                System.out.println(podcastDAOImpl.findPodcastByGenre(genre));
                                break;
                            case 4:
                                System.out.println("Enter date");
                                String str = scanner.next();
                                Date date = Date.valueOf(str);//converting string into sql date.
                                System.out.println(podcastDAOImpl.findPodcastByDate(date));
                                break;
                            case 5:break;
                            default:
                                System.out.println("Incorrect choice!");
                                break;
                        }
                    } while (choice2 != 5);

                case 3:
                    do {
                        System.out.println("1.View available albums\n2.Playlist");
                        choice3 = scanner.nextInt();
                        switch (choice3) {
                            case 1:
                                System.out.println("Available albums: ");
                                recordDAOImpl.songsAndAlbums();
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Incorrect choice!");
                                break;
                        }

                    } while (choice3 != 2);

                case 4:
                    System.out.println("Playlists currently available");
                    playlistDAOImpl.displayAllPlaylists(playlistDAOImpl.showAllPlaylists());
                    do {
                        System.out.println("\nWhat do you want to do with the playlist:\n1.Add songs\n2.Delete songs\n3.Add podcast\n4.Delete podcast\n5.Add song And Podcast\n6.Create playlist\n7.View playlist content\n8.Main menu");
                        choice4 = scanner.nextInt();

                        switch (choice4) {
                            case 1:
                                System.out.println("Below are all the available songs, please select playlist and song ");
                                songDAOImpl.displayAllSongs(songDAOImpl.showAllSongs());
                                int songId = scanner.nextInt();
                                int playlistId = scanner.nextInt();
                                System.out.println("Enter record ID based on the record table shown");
                                recordDAOImpl.displayAllRecord(recordDAOImpl.showAllRecord());
                                int recordId = scanner.nextInt();
                                int podcastId = 0;
                                int albumId = 0;
                                Record record = new Record(recordId, songId, podcastId, playlistId, albumId);
                                recordDAOImpl.addSongToPlaylist(record);
                                break;
                            case 2:
                                System.out.println("Select playlist ID from below from which you want to delete the song ");
                                playlistDAOImpl.displayAllPlaylists(playlistDAOImpl.showAllPlaylists());
                                //int playlistId = scanner.nextInt();
                                System.out.println("Enter name of song you want to remove");
                                String songName = scanner.next();
                                recordDAOImpl.deleteSongFromPlaylist(songName);
                                break;
                            case 3:
                                System.out.println("Below are all the available Podcasts, please select playlist and podcast ");
                                podcastDAOImpl.displayAllPodcast(podcastDAOImpl.showAllPodcast());
                                int podcastId1 = scanner.nextInt();
                                int playlistId1 = scanner.nextInt();
                                System.out.println("Enter record ID based on the record table shown");
                                recordDAOImpl.displayAllRecord(recordDAOImpl.showAllRecord());
                                int recordId1 = scanner.nextInt();
                                int songId1 = 0;
                                int albumId1 = 0;
                                Record record1 = new Record(recordId1, songId1, podcastId1, playlistId1, albumId1);
                                recordDAOImpl.addPodcastToPlaylist(record1);
                                break;
                            case 4:
                                System.out.println("Select playlist ID from below from which you want to delete the podcast ");
                                playlistDAOImpl.displayAllPlaylists(playlistDAOImpl.showAllPlaylists());
                                // int playlistId = scanner.nextInt();
                                System.out.println("Enter name of podcast you want to remove");
                                String podcast = scanner.next();
                                recordDAOImpl.deletePodcastFromPlaylist(podcast);
                                break;
                            case 5:
                                System.out.println("Below are all the available Songs and Podcasts, please select playlist, podcast, song IDs ");
                                songDAOImpl.displayAllSongs(songDAOImpl.showAllSongs());
                                podcastDAOImpl.displayAllPodcast(podcastDAOImpl.showAllPodcast());
                                int songId2 = scanner.nextInt();
                                int podcastId2 = scanner.nextInt();
                                int playlistId2 = scanner.nextInt();
                                System.out.println("Enter record ID based on the record table shown");
                                recordDAOImpl.displayAllRecord(recordDAOImpl.showAllRecord());
                                int recordId2 = scanner.nextInt();
                                int albumId2 = 0;
                                Record record2 = new Record(recordId2, songId2, podcastId2, playlistId2, albumId2);
                                recordDAOImpl.addSongAndPodcastToPlaylist(record2);
                            case 6:
                                System.out.println("Available playlists for you: ");
                                playlistDAOImpl.displayAllPlaylists(playlistDAOImpl.showAllPlaylists());
                                System.out.println("\n");
                                System.out.println("Please enter Playlist ID, name and created date to create new playlist");
                                int playlistId3 = scanner.nextInt();
                                String playlistName = scanner.next();
                                String str = scanner.next();
                                Date date = Date.valueOf(str);
                                Playlist playlist = new Playlist(playlistId3, playlistName, date);
                                boolean result = playlistDAOImpl.createPlaylist(playlist);
                                if (result) {
                                    System.out.println("Do you want to add songs?(1 for yes,2 for No)");
                                    int add = scanner.nextInt();
                                    if (add == 1) {
                                        System.out.println("Below are all the available songs, please song ");
                                        songDAOImpl.displayAllSongs(songDAOImpl.showAllSongs());
                                        int songId3 = scanner.nextInt();
                                        System.out.println("Enter record ID based on the record table shown");
                                        recordDAOImpl.displayAllRecord(recordDAOImpl.showAllRecord());
                                        int recordId3 = scanner.nextInt();
                                        int podcastId3 = 0;
                                        int albumId3 = 0;
                                        Record record3 = new Record(recordId3, songId3, podcastId3, playlistId3, albumId3);
                                        recordDAOImpl.addSongToPlaylist(record3);
                                    } else
                                        System.out.println("Thank you!");
                                }
                                break;
                            case 7:
                                System.out.println("Enter name of playlist you want to view the content for");
                                String playlistName1 = scanner.next();
                                recordDAOImpl.viewPlaylistContent(playlistName1);
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Incorrect choice!");
                                break;
                        }
                    } while (choice4 != 8);
                    break;

                case 5:
                    System.out.println("Exiting the application. Have a nice day!!");
                    break;
                default:
                    System.out.println("Incorrect choice!");
                    break;
            }
        } while (choice != 5);
    }
}