package com.example.medionemicroservices_doctor.service.impl;

import com.example.medionemicroservices_doctor.exception.ResourceNotFoundException;
import com.example.medionemicroservices_doctor.model.Credentials;
import com.example.medionemicroservices_doctor.repository.CredentialsRepository;
import com.example.medionemicroservices_doctor.service.ICredentialsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CredentialsServiceImpl implements ICredentialsService {

    private CredentialsRepository credentialsRepository;

    @Override
    public Boolean validatePhoneNumberNotOccupiedYet(String phoneNumber) {
        Optional<Credentials> credentials = credentialsRepository.findCredentialsByPhone(phoneNumber);
        if (credentials.isPresent()){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean validateLoginNotOccupiedYet(String login) {
        Optional<Credentials> credentials = credentialsRepository.findCredentialsByLogin(login);
        if (credentials.isPresent()){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public Credentials fetchCredentialsByPhoneNumber(String phoneNumber) {
        Credentials credentials = credentialsRepository.findCredentialsByPhone(phoneNumber).orElseThrow(
                () -> new ResourceNotFoundException("Credentials", "phoneNumber", phoneNumber)
        );
        return credentials;
    }


}
