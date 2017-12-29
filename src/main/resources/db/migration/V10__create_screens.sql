CREATE TABLE screens (
  screen_id         BIGINT NOT NULL AUTO_INCREMENT,
  job_candidate_id  BIGINT NOT NULL,
  create_date       DATETIME NOT NULL,
  scheduled_date    DATETIME,
  is_active         BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (screen_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;