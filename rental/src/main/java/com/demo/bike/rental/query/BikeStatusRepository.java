package com.demo.bike.rental.query;

import com.demo.bike.rental.command.Bike;
import io.axoniq.practice.bikerental.commonapi.BikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeStatusRepository extends JpaRepository<BikeStatus, String> {

}
