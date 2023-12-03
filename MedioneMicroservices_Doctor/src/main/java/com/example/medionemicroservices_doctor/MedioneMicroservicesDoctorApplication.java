package com.example.medionemicroservices_doctor;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@RefreshScope
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
        info = @Info(
                title = "Doctor microservice REST API Documentation",
                description = "Medione Doctor microservice REST API Documentation",
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
public class MedioneMicroservicesDoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneMicroservicesDoctorApplication.class, args);
    }

}
