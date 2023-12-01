package com.example.medionemicroservices_doctor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Schema(
        name = "Credentials",
        description = "Entity that contains details of a user"
)
public class CredentialsDto extends BaseDtoObject{

    @NotEmpty(message = "First name must be captured")
    @Schema(
            example = "John"
    )
    private String firstName;

    @NotEmpty(message = "Last name must be captured")
    @Schema(
            example = "Doe"
    )
    private String lastName;

    @Schema(
            description = "A name derived from the name of a father or ancestor",
            example = "Smiths"
    )
    private String patronymic;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",
             message = "Phone pattern must be followed")
    @Schema(
            example = "+375124432856"
    )
    private String phone;

    @Schema(
            example = "01-01-1970"
    )
    private Date birthDate;

}
