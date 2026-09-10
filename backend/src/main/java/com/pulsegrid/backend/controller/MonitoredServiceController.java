package com.pulsegrid.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pulsegrid.backend.model.MonitoredService;
import com.pulsegrid.backend.service.MonitoredServiceService;




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

    //@PathVariable tells Spring to take variable from the path i.e. /api/services/7
    @GetMapping("/{id}")
    public MonitoredService getServiceById(@PathVariable Long id) {
        return service.getServiceById(id);
    }

    @DeleteMapping("/{id}") 
    public void deleteService(@PathVariable Long id){
        service.deleteService(id);
    }
    
}