package com.medione.config.server.medioneconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MedioneConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneConfigServerApplication.class, args);
    }

}
