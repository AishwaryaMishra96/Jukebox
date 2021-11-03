package com.niit;
import com.niit.dao.impl.PodcastDAOImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PodcastImplTest {
    PodcastDAOImpl podcastDAOImpl;

    @BeforeEach
    void setUp() {
        podcastDAOImpl = new PodcastDAOImpl();
    }

    @AfterEach
    void tearDown() {
        podcastDAOImpl = null;
    }

    @Test
    public void givenPodcastNameGetPodcastDetails() {
        assertEquals(21, podcastDAOImpl.findPodcastByName("strength").getPodcastId());
        assertEquals("soman milind", podcastDAOImpl.findPodcastByName("strength").getCelebrity());
        assertEquals("fitness", podcastDAOImpl.findPodcastByName("strength").getGenre());
        assertEquals(Date.valueOf("2021-02-20"), podcastDAOImpl.findPodcastByName("strength").getDate());
    }

    @Test
    public void givenPodcastCelebrityGetPodcastDetails() {
        assertEquals(22, podcastDAOImpl.findPodcastByCelebrity("siddhant").getPodcastId());
        assertEquals("josh talks", podcastDAOImpl.findPodcastByCelebrity("siddhant").getPodcastName());
        assertEquals("educational", podcastDAOImpl.findPodcastByCelebrity("siddhant").getGenre());
        assertEquals(Date.valueOf("2021-04-03"), podcastDAOImpl.findPodcastByCelebrity("siddhant").getDate());
    }

    @Test
    public void givenPodcastGenreGetPodcastDetails() {
        assertEquals("health mantra",podcastDAOImpl.findPodcastByGenre("health").getPodcastName());
        assertEquals(23,podcastDAOImpl.findPodcastByGenre("health").getPodcastId());
        assertEquals("suchita",podcastDAOImpl.findPodcastByGenre("health").getCelebrity());
        assertEquals(Date.valueOf("2021-05-20"),podcastDAOImpl.findPodcastByGenre("health").getDate());
    }

    @Test
    public void givenPodcastDateGetPodcastDetails() {
        assertEquals("fitness trend", podcastDAOImpl.findPodcastByDate(Date.valueOf("2021-02-21")).getPodcastName());
        assertEquals(25, podcastDAOImpl.findPodcastByDate(Date.valueOf("2021-02-21")).getPodcastId());
        assertEquals("fitness", podcastDAOImpl.findPodcastByDate(Date.valueOf("2021-02-21")).getGenre());
        assertEquals("Akshay", podcastDAOImpl.findPodcastByDate(Date.valueOf("2021-02-21")).getCelebrity());

    }
}
