package com.example.medionemicroservices_visits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@RefreshScope
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class MedioneMicroservicesVisitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneMicroservicesVisitsApplication.class, args);
    }

}
