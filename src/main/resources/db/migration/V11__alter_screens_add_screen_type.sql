ALTER TABLE screens
    ADD COLUMN
      screen_type     VARCHAR(16) NOT NULL DEFAULT 'RESUME'
      AFTER job_candidate_id;