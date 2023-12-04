package com.example.medionemicroservices_doctor.service.impl;

import com.example.medionemicroservices_doctor.dto.CredentialsDto;
import com.example.medionemicroservices_doctor.dto.DoctorDto;
import com.example.medionemicroservices_doctor.dto.DoctorMessageDto;
import com.example.medionemicroservices_doctor.exception.NoPayloadProvidedException;
import com.example.medionemicroservices_doctor.exception.ResourceNotFoundException;
import com.example.medionemicroservices_doctor.mapper.DoctorMapper;
import com.example.medionemicroservices_doctor.model.Credentials;
import com.example.medionemicroservices_doctor.model.Doctor;
import com.example.medionemicroservices_doctor.repository.DoctorRepository;
import com.example.medionemicroservices_doctor.service.ICredentialsService;
import com.example.medionemicroservices_doctor.service.IDoctorService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements IDoctorService {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class);

    private ICredentialsService credentialsService;
    private DoctorRepository doctorRepository;
    private DoctorMapper doctorMapper;

    private StreamBridge streamBridge;

    @Override
    public DoctorDto fetchDoctorByPhone(String phone) {
        Credentials credentials = credentialsService.fetchCredentialsByPhoneNumber(phone);
        Doctor doctor = doctorRepository.findDoctorByCredentials_Phone(credentials.getPhone()).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "phone", phone)
        );
        DoctorDto doctorDto = new DoctorDto();
        doctorMapper.mapModelToDto(doctor, doctorDto);
        return doctorDto;
    }

    @Transactional
    @Override
    public boolean updateDoctorByPhone(DoctorDto doctorDto) {
        if (doctorDto == null){
            throw new NoPayloadProvidedException("doctor");
        }
        Doctor doctor = doctorRepository.findDoctorByCredentials_Phone(doctorDto.getCredentials().getPhone()).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "phone", doctorDto.getCredentials().getPhone())
        );
        doctorMapper.mapDtoToModel(doctorDto, doctor);
        doctorRepository.save(doctor);
        sendCommunication(doctorDto);
        return true;
    }

    private void sendCommunication(DoctorDto doctorDto) {
        var doctorMsgDto = new DoctorMessageDto(doctorDto.getCredentials().getPhone());
        LOGGER.info("Sending Communication request for the details: {}", doctorMsgDto);
        var result = streamBridge.send("sendCommunication-out-0", doctorMsgDto);
        LOGGER.info("Is the Communication request successfully triggered ? : {}", result);
    }

    @Override
    public boolean deleteDoctorByPhone(String phone) {
        if (phone == null){
            throw new NoPayloadProvidedException("phone");
        }
        Doctor doctor = doctorRepository.findDoctorByCredentials_Phone(phone).orElseThrow(
                () -> new ResourceNotFoundException("Doctor", "phone", phone)
        );
        doctorRepository.delete(doctor);
        return true;
    }


}
