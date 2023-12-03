package com.example.medionemicroservices_visits.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Schema(
        name = "Operation",
        description = "Entity that contains information of a patient surgery or related operation"
)
@Data
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class OperationDto extends BaseDtoObject{

    @Schema(
            description = "Date when operation was performed",
            example = "19-02-2003"
    )
    private Date operationDate;

    @Schema(
            description = "Terminological operation name",
            example = "Vitrectomy"
    )
    private String name;

    @Schema(
            description = "Notes about the way operation performed",
            example = "The patient's vital signs remained stable throughout the surgery, indicating a good outcome"
    )
    private String description;

}
