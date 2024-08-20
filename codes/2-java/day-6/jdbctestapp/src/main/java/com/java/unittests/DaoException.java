package com.java.unittests;

public class DaoException extends Exception {

    public DaoException() {
        super("error occurred");
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
