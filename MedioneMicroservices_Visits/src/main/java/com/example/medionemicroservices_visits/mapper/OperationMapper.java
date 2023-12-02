package com.example.medionemicroservices_visits.mapper;

import com.example.medionemicroservices_visits.dto.OperationDto;
import com.example.medionemicroservices_visits.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class OperationMapper implements IBaseMapper<Operation, OperationDto>{

    @Override
    public void mapDtoToModel(OperationDto dto, Operation model) {
        model.setDescription(dto.getDescription());
        model.setName(dto.getName());
        model.setOperationDate(new java.sql.Date(dto.getOperationDate().getTime()));
    }

    @Override
    public void mapModelToDto(Operation model, OperationDto dto) {
        dto.setDescription(model.getDescription());
        dto.setName(model.getName());
        dto.setOperationDate(new java.util.Date(model.getOperationDate().getTime()));
    }
}
