ALTER TABLE candidates
  ADD COLUMN
    tagged_job_id     BIGINT
    AFTER email;