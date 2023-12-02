package com.example.medionemicroservices_doctor.controller;

import com.example.medionemicroservices_doctor.constants.DoctorConstants;
import com.example.medionemicroservices_doctor.dto.DoctorDto;
import com.example.medionemicroservices_doctor.dto.ErrorResponseDto;
import com.example.medionemicroservices_doctor.dto.PatientDto;
import com.example.medionemicroservices_doctor.dto.ResponseDto;
import com.example.medionemicroservices_doctor.model.config.MmDoctorConfig;
import com.example.medionemicroservices_doctor.model.config.Properties;
import com.example.medionemicroservices_doctor.service.IDoctorService;
import com.example.medionemicroservices_doctor.service.IVisitsService;
import com.example.medionemicroservices_doctor.service.feign.VisitsFeignClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/medioneapi/doctor", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@Validated
@Tag(
        name = "REST API for Doctors in Medione",
        description = "REST API in Medione to UPDATE, FETCH AND DELETE doctor and their details"
)
public class DoctorContoller {
    public static final Logger LOGGER = LoggerFactory.getLogger(DoctorContoller.class);

    private MmDoctorConfig config;
    private IDoctorService doctorService;
    private IVisitsService visitsService;

    @Operation(
            summary = "Get Doctor REST API",
            description = "REST API to get Doctor and his details in Medione"
    )
    @ApiResponse(
            responseCode = "302",
            description = "HTTP Status FOUND"
    )
    @GetMapping("/fetch")
    public ResponseEntity<DoctorDto> fetchDoctor(@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
                                                 @RequestParam String phone){
        LOGGER.debug("Fetch doctor started");
        DoctorDto doctorDto = doctorService.fetchDoctorByPhone(phone);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(doctorDto);
    }

    @Operation(
            summary = "Update Doctor REST API",
            description = "REST API to update Doctor and his details in Medione"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateDoctor(@Valid @RequestBody DoctorDto doctorDto){
        boolean success = doctorService.updateDoctorByPhone(doctorDto);
        if (success){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(HttpStatus.OK, DoctorConstants.DOCTOR_UPDATED));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, DoctorConstants.DOCTOR_FAIL_UPDATE));
        }
    }

    @Operation(
            summary = "Delete Doctor REST API",
            description = "REST API to delete Doctor and his details in Medione"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK",
                    content = @Content(
                            schema = @Schema(implementation = ResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteDoctor(@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
                                                    @RequestParam String phone){
        boolean success = doctorService.deleteDoctorByPhone(phone);
        if (success){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(HttpStatus.OK, DoctorConstants.DOCTOR_DELETED));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto(HttpStatus.INTERNAL_SERVER_ERROR, DoctorConstants.DOCTOR_FAIL_DELETE));
        }
    }

    @Operation(
            summary = "Get active patients from upcoming visits REST API",
            description = "REST API to get patients that will come soon to doctor in Medione"
    )
    @ApiResponse(
            responseCode = "302",
            description = "HTTP Status Found",
            content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
            )
    )
    @GetMapping("/fetch/active/patients")
    public ResponseEntity<List<PatientDto>> fetchPatientsFromActiveVisits(@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
                                                 @RequestParam String doctorPhone){
        List<PatientDto> patientDtos = visitsService.fetchPatientsFromActiveVisits(doctorPhone);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(patientDtos);
    }

    @Operation(
            summary = "Fetch environmental config",
            description = "REST API to fetch current profile configuration"
    )
    @GetMapping("/config")
    public String getConfig() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Properties properties = new Properties(config.getMsg(), config.getBuildVersion(),
                config.getMailDetails(), config.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }

}
