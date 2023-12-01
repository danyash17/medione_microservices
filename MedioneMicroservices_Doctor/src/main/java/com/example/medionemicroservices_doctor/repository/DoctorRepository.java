package com.example.medionemicroservices_doctor.repository;

import com.example.medionemicroservices_doctor.model.Credentials;
import com.example.medionemicroservices_doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Optional<Doctor> findDoctorByCredentials_Phone(String phone);
}
