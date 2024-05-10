package com.NJT.WebApi.exception;

public class RegistrationException extends Exception{

    String message;
    public RegistrationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
