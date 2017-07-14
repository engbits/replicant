package com.engbits.replicant;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * Primary entry point for the Replication Spring Boot application
 *
 * @author replicant.team
 * @since 0.1.0
 */
@SpringBootApplication
@Configuration
@PropertySources({
        @PropertySource("classpath:replicant.properties"),
        @PropertySource(value = "file:${external.config}", ignoreResourceNotFound = true),
})
public class ReplicantApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new ReplicantApplication()
                .configure(new SpringApplicationBuilder(ReplicantApplication.class))
                .run(args);
    }

}
