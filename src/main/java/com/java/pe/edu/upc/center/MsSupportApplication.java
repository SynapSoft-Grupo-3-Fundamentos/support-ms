package com.java.pe.edu.upc.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MsSupportApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSupportApplication.class, args);
    }

}
