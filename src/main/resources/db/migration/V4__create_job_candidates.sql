CREATE TABLE job_candidates (
  job_id          BIGINT NOT NULL,
  candidate_id    BIGINT NOT NULL,
  PRIMARY KEY (job_id, candidate_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;