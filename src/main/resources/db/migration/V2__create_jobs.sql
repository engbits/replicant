CREATE TABLE jobs (
  job_id            BIGINT NOT NULL AUTO_INCREMENT,
  title             VARCHAR(64) NOT NULL,
  description       TEXT,
  hiring_manager    VARCHAR(32),
  create_date       DATETIME NOT NULL,
  is_active         BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (job_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;