package medione.service.discovery.and.registration.medioneeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MedioneEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedioneEurekaServerApplication.class, args);
    }

}
