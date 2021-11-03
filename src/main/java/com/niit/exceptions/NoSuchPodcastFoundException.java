package com.niit.exceptions;

import java.sql.SQLException;

public class NoSuchPodcastFoundException extends SQLException {
    public NoSuchPodcastFoundException(String message) {
        super(message);
    }

}
