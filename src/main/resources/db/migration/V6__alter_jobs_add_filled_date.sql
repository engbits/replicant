ALTER TABLE jobs
    ADD COLUMN
      filled_date       DATETIME
      AFTER create_date;