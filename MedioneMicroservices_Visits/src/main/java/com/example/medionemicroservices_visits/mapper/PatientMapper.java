package com.example.medionemicroservices_visits.mapper;

import com.example.medionemicroservices_visits.dto.PatientDto;
import com.example.medionemicroservices_visits.model.Patient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PatientMapper implements IBaseMapper<Patient, PatientDto>{

    private MedcardMapper medcardMapper;
    private CredentialsMapper credentialsMapper;

    @Override
    public void mapDtoToModel(PatientDto dto, Patient model) {
        medcardMapper.mapDtoToModel(dto.getMedcard(), model.getMedcard());
        credentialsMapper.mapDtoToModel(dto.getCredentials(), model.getCredentials());
    }

    @Override
    public void mapModelToDto(Patient model, PatientDto dto) {
        medcardMapper.mapModelToDto(model.getMedcard(), dto.getMedcard());
        credentialsMapper.mapModelToDto(model.getCredentials(), dto.getCredentials());
    }
}
