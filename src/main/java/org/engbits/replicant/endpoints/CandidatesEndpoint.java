package org.engbits.replicant.endpoints;

import org.engbits.replicant.model.Candidate;
import org.engbits.replicant.service.CandidatesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

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
public class CandidatesEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(CandidatesEndpoint.class);

    private final CandidatesService candidatesService;

    /**
     * Constructor to make a new endpoint with all injected required components
     * @param candidatesService {@link CandidatesService} for all Candidate functionality
     */
    @Inject
    public CandidatesEndpoint(final CandidatesService candidatesService) {
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

    /**
     * Gets a {@link Candidate} with the given ID
     * @param candidateId ID of the {@link Candidate} to retrieve
     * @return {@link Candidate} with the given ID
     */
    @GET
    @Path("/{candidateId}")
    public Candidate getCandidateById(final @PathParam("candidateId") Long candidateId) {
        return candidatesService.getCandidateById(candidateId);
    }

    /**
     * Gets all known {@link Candidate}s in the system
     * @return {@link List} of all {@link Candidate}s known
     */
    @GET
    @Path("/")
    public List<Candidate> getCandidates() {
        return candidatesService.getCandidates();
    }

}
