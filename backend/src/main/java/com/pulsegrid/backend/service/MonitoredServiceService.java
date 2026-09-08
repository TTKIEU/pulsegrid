package com.pulsegrid.backend.service;

import com.pulsegrid.backend.model.MonitoredService;
import com.pulsegrid.backend.repository.MonitoredServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoredServiceService{
    //instead of creating another MonitoredServiceRepo object in this instance,
    //Spring will make and inject it
    private final MonitoredServiceRepository repository;

    public MonitoredServiceService(MonitoredServiceRepository repository){
        this.repository = repository;
    }
    public List<MonitoredService> getAllServices(){
        return repository.findAll();
    }
    public MonitoredService createService(MonitoredService service){
        return repository.save(service);
    }
}