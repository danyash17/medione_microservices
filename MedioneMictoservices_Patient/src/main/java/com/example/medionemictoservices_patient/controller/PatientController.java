package com.example.medionemictoservices_patient.controller;

import com.example.medionemictoservices_patient.config.MmPatientConfig;
import com.example.medionemictoservices_patient.dto.PatientDto;
import com.example.medionemictoservices_patient.model.Patient;
import com.example.medionemictoservices_patient.model.Properties;
import com.example.medionemictoservices_patient.repository.PatientRepository;
import com.example.medionemictoservices_patient.service.IPatientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/medioneapi/patient")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@Validated
public class PatientController {

    private MmPatientConfig config;
    private IPatientService patientService;

    @Operation(
            summary = "Get Patient REST API",
            description = "REST API to get Patient and his details in Medione"
    )
    @ApiResponse(
            responseCode = "302",
            description = "HTTP Status FOUND"
    )
    @GetMapping("/fetch")
    public ResponseEntity<PatientDto> fetchPatient(@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
                                                   @RequestParam String phone) {
        PatientDto patientDto = patientService.fetchPatientByPhone(phone);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(patientDto);
    }

    @Operation(
            summary = "Fetch environmental config",
            description = "REST API to fetch current profile configuration"
    )
    @Retry(name = "getConfig", fallbackMethod = "getConfigFallback")
    @GetMapping("/config")
    public String getConfig() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(config.getMsg(), config.getBuildVersion(),
                config.getMailDetails(), config.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }

    public String getConfigFallback(Throwable throwable) {
        return "Please visit Config server git to obtain configs";
    }

}
