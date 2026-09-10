package com.pulsegrid.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pulsegrid.backend.model.MonitoredService;
import com.pulsegrid.backend.repository.MonitoredServiceRepository;

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
    public MonitoredService getServiceById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Service Not Found"));
    }
    public void deleteService(Long id){
        repository.deleteById(id);
    }
}