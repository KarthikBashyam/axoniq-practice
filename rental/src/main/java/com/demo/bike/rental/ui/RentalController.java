package com.demo.bike.rental.ui;

import io.axoniq.practice.bikerental.commonapi.BikeStatus;
import io.axoniq.practice.bikerental.commonapi.RegisterBikeCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@RestController
public class RentalController {

    private static final List<String> LOCATIONS = List.of("Toronto","Montreal","Milan","Vienna");

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public RentalController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public String welcome() {
        return "Welcome to AxonIQ";
    }

    @PostMapping(path = "/setup")
    public CompletableFuture<Void> setupBikes() {
        CompletableFuture<Void> all = CompletableFuture.completedFuture(null);
        for (int i = 1; i <= 10; i++) {
            CompletableFuture.allOf(all, commandGateway.send(new RegisterBikeCommand(UUID.randomUUID().toString(), "Hero",getLocation())));
        }
        return all;
    }

    @GetMapping(path = "/bikes")
    public CompletableFuture<List<BikeStatus>> getBikes() {
        return queryGateway.query("findAll",null, ResponseTypes.multipleInstancesOf(BikeStatus.class));
    }

    private String getLocation() {
        return LOCATIONS.get(ThreadLocalRandom.current().nextInt(LOCATIONS.size()));
    }

}
