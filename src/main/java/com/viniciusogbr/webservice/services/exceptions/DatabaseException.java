package com.viniciusogbr.webservice.services.exceptions;

public class DatabaseException extends RuntimeException{

    private static final Long serialVersionUID =1L;

    public DatabaseException(String message) {
        super(message);
    }
}
