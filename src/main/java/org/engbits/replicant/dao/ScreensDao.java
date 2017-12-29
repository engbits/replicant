/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.dao;

import org.engbits.replicant.model.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;

/**
 * DAO to handle the persistence of {@link Screen} entities
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Repository
public class ScreensDao {

    private static final Logger LOG = LoggerFactory.getLogger(ScreensDao.class);

    private EntityManager entityManager;

    /**
     * Inserts the given {@link Screen} for persistence
     * @param screen {@link Screen} to persist
     */
    public void insert(final Screen screen) {
        screen.setCreateDate(LocalDateTime.now());
        screen.setIsActive(true);

        LOG.debug("Inserting Screen: {}", screen);
        entityManager.persist(screen);
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
