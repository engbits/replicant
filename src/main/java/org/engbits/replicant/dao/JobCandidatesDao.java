/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.dao;

import org.engbits.replicant.model.JobCandidate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO to handle the persistence of {@link JobCandidate} entities
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Repository
public class JobCandidatesDao {

    private static final Logger LOG = LoggerFactory.getLogger(JobCandidatesDao.class);

    private EntityManager entityManager;

    /**
     * Inserts a new {@link JobCandidate} entity into persistence
     * @param jobCandidate {@link JobCandidate} entity to persist
     */
    public void insert(final JobCandidate jobCandidate) {
        LOG.debug("Inserting Job Candidate: {}", jobCandidate);
        entityManager.persist(jobCandidate);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
