package io.axoniq.practice.bikerental.commonapi;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class RegisterBikeCommand {
    @TargetAggregateIdentifier
    private String bikeId;

    private String bikeType;

    private String location;

    public RegisterBikeCommand(String bikeId, String bikeType, String location) {
        this.bikeId = bikeId;
        this.bikeType = bikeType;
        this.location = location;
    }

    public String getBikeId() {
        return bikeId;
    }

    public void setBikeId(String bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterBikeCommand that = (RegisterBikeCommand) o;
        return Objects.equals(bikeId, that.bikeId) && Objects.equals(bikeType, that.bikeType) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bikeId, bikeType, location);
    }

    @Override
    public String toString() {
        return "RegisterBikeCommand{" +
                "bikeId='" + bikeId + '\'' +
                ", bikeType='" + bikeType + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
