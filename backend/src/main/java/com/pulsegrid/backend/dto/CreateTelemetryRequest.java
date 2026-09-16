package com.pulsegrid.backend.dto;

//instead of sending full TelemetryEvent
public class CreateTelemetryRequest {
    private Long serviceId;
    private Double latencyMs;
    private Integer statusCode;
    private Double cpuUsage;
    private Double memoryUsage;

    //ServiceId
    public Long getServiceId(){
        return serviceId;
    }

    public void setServiceId(Long serviceId){
        this.serviceId = serviceId;
    }

    public void setLatencyMs(Double latencyMs) {
        this.latencyMs = latencyMs;
    }

    public Double getLatencyMs(){
        return latencyMs;
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

    
}
