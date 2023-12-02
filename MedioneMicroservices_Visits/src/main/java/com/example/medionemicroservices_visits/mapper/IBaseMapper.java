package com.example.medionemicroservices_visits.mapper;

import com.example.medionemicroservices_visits.dto.BaseDtoObject;
import com.example.medionemicroservices_visits.model.BaseModelObject;

public interface IBaseMapper<M extends BaseModelObject,D extends BaseDtoObject> {

    void mapDtoToModel(D dto, M model);

    void mapModelToDto(M model, D dto);

}
