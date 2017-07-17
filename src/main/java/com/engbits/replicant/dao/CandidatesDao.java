package com.engbits.replicant.dao;

import com.engbits.replicant.model.Candidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.time.Instant;

/**
 * DAO to handle the persistence of {@link com.engbits.replicant.model.Candidate} entities
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Repository
public class CandidatesDao {

    private static final Logger LOG = LoggerFactory.getLogger(CandidatesDao.class);

    private EntityManager entityManager;

    /**
     * Inserts the given {@link Candidate} for persistence
     * @param candidate {@link Candidate} to persist
     */
    public void insert(final Candidate candidate) {
        candidate.setCreateDate(Date.from(Instant.now()));
        candidate.setIsActive(true);

        LOG.debug("Inserting Candidate: {}", candidate);
        entityManager.persist(candidate);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
