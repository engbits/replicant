/*
 * Copyright (c) 2017 Tideworks Technology, Inc.
 */

package org.engbits.replicant.model;

import java.io.Serializable;

/**
 * ID that defines the composite Key for a {@link JobCandidate}
 *
 * @author replicant.team
 * @since 0.1.0
 */
public class JobCandidateId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long jobId;
    private Long candidateId;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(final Long jobId) {
        this.jobId = jobId;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(final Long candidateId) {
        this.candidateId = candidateId;
    }
}
