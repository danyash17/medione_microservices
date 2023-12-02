package com.example.medionemicroservices_doctor.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Entity that contains details about occurred error"
)
public class ErrorResponseDto{

    @Schema(
            description = "HTTP code of an error"
    )
    private HttpStatus statusCode;

    private String errorMessage;

    @Schema(
            description = "URL of API that thrown an error"
    )
    private String apiPath;

    @Schema(
            description = "Timestamp of error"
    )
    private LocalDateTime errorTime;

}
