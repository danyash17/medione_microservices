package com.example.medionemictoservices_patient.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.*;

@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Patient",
        description = "Entity that contains details about patient (medical and personal data)"
)
public class PatientDto extends BaseDtoObject{

    @Valid
    private CredentialsDto credentials = new CredentialsDto();

    @Valid
    private MedcardDto medcard = new MedcardDto();

}
