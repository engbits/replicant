/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.service;

import org.engbits.replicant.dao.JobCandidatesDao;
import org.engbits.replicant.dao.ScreensDao;
import org.engbits.replicant.model.JobCandidate;
import org.engbits.replicant.model.Screen;
import org.engbits.replicant.model.ScreenType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Service that handles all functionality for {@link Screen} data
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Service
public class ScreensService {

    private static final Logger LOG = LoggerFactory.getLogger(ScreensService.class);

    private final ScreensDao screensDao;

    /**
     * Constructor to create a Screens service with all injected components
     * @param screensDao {@link ScreensDao} for persistence
     */
    @Inject
    public ScreensService(final ScreensDao screensDao) {
        this.screensDao = screensDao;
    }

    /**
     * Creates a new {@link Screen}, persisting to database
     * @param screen {@link Screen} to persist
     * @return {@link Screen} with all values supplied after persistence
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Screen createScreen(final Screen screen) {
        LOG.info("Creating new Screen: {}", screen);
        screensDao.insert(screen);

        return screen;
    }

    /**
     * Creates a new Screen for the given Candidate ID and Job ID
     * @param candidateId ID of the Candidate receiving the screen
     * @param jobId ID of the Job for which the Candidate is screened
     * @return {@link Screen} of type {@link ScreenType#RESUME} for the Candidate + Job
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Screen createFirstScreenForCandidate(final Long candidateId, final Long jobId) {
        final Screen screen = new Screen();
        screen.setScreenType(ScreenType.RESUME);
        screen.setCandidateId(candidateId);
        screen.setJobId(jobId);

        return createScreen(screen);
    }

}
