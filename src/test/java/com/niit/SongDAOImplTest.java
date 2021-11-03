package com.niit;
import com.niit.dao.impl.SongDAOImpl;
import com.niit.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SongDAOImplTest {
    SongDAOImpl songDAOImpl;

    @BeforeEach
    void setUp() {
        songDAOImpl = new SongDAOImpl();
    }

    @AfterEach
    void tearDown() {
        songDAOImpl = null;
    }

    @Test
    public void givenSongNameGetSongDetails()
    {
        assertEquals(3,songDAOImpl.findSongByName("O bekhabar").getSongId());
        assertEquals("Shreya",songDAOImpl.findSongByName("O bekhabar").getArtist());
        assertEquals("romantic",songDAOImpl.findSongByName("O bekhabar").getGenre());
        assertEquals(4.31,songDAOImpl.findSongByName("O bekhabar").getDuration());
    }
    @Test
    public void givenSongIdGetSongDetails()
    {
        assertEquals("Aapka kya hoga",songDAOImpl.getSongByID(1).getSongName());
        assertEquals("Mika",songDAOImpl.getSongByID(1).getArtist());
        assertEquals("dance",songDAOImpl.getSongByID(1).getGenre());
        assertEquals(5.09,songDAOImpl.getSongByID(1).getDuration());
    }

    @Test
    public void givenSongArtistGetSongDetails() {
        assertEquals(5,songDAOImpl.findSongByArtist("shankar").getSongId());
        assertEquals("breathless", songDAOImpl.findSongByArtist("shankar").getSongName());
        assertEquals("motivational", songDAOImpl.findSongByArtist("shankar").getGenre());
        assertEquals(5.50, songDAOImpl.findSongByArtist("shankar").getDuration());
    }

    @Test
    public void givenSongGenreGetSongDetails() {
        assertEquals(6, songDAOImpl.findSongByGenre("kpop").getSongId());
        assertEquals("dynamite", songDAOImpl.findSongByGenre("kpop").getSongName());
        assertEquals("bts", songDAOImpl.findSongByGenre("kpop").getArtist());
        assertEquals(3.18, songDAOImpl.findSongByGenre("kpop").getDuration());

    }
    }
