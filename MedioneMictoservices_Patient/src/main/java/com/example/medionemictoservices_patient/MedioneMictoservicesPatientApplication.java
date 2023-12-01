package com.example.medionemictoservices_patient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@RefreshScope
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Patient microservice REST API Documentation",
                description = "Medione Patient microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Medione Dev team",
                        email = "medionedev@gmail.com",
                        url = "https://www.medione.io"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.medione.io"
                )
        )
)
public class MedioneMictoservicesPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneMictoservicesPatientApplication.class, args);
    }

}
