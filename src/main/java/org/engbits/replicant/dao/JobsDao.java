package org.engbits.replicant.dao;

import org.engbits.replicant.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DAO to handle the persistence of {@link Job} entities
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Repository
public class JobsDao {

    private static final Logger LOG = LoggerFactory.getLogger(JobsDao.class);

    private EntityManager entityManager;

    /**
     * Inserts the given {@link Job} for persistence
     * @param job {@link Job} to persist
     */
    public void insert(final Job job) {
        job.setCreateDate(LocalDateTime.now());
        job.setIsActive(true);

        LOG.debug("Inserting Job: {}", job);
        entityManager.persist(job);
    }

    /**
     * Selects all the {@link Job} entities that are in persistence
     * @return {@link List} of all {@link Job} entities in persistence
     */
    public List<Job> selectAll() {
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        final CriteriaQuery<Job> criteriaQuery = criteriaBuilder.createQuery(Job.class);
        final Root<Job> queryRoot = criteriaQuery.from(Job.class);
        criteriaQuery.select(queryRoot);

        criteriaQuery.orderBy(
                criteriaBuilder.asc(
                        queryRoot.get("title")));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    /**
     * Selects the specific Job with the given ID
     * @param jobId ID of the Job to select
     * @return {@link Job} record with the given ID or null if not found
     */
    public Job selectById(final Long jobId) {
        return entityManager.find(Job.class, jobId);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
