package com.niit;
import com.niit.dao.impl.AlbumDAOImpl;
import com.niit.dao.impl.PlaylistDAOImpl;
import com.niit.model.Playlist;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistImplTest {
    PlaylistDAOImpl playlistDAOImpl;

    @BeforeEach
    void setUp() {
        playlistDAOImpl = new PlaylistDAOImpl();
    }
    @AfterEach
    void tearDown() {
        playlistDAOImpl = null;
    }

        @Test
        public void validatePlaylistContent() {
            assertEquals(41, playlistDAOImpl.showAllPlaylists().get(0).getPlaylistId());
            assertEquals("Videsi", playlistDAOImpl.showAllPlaylists().get(1).getPlaylistName());
            assertEquals(Date.valueOf("2021-05-09"), playlistDAOImpl.showAllPlaylists().get(8).getCreatedDate());
        }

        @Test
        public void createPlaylist()
        {
           // assertEquals(true,playlistDAOImpl.createPlaylist(new Playlist(101,"New",null)));
            assertEquals(false,playlistDAOImpl.createPlaylist(new Playlist(101,"New",null)));
        }

        @Test
    public void givenPlaylistIdGetDetails()
        {
            assertEquals("Soothing",playlistDAOImpl.getPlaylistByID(43).getPlaylistName());
            assertEquals(Date.valueOf("2021-05-09"),playlistDAOImpl.getPlaylistByID(49).getCreatedDate());
        }
}
