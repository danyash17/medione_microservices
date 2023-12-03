package com.example.medionemicroservices_visits.service.impl;

import com.example.medionemicroservices_visits.dto.VisitDto;
import com.example.medionemicroservices_visits.exception.NoPayloadProvidedException;
import com.example.medionemicroservices_visits.mapper.VisitMapper;
import com.example.medionemicroservices_visits.model.Visit;
import com.example.medionemicroservices_visits.repository.VisitRepository;
import com.example.medionemicroservices_visits.service.IVisitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VisitServiceImpl implements IVisitService {

    private VisitRepository visitRepository;
    private VisitMapper visitMapper;


    @Override
    public List<VisitDto> fetchActiveVisitsForDoctor(String doctorPhone) {
        if (doctorPhone == null){
            throw new NoPayloadProvidedException("doctorPhone");
        }
        List<Visit> visits = visitRepository.getVisitsByDoctorCredentialsPhoneAndActive(doctorPhone, true);
        return visits.stream().map(visit -> {
            VisitDto visitDto = new VisitDto();
            visitMapper.mapModelToDto(visit, visitDto);
            return visitDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<VisitDto> fetchActiveVisitsForPatient(String patientPhone) {
        if (patientPhone == null){
            throw new NoPayloadProvidedException("patientPhone");
        }
        List<Visit> visits = visitRepository.getVisitsByPatientCredentialsPhoneAndActive(patientPhone, true);
        return visits.stream().map(visit -> {
            VisitDto visitDto = new VisitDto();
            visitMapper.mapModelToDto(visit, visitDto);
            return visitDto;
        }).collect(Collectors.toList());
    }
}
