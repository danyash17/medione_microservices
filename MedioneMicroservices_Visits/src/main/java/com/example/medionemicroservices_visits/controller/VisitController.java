package com.example.medionemicroservices_visits.controller;

import com.example.medionemicroservices_visits.dto.VisitDto;
import com.example.medionemicroservices_visits.model.MmVisitsConfig;
import com.example.medionemicroservices_visits.model.Properties;
import com.example.medionemicroservices_visits.service.IVisitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medioneapi/visits")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@Validated
public class VisitController {

    private MmVisitsConfig config;
    private IVisitService visitService;

    @GetMapping("/active/doctor")
    public ResponseEntity<List<VisitDto>> getActiveVisitsForDoctor(@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
                                                                   message = "Phone pattern must be followed")
                                                                   @RequestParam String phone) {
        List<VisitDto> visits = visitService.fetchActiveVisitsForDoctor(phone);
        return ResponseEntity.
                ok().
                body(visits);
    }

    @GetMapping("/active/patient")
    public ResponseEntity<List<VisitDto>> getActiveVisitsForPatient(@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
                                                                    message = "Phone pattern must be followed")
                                                                    @RequestParam String phone) {
        List<VisitDto> visits = visitService.fetchActiveVisitsForPatient(phone);
        return ResponseEntity.
                ok().
                body(visits);
    }

    @RateLimiter(name = "getConfigRateLimiter", fallbackMethod = "getConfigFallback")
    @GetMapping("/config")
    public String getConfig() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(config.getMsg(), config.getBuildVersion(),
                config.getMailDetails(), config.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }

    public String getConfigFallback(Throwable throwable){
        return "Service overload, please try again later";
    }

}
