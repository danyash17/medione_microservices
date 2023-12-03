package com.example.medionemicroservices_doctor.service;

import com.example.medionemicroservices_doctor.dto.DoctorDto;

public interface IDoctorService {

    /**
     * The function fetches a doctor's information based on their phone number.
     *
     * @param phone A string representing the phone number of the doctor.
     * @return The method fetchDoctorByPhone is returning an object of type DoctorDto.
     */
    DoctorDto fetchDoctorByPhone(String phone);

    /**
     * The function updates a doctor's information based on their phone number.
     *
     * @param doctorDto A DoctorDto object that contains the updated information for the doctor.
     * @return The method is returning a boolean value.
     */
    boolean updateDoctorByPhone(DoctorDto doctorDto);

    /**
     * The function deletes a doctor from a database based on their phone number.
     *
     * @param phone A string representing the phone number of the doctor to be deleted.
     * @return A boolean value is being returned.
     */
    boolean deleteDoctorByPhone(String phone);

}
