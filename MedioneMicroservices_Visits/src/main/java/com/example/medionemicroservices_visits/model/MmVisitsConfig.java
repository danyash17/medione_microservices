package com.example.medionemicroservices_visits.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "mmvisits")
@Getter
@Setter
@NoArgsConstructor
public class MmVisitsConfig {

    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;
    private List<String> activeBranches;

}
