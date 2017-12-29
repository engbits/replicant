ALTER TABLE job_candidates
    DROP PRIMARY KEY;

ALTER TABLE job_candidates
    ADD
      job_candidate_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT FIRST;

