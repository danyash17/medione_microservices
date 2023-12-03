package com.example.medionemicroservices_visits.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Doctor",
        description = "Entity that contains doctor information (medical and personal)"
)
public class DoctorDto extends BaseDtoObject implements UserDto{

    @Schema(
            description = "Hospital in which doctor working currently",
            example = "Princeton Plainsboro"
    )
    private String hospital;

    @Schema(
            description = "Flag that describes if doctor can handle visits currently"
    )
    private Boolean available;

    @NotEmpty(message = "Doctor must have description")
    @Schema(
            description = "Biographical information that may be useful for patients",
            example = "Graduated from Harvard in 1999, works as neurosurgeon for 12 years"
    )
    private String commonInfo;

    @Valid
    private CredentialsDto credentials = new CredentialsDto();

}
