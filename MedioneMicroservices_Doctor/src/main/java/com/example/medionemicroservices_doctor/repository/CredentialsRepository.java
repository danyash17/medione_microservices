package com.example.medionemicroservices_doctor.repository;

import com.example.medionemicroservices_doctor.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    Optional<Credentials> findCredentialsByPhone(String phone);

    Optional<Credentials> findCredentialsByLogin(String login);

}
