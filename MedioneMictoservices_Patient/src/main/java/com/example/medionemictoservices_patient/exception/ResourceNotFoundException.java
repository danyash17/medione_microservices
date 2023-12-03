package com.example.medionemictoservices_patient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String resoucre, String field, String value) {
        super(String.format("Resource %s not found by %s field with %s value", resoucre, field, value));
    }
}
