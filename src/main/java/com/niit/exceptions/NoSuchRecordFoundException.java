package com.niit.exceptions;

import java.sql.SQLException;

public class NoSuchRecordFoundException extends SQLException {
    public NoSuchRecordFoundException(String message)
    {
        super(message);
    }
}
