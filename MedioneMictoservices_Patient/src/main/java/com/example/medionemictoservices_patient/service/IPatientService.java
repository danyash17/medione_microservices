package com.example.medionemictoservices_patient.service;

import com.example.medionemictoservices_patient.dto.PatientDto;

public interface IPatientService {

    /**
     * The function fetches a patient's information based on their phone number.
     *
     * @param phone A string representing the phone number of the patient.
     * @return The method fetchPatientByPhone returns a PatientDto object.
     */
    PatientDto fetchPatientByPhone(String phone);

}
