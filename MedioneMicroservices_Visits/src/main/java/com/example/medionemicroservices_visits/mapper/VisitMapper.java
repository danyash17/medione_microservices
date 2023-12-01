package com.example.medionemicroservices_visits.mapper;

import com.example.medionemicroservices_visits.dto.VisitDto;
import com.example.medionemicroservices_visits.model.Visit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class VisitMapper implements IBaseMapper<Visit, VisitDto>{

    private PatientMapper patientMapper;
    private DoctorMapper doctorMapper;

    @Override
    public void mapDtoToModel(VisitDto dto, Visit model) {
        model.setActive(dto.getActive());
        model.setComments(dto.getComments());
        model.setDatetime(new java.sql.Date(dto.getDatetime().getTime()));
        model.setDiagnosis(dto.getDiagnosis());
        model.setReason(dto.getReason());
        patientMapper.mapDtoToModel(dto.getPatient(), model.getPatient());
        doctorMapper.mapDtoToModel(dto.getDoctor(), model.getDoctor());
    }

    @Override
    public void mapModelToDto(Visit model, VisitDto dto) {
        dto.setActive(model.getActive());
        dto.setComments(model.getComments());
        dto.setDatetime(new java.util.Date(model.getDatetime().getTime()));
        dto.setDiagnosis(model.getDiagnosis());
        dto.setReason(model.getReason());
        patientMapper.mapModelToDto(model.getPatient(), dto.getPatient());
        doctorMapper.mapModelToDto(model.getDoctor(), dto.getDoctor());
    }
}
