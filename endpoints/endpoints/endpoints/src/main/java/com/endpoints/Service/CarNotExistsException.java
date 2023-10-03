package com.endpoints.Service;

public class CarNotExistsException extends Exception{
    public CarNotExistsException(String message) {
        super(message);
    }
}
