package com.example.medionemicroservices_doctor.service.feign;

import com.example.medionemicroservices_doctor.dto.VisitDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VisitsFallback implements VisitsFeignClient{
    @Override
    public ResponseEntity<List<VisitDto>> getActiveVisitsForDoctor(String phone) {
        return null;
    }
}
