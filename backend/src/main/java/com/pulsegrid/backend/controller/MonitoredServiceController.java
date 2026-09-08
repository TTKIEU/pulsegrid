package com.pulsegrid.backend.controller;

import com.pulsegrid.backend.model.MonitoredService;
import com.pulsegrid.backend.service.MonitoredServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class MonitoredServiceController{
    private final MonitoredServiceService service;

    public MonitoredServiceController(MonitoredServiceService service) {
        this.service = service;
    }

    @GetMapping
    public List<MonitoredService> getServices() {
        return service.getAllServices();
    }

    @PostMapping
    public MonitoredService createService(@RequestBody MonitoredService monitoredService) {
        return service.createService(monitoredService);
    }
}