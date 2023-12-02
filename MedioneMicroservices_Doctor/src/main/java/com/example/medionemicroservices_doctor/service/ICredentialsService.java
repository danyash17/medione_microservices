package com.example.medionemicroservices_doctor.service;

import com.example.medionemicroservices_doctor.model.Credentials;

public interface ICredentialsService {

    /**
     * @param phoneNumber
     * @return true if phone number is free, false if already used
     */
    Boolean validatePhoneNumberNotOccupiedYet(String phoneNumber);

    /**
     * @param phoneNumber
     * @return Credentials that are assigned to following phone
     */
    Credentials fetchCredentialsByPhoneNumber(String phoneNumber);

    /**
     * The function checks if a given login is not already occupied.
     *
     * @param login A string representing the login name that needs to be validated.
     * @return The method is returning a boolean value.
     */
    Boolean validateLoginNotOccupiedYet(String login);
}
