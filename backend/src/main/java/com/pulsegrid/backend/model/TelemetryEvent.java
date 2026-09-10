package com.pulsegrid.backend.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "telemetry_events")
public class TelemetryEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double latencyMs;

    private Integer statusCode;

    private Double cpuUsage;

    private Double memoryUsage;

    private Instant timestamp;

    //many telemetry rows can point to one monitored service
    //service_id is pointing to monitored_services.id
    // id | latency | status | cpu | memory | service_id
    // -------------------------------------------------
    // 1  | 52.0    | 200    | 42  | 61     | 3
    // i.e. this telemetry record belongs to service 3
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