package com.niit;
import com.niit.dao.impl.AlbumDAOImpl;
import com.niit.model.Album;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlbumImplTest {
    AlbumDAOImpl albumDAOImpl;

    @BeforeEach
    void setUp() {
        albumDAOImpl = new AlbumDAOImpl();
        List<Album> allAlbums = new ArrayList<>();
        Album album = new Album(31,"hindi songs",null);
        Album album1 = new Album(32,"KPOP",null);
        Album album2 = new Album(33,"Hiphop",null);
        Album album3 = new Album(35,"breathless",null);
        allAlbums.add(album);
        allAlbums.add(album1);
        allAlbums.add(album2);
        allAlbums.add(album3);
    }

    @AfterEach
    void tearDown() {
        albumDAOImpl = null;
    }

    @Test
    public void validateAlbumContent()
    {
        assertEquals(31,albumDAOImpl.showAllAlbums().get(0).getAlbumId());
        assertEquals("KPOP",albumDAOImpl.showAllAlbums().get(1).getAlbumName());
        assertEquals(Date.valueOf("2021-06-20"),albumDAOImpl.showAllAlbums().get(1).getReleaseDate());
    }


}
