package com.demo.bike.rental.query;

import io.axoniq.practice.bikerental.commonapi.BikeRegisteredEvent;
import io.axoniq.practice.bikerental.commonapi.BikeStatus;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BikeStatusProjection {

    private BikeStatusRepository repository;

    @Autowired
    public BikeStatusProjection(BikeStatusRepository repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(BikeRegisteredEvent event) {
        repository.save(new BikeStatus(event.getBikeId(), event.getBikeType(), event.getLocation()));
    }

    @QueryHandler(queryName = "findAll")
    public List<BikeStatus> findAll() {
        return repository.findAll();
    }
}
