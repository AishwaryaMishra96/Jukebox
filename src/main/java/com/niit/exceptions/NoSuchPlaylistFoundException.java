package com.niit.exceptions;

import java.sql.SQLException;

public class NoSuchPlaylistFoundException extends SQLException {
    public NoSuchPlaylistFoundException(String message)
    {
        super(message);
    }
}
