package com.example.medionemicroservices_doctor.exception;

public class LoginAlreadyOccupiedException extends RuntimeException{

    public LoginAlreadyOccupiedException(String login) {
        super(String.format("%s is already in use, choose another"));
    }
}
