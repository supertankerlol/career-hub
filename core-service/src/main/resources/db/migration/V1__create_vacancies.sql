CREATE TABLE vacancies (
                           id          BIGSERIAL PRIMARY KEY,
                           title       VARCHAR(200) NOT NULL,
                           description TEXT         NOT NULL,
                           type        VARCHAR(20)  NOT NULL,
                           location    VARCHAR(100),
                           remote      BOOLEAN      NOT NULL DEFAULT FALSE,
                           salary_min  INTEGER,
                           salary_max  INTEGER,
                           status      VARCHAR(20)  NOT NULL DEFAULT 'OPEN',
                           created_at  TIMESTAMPTZ  NOT NULL DEFAULT now()
);