package com.engbits.replicant;

import com.engbits.replicant.endpoints.CandidatesEndpoints;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * Configuration to define the Jersey-based REST endpoint for Replicant
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CandidatesEndpoints.class);
    }

}
