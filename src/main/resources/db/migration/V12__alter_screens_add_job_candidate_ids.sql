ALTER TABLE screens
    ADD COLUMN
      job_id            BIGINT NOT NULL
      AFTER screen_id;

ALTER TABLE screens
  ADD COLUMN
      candidate_id      BIGINT NOT NULL
      AFTER job_id;

ALTER TABLE screens DROP COLUMN job_candidate_id;