package org.engbits.replicant.endpoints;

import org.engbits.replicant.model.Job;
import org.engbits.replicant.service.JobsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * REST endpoint for working with all {@link Job} data in the Replicant system
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Component
@Path("/jobs")
@Consumes("application/json")
@Produces("application/json")
public class JobsEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(JobsEndpoint.class);

    private final JobsService jobsService;

    /**
     * Constructor to make a new endpoint with all injected required components
     * @param jobsService {@link JobsService} for all Job functionality
     */
    @Inject
    public JobsEndpoint(final JobsService jobsService) {
        this.jobsService = jobsService;
    }

    /**
     * Creates a new {@link Job} with all supplied information, filling in all auto-populated properties
     * @param job {@link Job} with all data that is to be stored
     * @return {@link Job} created with all auto-populated properties defined
     */
    @POST
    @Path("/")
    public Job createJob(final Job job) {
        LOG.debug("Creating Job: {}", job);
        return jobsService.createJob(job);
    }

    /**
     * Gets a {@link Job} with the given ID
     * @param jobId ID of the {@link Job} to retrieve
     * @return {@link Job} with the given ID
     */
    @GET
    @Path("/{jobId}")
    public Job getJobById(final @PathParam("jobId") Long jobId) {
        return jobsService.getJobById(jobId);
    }

    /**
     * Gets all known {@link Job}s in the system
     * @return {@link List} of all {@link Job}s known
     */
    @GET
    @Path("/")
    public List<Job> getJobs() {
        return jobsService.getJobs();
    }

}

