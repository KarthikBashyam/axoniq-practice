package com.demo.bike.rental;

import com.thoughtworks.xstream.XStream;
import io.axoniq.practice.bikerental.commonapi.BikeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackageClasses = {BikeStatus.class})
public class RentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);
    }

    @Bean
    public CommandLineRunner hello() {
        return args -> {
            System.out.println("======= WELCOME TO AXONIQ =======");
        };
    }


    @Autowired
    public void configureXStreamSecurity(XStream xStream) {
        xStream.allowTypesByWildcard(new String[]{"io.axoniq.practice.bikerental.commonapi.**"});
    }

}