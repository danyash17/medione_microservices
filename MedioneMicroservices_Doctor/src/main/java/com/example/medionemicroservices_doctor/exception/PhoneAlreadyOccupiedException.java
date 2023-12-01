package com.example.medionemicroservices_doctor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PhoneAlreadyOccupiedException extends RuntimeException{

    public PhoneAlreadyOccupiedException(String message) {
        super(message);
    }
}
