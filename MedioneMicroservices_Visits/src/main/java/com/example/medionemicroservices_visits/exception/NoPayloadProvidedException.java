package com.example.medionemicroservices_visits.exception;

public class NoPayloadProvidedException extends RuntimeException{

    public NoPayloadProvidedException(String field) {
        super(String.format("%s field must be provided and cannot be empty"));
    }
}
