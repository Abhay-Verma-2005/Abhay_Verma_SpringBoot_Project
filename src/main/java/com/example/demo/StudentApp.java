package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentApp {
    public static void main(String[] args) {
        SpringApplication.run(StudentApp.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            System.out.println("  StudentApp is running!");
            System.out.println("  http://localhost:8080");
        };
    }
}
