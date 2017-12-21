package org.engbits.replicant;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Primary entry point for the Replication Spring Boot application
 *
 * @author replicant.team
 * @since 0.1.0
 */
@SpringBootApplication
@EntityScan("org.engbits.replicant.model")
@EnableJpaRepositories
@Configuration
@PropertySources({
        @PropertySource("classpath:replicant.properties"),
        @PropertySource(value = "file:${external.config}", ignoreResourceNotFound = true),
})
public class ReplicantApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ReplicantApplication.class);
    }

    public static void main(String[] args) {
        new ReplicantApplication()
                .configure(new SpringApplicationBuilder(ReplicantApplication.class))
                .run(args);
    }

}
