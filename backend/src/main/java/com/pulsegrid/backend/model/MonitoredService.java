package com.pulsegrid.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Store this class into a relational database
//Translates name -> SQL name VARCHAR()
@Entity
@Table(name="monitored_services")
public class MonitoredService{
    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Mapping is such that Obj -> Row
    @Column(nullable = false)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ServiceStatus status = ServiceStatus.UNKNOWN;

    public MonitoredService(){}

    public MonitoredService(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Long getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public ServiceStatus getStatus(){
        return status;
    }

    public void setStatus(ServiceStatus status){
        this.status = status;
    }
}