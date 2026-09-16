package com.pulsegrid.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pulsegrid.backend.model.TelemetryEvent;

public interface TelementryEventRepository extends JpaRepository<TelemetryEvent, Long>{
    //Spring Data will read the method name and generate query 
    //SELECT * FROM telemetry_events WHERE service_id = ?;
    List<TelemetryEvent> findByServiceId(Long serviceId);
    
}
