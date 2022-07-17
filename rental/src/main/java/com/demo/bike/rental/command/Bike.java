package com.demo.bike.rental.command;

import io.axoniq.practice.bikerental.commonapi.BikeRegisteredEvent;
import io.axoniq.practice.bikerental.commonapi.RegisterBikeCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate(snapshotTriggerDefinition = "bikeSnapshotDefinition")
public class Bike {

    @AggregateIdentifier
    private String bikeId;

    private boolean isAvailable;
    public Bike() {
    }

    @CommandHandler
    public Bike(RegisterBikeCommand command) {
        apply(new BikeRegisteredEvent(command.getBikeId(), command.getBikeType(), command.getLocation()));
    }

    @EventSourcingHandler
    public void handle(RegisterBikeCommand command) {
        this.bikeId = command.getBikeId();
        this.isAvailable = true;
    }
}
