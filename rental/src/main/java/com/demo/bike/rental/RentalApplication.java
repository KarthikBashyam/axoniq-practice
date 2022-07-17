package com.demo.bike.rental;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
}
