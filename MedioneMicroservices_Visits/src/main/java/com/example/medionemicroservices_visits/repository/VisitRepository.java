package com.example.medionemicroservices_visits.repository;

import com.example.medionemicroservices_visits.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> getVisitsByDoctorCredentialsPhoneAndActive(String phone, Boolean active);
    List<Visit> getVisitsByPatientCredentialsPhoneAndActive(String phone, Boolean active);

}
