package com.niit;
import com.niit.dao.impl.RecordDAOImpl;
import com.niit.model.Record;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RecordImplTest {
    RecordDAOImpl recordDAOImpl;

    @BeforeEach
    void setUp() {
        recordDAOImpl = new RecordDAOImpl();
    }

    @AfterEach
    void tearDown() {
        recordDAOImpl = null;
    }

    @Test
    public void validateRecordDetails()
    {
        assertEquals(51,recordDAOImpl.showAllRecord().get(0).getRecordId());
        assertEquals(4,recordDAOImpl.showAllRecord().get(1).getSongId());
        assertEquals(0,recordDAOImpl.showAllRecord().get(0).getPodcastId());
        assertEquals(31,recordDAOImpl.showAllRecord().get(4).getAlbumId());
    }

    @Test
    public void givenRecordIdGetDetails()
    {
        assertEquals(4,recordDAOImpl.getRecordByID(59).getSongId());
        assertEquals(0,recordDAOImpl.getRecordByID(53).getPodcastId());
        assertEquals(46,recordDAOImpl.getRecordByID(58).getPlaylistId());
        assertEquals(31,recordDAOImpl.getRecordByID(57).getAlbumId());
    }

    public void addSongInPlaylist()
    {
        assertEquals(true,recordDAOImpl.addSongToPlaylist(new Record(63,2,0,101,0)));
        assertEquals(false,recordDAOImpl.addSongToPlaylist(new Record(63,2,0,101,0)));
    }

    public void addPodcastInPlaylist()
    {
        assertEquals(true,recordDAOImpl.addPodcastToPlaylist(new Record(64,0,24,101,0)));
        assertEquals(false,recordDAOImpl.addPodcastToPlaylist(new Record(64,0,24,101,0)));
    }

    public void addSongAndPodcastInPlaylist()
    {
        assertEquals(true,recordDAOImpl.addSongAndPodcastToPlaylist(new Record(65,1,24,48,0)));
        assertEquals(false,recordDAOImpl.addPodcastToPlaylist(new Record(64,0,24,101,0)));
    }

    public void deleteSongFromPlaylist()
    {
        assertEquals(true,recordDAOImpl.deleteSongFromPlaylist("Dhinka chika"));
        assertEquals(false,recordDAOImpl.deleteSongFromPlaylist("Dhinka chika"));
    }

    public void deletePodcastFromPlaylist()
    {
        assertEquals(true,recordDAOImpl.deletePodcastFromPlaylist("Jokes"));
        assertEquals(false,recordDAOImpl.deletePodcastFromPlaylist("DJokes"));
    }
}
