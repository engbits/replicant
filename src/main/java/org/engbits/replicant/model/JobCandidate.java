/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * Representation of a link between a Job and the Candidates for the job
 *
 * @author replicant.team
 * @since 0.1.0
 */
@Entity
@IdClass(JobCandidateId.class)
@Table(name = "job_candidates")
public class JobCandidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "job_candidate_id", nullable = false)
    private Long jobCandidateId;

    @Id
    @Column(name = "job_id", nullable = false)
    public Long jobId;

    @Id
    @JoinColumn(name = "job_id", updatable = false, insertable = false)
    @OneToOne(targetEntity = Job.class)
    private Job job;

    @Column(name = "candidate_id", nullable = false)
    public Long candidateId;

    @JoinColumn(name = "candidate_id", updatable = false, insertable = false)
    @OneToOne(targetEntity = Candidate.class)
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    private ScreenType nextStep;

    public Long getJobCandidateId() {
        return jobCandidateId;
    }

    public void setJobCandidateId(final Long jobCandidateId) {
        this.jobCandidateId = jobCandidateId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(final Job job) {
        this.job = job;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(final Long jobId) {
        this.jobId = jobId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(final Candidate candidate) {
        this.candidate = candidate;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(final Long candidateId) {
        this.candidateId = candidateId;
    }

    public ScreenType getNextStep() {
        return nextStep;
    }

    public void setNextStep(final ScreenType nextStep) {
        this.nextStep = nextStep;
    }

}
