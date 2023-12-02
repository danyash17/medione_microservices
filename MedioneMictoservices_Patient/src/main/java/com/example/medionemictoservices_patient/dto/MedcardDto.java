package com.example.medionemictoservices_patient.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Schema(
        name = "Medcard",
        description = "Entity that contains medical details of certain patient"
)
@Data
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MedcardDto extends BaseDtoObject{

    @Schema(
            description = "Medcard creation date",
            example = "19-01-2002"
    )
    private Date dateCreated;

    @Schema(
            description = "Date until the instance of a medcard remains valid",
            example = "19-01-2007"
    )
    private Date validTo;

    @Schema(
            description = "Place where patient is officially registered his persistant home",
            example = "New York, Bake av. 67"
    )
    private String residentalAddress;

    @Schema(
            description = "Illness medcard records"
    )
    private List<IllnessDto> illnesses = new ArrayList<>();

    @Schema(
            description = "Operations medcard records"
    )
    private List<OperationDto> operations = new ArrayList<>();

}
