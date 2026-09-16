package com.pulsegrid.backend.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Create a SQL table called telemetry events
@Entity
@Table(name = "telemetry_events")
public class TelemetryEvent {

    /**
     * Id = object id
     * latency = latency
     * statusCode = is it online
     * cpuUsage = How much cpu %
     * memoryUsage = memory %
     * timestamp = last checked; stale data?
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latencyMs;

    private Integer statusCode;

    private Double cpuUsage;

    private Double memoryUsage;

    private Instant timestamp;

    //service id is a foreign key pointing to monitored service #
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private MonitoredService service;

    //getters and setters for id, latencyMs, statusCode, cpuUsage, memoryUsage, timeStamp
    public TelemetryEvent() {
    }

    public Long getId() {
        return id;
    }

    public Double getLatencyMs() {
        return latencyMs;
    }

    public void setLatencyMs(Double latencyMs) {
        this.latencyMs = latencyMs;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Double getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Double memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public MonitoredService getService() {
        return service;
    }

    public void setService(MonitoredService service) {
        this.service = service;
    }
}