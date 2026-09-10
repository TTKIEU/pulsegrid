package com.pulsegrid.backend.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        return repository.findById(id).orElseThrow(() -> 
        //OLD method = flase server failure; returns 404 now
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Service Not Found"));
    }
    public void deleteService(Long id){

        MonitoredService monitoredService = repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Service not found"));
        repository.delete(monitoredService);
    }
}