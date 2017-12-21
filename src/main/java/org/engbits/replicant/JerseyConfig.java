package org.engbits.replicant;

import org.engbits.replicant.endpoints.CandidatesEndpoint;
import org.engbits.replicant.endpoints.JobsEndpoint;
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
        register(CandidatesEndpoint.class);
        register(JobsEndpoint.class);
    }

}
