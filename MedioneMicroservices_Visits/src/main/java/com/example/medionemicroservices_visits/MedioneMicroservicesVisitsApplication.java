package com.example.medionemicroservices_visits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class MedioneMicroservicesVisitsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneMicroservicesVisitsApplication.class, args);
    }

}
