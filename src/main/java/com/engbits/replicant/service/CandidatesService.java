package com.engbits.replicant.service;

import com.engbits.replicant.dao.CandidatesDao;
import com.engbits.replicant.model.Candidate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Service that handles all functionality for {@link Candidate} data
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Service
public class CandidatesService {

    private final CandidatesDao candidatesDao;

    /**
     * Constructor to make a new service with all injected, required components
     * @param candidatesDao {@link CandidatesDao} to handle {@link Candidate} persistence
     */
    @Inject
    public CandidatesService(final CandidatesDao candidatesDao) {
        this.candidatesDao = candidatesDao;
    }

    /**
     * Creates a new {@link Candidate} by persisting it
     * @param candidate {@link Candidate} that is to be created
     * @return {@link Candidate} that was persisted with all auto-populated properties defined
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Candidate createCandidate(final Candidate candidate) {
        candidatesDao.insert(candidate);
        return candidate;
    }

}
