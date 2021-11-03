package com.niit.dao;

import com.niit.model.Podcast;
import com.niit.model.Song;

import java.sql.Date;
import java.util.List;

public interface PodcastDAO {

    List<Podcast> showAllPodcast();
    void displayAllPodcast(List<Podcast> allPodcast);
    Podcast findPodcastByName(String podcastName);
    Podcast findPodcastByCelebrity(String celebrity);
    Podcast findPodcastByGenre(String genre);
    Podcast findPodcastByDate(Date date);
}
