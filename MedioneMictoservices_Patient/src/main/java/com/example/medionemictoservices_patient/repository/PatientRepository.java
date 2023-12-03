package com.example.medionemictoservices_patient.repository;

import com.example.medionemictoservices_patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    Optional<Patient> getByCredentialsPhone(String phone);

}
