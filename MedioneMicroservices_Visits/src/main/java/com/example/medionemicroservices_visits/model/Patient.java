package com.example.medionemicroservices_visits.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name="patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient extends BaseModelObject{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_credential_id")
    private Credentials credentials;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medcard_id")
    private Medcard medcard;

    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public Medcard getMedcard() {
        return medcard;
    }

    public void setMedcard(Medcard medcard) {
        this.medcard = medcard;
    }

    @PreRemove
    public void preRemove(){
        if(medcard != null) {
            medcard.setPatient(null);
        }
    }
}
