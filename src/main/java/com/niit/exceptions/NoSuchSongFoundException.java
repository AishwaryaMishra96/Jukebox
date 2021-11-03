package com.niit.exceptions;
import java.sql.SQLException;

public class NoSuchSongFoundException extends SQLException {
    public NoSuchSongFoundException(String message) {
        super(message);
    }

}