package com.example.medionemicroservices_doctor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Date;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Visit",
        description = "Entity that contains details about patient's visit to doctor"
)
public class VisitDto extends BaseDtoObject{

    @Schema(
            name = "Date and time",
            description = "When the visit was performed"
    )
    private Date datetime;

    @Schema(
            description = "Preliminary diagnosis based on visit's results"
    )
    private String diagnosis;

    private String comments;

    @Schema(
            description = "The reason why visit was booked by patient"
    )
    private String reason;

    @Schema(
            description = "Is visit in pending status"
    )
    private Boolean active;

    @Valid
    @Schema(
            name = "Patient",
            description = "Patient that went to the visit"
    )
    private PatientDto patient = new PatientDto();

    @Valid
    @Schema(
            name = "Doctor",
            description = "Doctor that held a visit"
    )
    private DoctorDto doctor = new DoctorDto();

}
