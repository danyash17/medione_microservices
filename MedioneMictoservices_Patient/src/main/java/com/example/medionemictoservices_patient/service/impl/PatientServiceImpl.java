package com.example.medionemictoservices_patient.service.impl;

import com.example.medionemictoservices_patient.dto.PatientDto;
import com.example.medionemictoservices_patient.exception.NoPayloadProvidedException;
import com.example.medionemictoservices_patient.exception.ResourceNotFoundException;
import com.example.medionemictoservices_patient.mapper.PatientMapper;
import com.example.medionemictoservices_patient.model.Patient;
import com.example.medionemictoservices_patient.repository.PatientRepository;
import com.example.medionemictoservices_patient.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private PatientMapper patientMapper;
    private PatientRepository patientRepository;

    @Override
    public PatientDto fetchPatientByPhone(String phone) {
        if (phone == null){
            throw new NoPayloadProvidedException("phone");
        }
        Patient patient = patientRepository.getByCredentialsPhone(phone).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "phone", phone)
        );
        PatientDto dto = new PatientDto();
        patientMapper.mapModelToDto(patient, dto);
        return dto;
    }

}
