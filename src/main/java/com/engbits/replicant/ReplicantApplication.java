package com.engbits.replicant;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Primary entry point for the Replication Spring Boot application
 *
 * @author replicant.team
 * @since 0.1.0
 */
public class ReplicantApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new ReplicantApplication()
                .configure(new SpringApplicationBuilder(ReplicantApplication.class))
                .run(args);
    }

}
