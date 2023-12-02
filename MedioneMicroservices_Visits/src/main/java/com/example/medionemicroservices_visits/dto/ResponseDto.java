package com.example.medionemicroservices_visits.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Entity that contains details about successful API call"
)
public class ResponseDto{

    @Schema(
            description = "HTTP status code"
    )
    private HttpStatus statusCode;

    private String statusMessage;

}
