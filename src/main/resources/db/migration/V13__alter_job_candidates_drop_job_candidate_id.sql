ALTER TABLE job_candidates
    DROP COLUMN job_candidate_id;

ALTER TABLE job_candidates
    ADD PRIMARY KEY (job_id, candidate_id);
