package com.example.medionemicroservices_visits.model;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "doctor", schema = "medione")
@EqualsAndHashCode
public class Doctor extends BaseModelObject{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "hospital")
    private String hospital;
    @Basic
    @Column(name = "available")
    private Boolean available;
    @Basic
    @Column(name = "common_info")
    private String commonInfo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_credential_id")
    private Credentials credentials;

    public Doctor() {
    }

    public Doctor(String hospital, Boolean available, String commonInfo, Credentials credentials) {
        this.hospital = hospital;
        this.available = available;
        this.commonInfo = commonInfo;
        this.credentials = credentials;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getCommonInfo() {
        return commonInfo;
    }

    public void setCommonInfo(String commonInfo) {
        this.commonInfo = commonInfo;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
}
