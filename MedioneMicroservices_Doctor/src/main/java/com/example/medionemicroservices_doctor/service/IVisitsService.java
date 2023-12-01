package com.example.medionemicroservices_doctor.service;

import com.example.medionemicroservices_doctor.dto.PatientDto;

import java.util.List;

public interface IVisitsService {

    /**
     * The function fetches a list of patient data from active visits based on the doctor's phone number.
     *
     * @param doctorPhone A string representing the phone number of the doctor.
     * @return The method fetchPatientsFromActiveVisits is returning a List of PatientDto objects.
     */
    List<PatientDto> fetchPatientsFromActiveVisits(String doctorPhone);

}
