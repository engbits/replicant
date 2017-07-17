package com.engbits.replicant.endpoints;

import com.engbits.replicant.model.Candidate;
import com.engbits.replicant.service.CandidatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * REST endpoint for working with all {@link Candidate} data in the Replicant system
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Component
@Path("/candidates")
@Consumes("application/json")
@Produces("application/json")
public class CandidatesEndpoints {

    private static final Logger LOG = LoggerFactory.getLogger(CandidatesEndpoints.class);

    private final CandidatesService candidatesService;

    /**
     * Constructor to make a new endpoint with all injected required components
     * @param candidatesService {@link CandidatesService} for all Candidate functionality
     */
    @Inject
    public CandidatesEndpoints(final CandidatesService candidatesService) {
        this.candidatesService = candidatesService;
    }

    /**
     * Creates a new {@link Candidate} with all supplied information, filling in all auto-populated properties
     * @param candidate {@link Candidate} with all data that is to be stored
     * @return {@link Candidate} created with all auto-populated properties defined
     */
    @POST
    @Path("/")
    public Candidate createCandidate(final Candidate candidate) {
        LOG.debug("Creating Candidate: {}", candidate);
        return candidatesService.createCandidate(candidate);
    }

}
