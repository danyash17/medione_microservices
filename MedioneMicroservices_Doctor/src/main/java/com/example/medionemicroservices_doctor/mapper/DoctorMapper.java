package com.example.medionemicroservices_doctor.mapper;

import com.example.medionemicroservices_doctor.dto.DoctorDto;
import com.example.medionemicroservices_doctor.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper implements IBaseMapper<Doctor, DoctorDto>{

    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public void mapDtoToModel(DoctorDto dto, Doctor model) {
        model.setHospital(dto.getHospital());
        credentialsMapper.mapDtoToModel(dto.getCredentials(), model.getCredentials());
        model.setAvailable(dto.getAvailable());
        model.setCommonInfo(dto.getCommonInfo());
    }

    @Override
    public void mapModelToDto(Doctor model, DoctorDto dto) {
        dto.setHospital(model.getHospital());
        credentialsMapper.mapModelToDto(model.getCredentials(), dto.getCredentials());
        dto.setAvailable(model.getAvailable());
        dto.setCommonInfo(model.getCommonInfo());
    }

}
