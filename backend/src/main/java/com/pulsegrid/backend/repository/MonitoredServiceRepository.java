package com.pulsegrid.backend.repository;

import com.pulsegrid.backend.model.MonitoredService
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitoredServiceRepository
    extends JpaRepository<MonitoredService, Long>{
        // gives SQL functions like findAll, findById, save, delete, and count
    }