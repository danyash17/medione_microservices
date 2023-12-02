package com.example.medionemicroservices_visits.model;

import com.example.medionemicroservices_visits.resolver.DedupingObjectIdResolver;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "visit", schema = "medione")
public class Visit extends BaseModelObject{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "datetime", columnDefinition = "DATE")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS", timezone="Europe/Moscow")
    private Date datetime;
    @Basic
    @Column(name = "diagnosis")
    private String diagnosis;
    @Basic
    @Column(name = "comments")
    private String comments;
    @Basic
    @Column(name = "init_reason")
    private String reason;
    @Basic
    @Column(name = "active")
    private Boolean active;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Patient.class, resolver = DedupingObjectIdResolver.class)
    private Patient patient;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "doctor_id")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Doctor.class, resolver = DedupingObjectIdResolver.class)
    private Doctor doctor;


    public Visit() {
    }

    public Visit(Date datetime, String diagnosis, String comments, String reason, Boolean active) {
        this.datetime = datetime;
        this.diagnosis = diagnosis;
        this.comments = comments;
        this.reason = reason;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id) && Objects.equals(datetime, visit.datetime) && Objects.equals(diagnosis, visit.diagnosis) && Objects.equals(comments, visit.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datetime, diagnosis, comments);
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
