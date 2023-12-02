package com.example.medionemicroservices_doctor.service.feign;

import com.example.medionemicroservices_doctor.dto.VisitDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mmvisits", fallback = VisitsFallback.class)
public interface VisitsFeignClient {

    @GetMapping("/medioneapi/visits/active/doctor")
    ResponseEntity<List<VisitDto>> getActiveVisitsForDoctor(@RequestParam String phone);

}
