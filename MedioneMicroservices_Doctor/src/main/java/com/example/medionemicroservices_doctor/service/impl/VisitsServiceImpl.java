package com.example.medionemicroservices_doctor.service.impl;

import com.example.medionemicroservices_doctor.dto.PatientDto;
import com.example.medionemicroservices_doctor.dto.VisitDto;
import com.example.medionemicroservices_doctor.exception.NoPayloadProvidedException;
import com.example.medionemicroservices_doctor.service.IVisitsService;
import com.example.medionemicroservices_doctor.service.feign.VisitsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class VisitsServiceImpl implements IVisitsService {

    @Autowired
    private VisitsFeignClient visitsFeignClient;

    @Override
    public List<PatientDto> fetchPatientsFromActiveVisits(String doctorPhone) {
        if (doctorPhone == null){
            throw new NoPayloadProvidedException("doctorPhone");
        }
        ResponseEntity<List<VisitDto>> response = visitsFeignClient.getActiveVisitsForDoctor(doctorPhone);
        if (response == null) {
            return null;
        }
        return response.getBody().stream().map(VisitDto::getPatient).toList();
    }

}
