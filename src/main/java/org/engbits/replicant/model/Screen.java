/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model of a Screen in the Replicant system
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Entity
@Table(name = "screens")
public class Screen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "screen_id", nullable = false)
    private Long screenId;

    @Column(name = "job_candidate_id", nullable = false)
    private Long jobCandidateId;

    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    @JsonIgnore
    @Column(name = "create_date", nullable = false, updatable = false)
    private LocalDateTime createDate;

    @Column(name = "scheduled_date")
    private LocalDateTime scheduledDate;

    @JsonIgnore
    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    public Long getScreenId() {
        return screenId;
    }

    public void setScreenId(final Long screenId) {
        this.screenId = screenId;
    }

    public Long getJobCandidateId() {
        return jobCandidateId;
    }

    public void setJobCandidateId(final Long jobCandidateId) {
        this.jobCandidateId = jobCandidateId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public ScreenType getScreenType() {
        return screenType;
    }

    public void setScreenType(final ScreenType screenType) {
        this.screenType = screenType;
    }

    public void setCreateDate(final LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(final LocalDateTime scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
