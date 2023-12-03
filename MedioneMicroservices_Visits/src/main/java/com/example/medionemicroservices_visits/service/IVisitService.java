package com.example.medionemicroservices_visits.service;

import com.example.medionemicroservices_visits.dto.VisitDto;

import java.util.List;

public interface IVisitService {

    /**
     * The function fetches active visits for a doctor based on their phone number.
     *
     * @param doctorPhone A string representing the phone number of the doctor.
     * @return The method fetchActiveVisitsForDoctor is returning a List of VisitDto objects.
     */
    List<VisitDto> fetchActiveVisitsForDoctor(String doctorPhone);

    /**
     * The function fetches active visits for a patient based on their phone number.
     *
     * @param patientPhone A string representing the phone number of the patient.
     * @return The method fetchActiveVisitsForPatient is returning a List of VisitDto objects.
     */
    List<VisitDto> fetchActiveVisitsForPatient(String patientPhone);

}
