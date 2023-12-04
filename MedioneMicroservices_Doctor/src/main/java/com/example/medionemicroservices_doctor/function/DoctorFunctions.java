package com.example.medionemicroservices_doctor.function;

import com.example.medionemicroservices_doctor.dto.DoctorMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class DoctorFunctions {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoctorFunctions.class);
    @Bean
    public Consumer<DoctorMessageDto> updateCommunication(){
        return doctorMessageDto -> {
            LOGGER.info(String.format("Doctor with phone %s was informed about account update",
                    doctorMessageDto.doctorPhone()));
        };
    }

}
