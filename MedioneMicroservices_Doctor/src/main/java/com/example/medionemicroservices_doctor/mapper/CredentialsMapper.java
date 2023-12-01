package com.example.medionemicroservices_doctor.mapper;

import com.example.medionemicroservices_doctor.dto.CredentialsDto;
import com.example.medionemicroservices_doctor.model.Credentials;
import org.springframework.stereotype.Component;

@Component
public class CredentialsMapper implements IBaseMapper<Credentials, CredentialsDto>{


    @Override
    public void mapDtoToModel(CredentialsDto dto, Credentials model) {
        model.setPhone(dto.getPhone());
        model.setFirstName(dto.getFirstName());
        model.setLastName(dto.getLastName());
        model.setPatronymic(dto.getPatronymic());
        model.setBirthDate(dto.getBirthDate());
    }

    @Override
    public void mapModelToDto(Credentials model, CredentialsDto dto) {
        dto.setPhone(model.getPhone());
        dto.setFirstName(model.getFirstName());
        dto.setLastName(model.getLastName());
        dto.setPatronymic(model.getPatronymic());
        dto.setBirthDate(model.getBirthDate());
    }

}
