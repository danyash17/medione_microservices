package com.example.medionemictoservices_patient.mapper;

import com.example.medionemictoservices_patient.dto.BaseDtoObject;
import com.example.medionemictoservices_patient.model.BaseModelObject;

public interface IBaseMapper<M extends BaseModelObject,D extends BaseDtoObject> {

    void mapDtoToModel(D dto, M model);

    void mapModelToDto(M model, D dto);

}
