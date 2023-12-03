package com.example.medionemictoservices_patient.mapper;

import com.example.medionemictoservices_patient.dto.IllnessDto;
import com.example.medionemictoservices_patient.model.Illness;
import org.springframework.stereotype.Component;

@Component
public class IllnessMapper implements IBaseMapper<Illness, IllnessDto>{

    @Override
    public void mapDtoToModel(IllnessDto dto, Illness model) {
        model.setDescription(dto.getDescription());
        model.setIllFrom(new java.sql.Date(dto.getIllFrom().getTime()));
        model.setIllTo(new java.sql.Date(dto.getIllTo().getTime()));
    }

    @Override
    public void mapModelToDto(Illness model, IllnessDto dto) {
        dto.setDescription(model.getDescription());
        dto.setIllFrom(new java.util.Date(model.getIllFrom().getTime()));
        dto.setIllTo(new java.util.Date(model.getIllTo().getTime()));
    }
}
