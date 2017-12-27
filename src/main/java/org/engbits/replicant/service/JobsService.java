package org.engbits.replicant.service;

import org.engbits.replicant.dao.JobsDao;
import org.engbits.replicant.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Service that handles all functionality for {@link Job} data
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Service
public class JobsService {

    private static final Logger LOG = LoggerFactory.getLogger(JobsService.class);

    private final JobsDao jobsDao;

    /**
     * Constructor to make a new service with all injected, required components
     * @param jobsDao {@link JobsDao} to handle {@link Job} persistence
     */
    @Inject
    public JobsService(final JobsDao jobsDao) {
        this.jobsDao = jobsDao;
    }

    /**
     * Creates a new {@link Job} by persisting it
     * @param job {@link Job} that is to be created
     * @return {@link Job} that was persisted with all auto-populated properties defined
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Job createJob(final Job job) {
        LOG.debug("Creating new Job: {}", job);
        jobsDao.insert(job);

        return job;
    }

    /**
     * Gets a {@link Job} with the given ID of the Job, or null if not found
     * @param jobId ID of the {@link Job} to query
     * @return {@link Job} that with the given ID, or null if not found
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Job getJobById(final Long jobId) {
        LOG.debug("Getting Job by ID: {}", jobId);
        return jobsDao.selectById(jobId);
    }

    /**
     * Gets all of the {@link Job}s in the system
     * @return {@link List} of all known {@link Job}s
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Job> getJobs() {
        return jobsDao.selectAll();
    }

}
