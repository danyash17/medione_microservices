package com.example.medionemicroservices_visits.mapper;

import com.example.medionemicroservices_visits.dto.IllnessDto;
import com.example.medionemicroservices_visits.dto.MedcardDto;
import com.example.medionemicroservices_visits.dto.OperationDto;
import com.example.medionemicroservices_visits.model.Illness;
import com.example.medionemicroservices_visits.model.Medcard;
import com.example.medionemicroservices_visits.model.Operation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class MedcardMapper implements IBaseMapper<Medcard, MedcardDto>{

    private IllnessMapper illnessMapper;
    private OperationMapper operationMapper;
    private CredentialsMapper credentialsMapper;

    @Override
    public void mapDtoToModel(MedcardDto dto, Medcard model) {
        model.setDateCreated(new java.sql.Date(dto.getDateCreated().getTime()));
        model.setValidTo(new java.sql.Date(dto.getValidTo().getTime()));
        model.setResidentalAddress(dto.getResidentalAddress());
        model.setIllnessList(dto.getIllnesses().stream()
                .map(illnessDto -> {
                    Illness illness = new Illness();
                    illnessMapper.mapDtoToModel(illnessDto, illness);
                    return illness;
                }).collect(Collectors.toList()));
        model.setOperationList(dto.getOperations().stream()
                .map(operationDto -> {
                    Operation operation = new Operation();
                    operationMapper.mapDtoToModel(operationDto, operation);
                    return operation;
                }).collect(Collectors.toList()));
    }

    @Override
    public void mapModelToDto(Medcard model, MedcardDto dto) {
        dto.setDateCreated(new java.util.Date(model.getDateCreated().getTime()));
        dto.setValidTo(new java.util.Date(model.getValidTo().getTime()));
        dto.setResidentalAddress(model.getResidentalAddress());
        dto.setIllnesses(model.getIllnessList().stream()
                .map(illness -> {
                    IllnessDto illnessDto = new IllnessDto();
                    illnessMapper.mapModelToDto(illness, illnessDto);
                    return illnessDto;
                }).collect(Collectors.toList()));
        dto.setOperations(model.getOperationList().stream()
                .map(operation -> {
                    OperationDto operationDto = new OperationDto();
                    operationMapper.mapModelToDto(operation, operationDto);
                    return operationDto;
                }).collect(Collectors.toList()));
    }
}
