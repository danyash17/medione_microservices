package com.medione.MedioneMicroservices_Message.function;

import com.medione.MedioneMicroservices_Message.dto.DoctorMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunctions {

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<DoctorMessageDto, DoctorMessageDto> sms() {
        return doctorMessageDto -> {
            LOGGER.info(String.format("Sending sms to %s",
                    doctorMessageDto.doctorPhone()));
            return doctorMessageDto;
        };
    }

    @Bean
    public Function<DoctorMessageDto, DoctorMessageDto> email() {
        return doctorMessageDto -> {
            LOGGER.info(String.format("Sending email"));
            return doctorMessageDto;
        };
    }

}
