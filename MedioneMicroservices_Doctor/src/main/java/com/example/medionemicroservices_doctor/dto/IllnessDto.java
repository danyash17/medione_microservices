package com.example.medionemicroservices_doctor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Schema(
        name = "Illness",
        description = "Entity that contains information of a periodic ill case of a patient"
)
@Data
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class IllnessDto extends BaseDtoObject{

    @Schema(
            description = "Start of illness period",
            example = "19-01-2003"
    )
    private Date illFrom;

    @Schema(
            description = "End of illness period",
            example = "24-01-2003"
    )
    private Date illTo;

    @Schema(
            description = "Notes about illness case",
            example = "Severe back pain and lower extremities weakness in a young male\n" +
                    "Case of bilateral non-traumatic subperiosteal orbital haematomas\n" +
                    "A painful forefoot mass\n" +
                    "Spinal arachnoiditis as a consequence of aneurysm-related subarachnoid haemorrhage\n" +
                    "An 85-year-old male with abdominal pain and previous gastric surgery"
    )
    private String description;

}
