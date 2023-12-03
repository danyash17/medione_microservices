package com.example.medionemicroservices_doctor.mapper;

import com.example.medionemicroservices_doctor.dto.BaseDtoObject;
import com.example.medionemicroservices_doctor.model.BaseModelObject;

public interface IBaseMapper<M extends BaseModelObject,D extends BaseDtoObject> {

    void mapDtoToModel(D dto, M model);

    void mapModelToDto(M model, D dto);

}
