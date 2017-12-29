ALTER TABLE job_candidates
    ADD COLUMN
      next_step     VARCHAR(16) NOT NULL DEFAULT 'RESUME'
      AFTER candidate_id;