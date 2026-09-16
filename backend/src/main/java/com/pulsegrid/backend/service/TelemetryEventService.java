package com.pulsegrid.backend.service;

import java.time.Instant;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pulsegrid.backend.dto.CreateTelemetryRequest;
import com.pulsegrid.backend.model.MonitoredService;
import com.pulsegrid.backend.model.ServiceStatus;
import com.pulsegrid.backend.model.TelemetryEvent;
import com.pulsegrid.backend.repository.MonitoredServiceRepository;
import com.pulsegrid.backend.repository.TelementryEventRepository;

//init repositories
@Service 
public class TelemetryEventService {
    private final TelementryEventRepository telemetryRepository;
    private final MonitoredServiceRepository serviceRepository;

    public TelemetryEventService(TelementryEventRepository telemetryRepository, MonitoredServiceRepository serviceRepository){
        this.telemetryRepository = telemetryRepository;
        this.serviceRepository = serviceRepository;
    }

    public TelemetryEvent createTelemetry(CreateTelemetryRequest request){
        MonitoredService monitoredService = serviceRepository.findById(request.getServiceId()).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found"));
        TelemetryEvent event = new TelemetryEvent();

        event.setService(monitoredService);
        event.setLatencyMs(request.getLatencyMs());
        event.setStatusCode(request.getStatusCode());
        event.setCpuUsage(request.getCpuUsage());
        event.setMemoryUsage(request.getMemoryUsage());
        event.setTimestamp(Instant.now());

        updateServiceHealth(monitoredService,event);

        serviceRepository.save(monitoredService);
        return telemetryRepository.save(event);
    }

    
    public List<TelemetryEvent> getTelemetryForService(Long serviceId){
        if(!serviceRepository.existsById(serviceId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Service not found");
        }
        return telemetryRepository.findByServiceId(serviceId);
    }
    
    //Updates event status based on latency
    private void updateServiceHealth(MonitoredService service, TelemetryEvent event){
        if(event.getStatusCode()!= null && event.getStatusCode() >= 500){
            service.setStatus(ServiceStatus.WARNING);
        }
        else if(event.getLatencyMs()!= null && event.getLatencyMs()>1000){
            service.setStatus(ServiceStatus.WARNING);
        }
        else{
            service.setStatus(ServiceStatus.HEALTHY);
        }
    }

    
}
