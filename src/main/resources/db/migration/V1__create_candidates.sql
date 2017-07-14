CREATE TABLE candidates (
  candidate_id            BIGINT NOT NULL AUTO_INCREMENT,
  first_name              VARCHAR(64) NOT NULL,
  last_name               VARCHAR(32) NOT NULL,
  email                   VARCHAR(64) NOT NULL,
  create_date             DATETIME NOT NULL,
  is_active               BOOLEAN NOT NULL DEFAULT 1,
  PRIMARY KEY (candidate_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX idx_candidates_name
  ON candidates (first_name, last_name, email);