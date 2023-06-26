CREATE TABLE company
(
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    company_name VARCHAR(255),
    description  VARCHAR(255),
    created      TIMESTAMP WITHOUT TIME ZONE,
    updated      TIMESTAMP WITHOUT TIME ZONE,
    is_activity  BOOLEAN                                 NOT NULL,
    CONSTRAINT pk_company PRIMARY KEY (id)
);

CREATE TABLE user_job_info
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    company_id  BIGINT,
    user_id     BIGINT,
    description VARCHAR(255),
    is_activity BOOLEAN                                 NOT NULL,
    created     TIMESTAMP WITHOUT TIME ZONE,
    updated     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_user_job_info PRIMARY KEY (id)
);

CREATE TABLE users
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    family_name VARCHAR(255),
    middle_name VARCHAR(255),
    first_name  VARCHAR(255),
    birthday    TIMESTAMP WITHOUT TIME ZONE,
    gender      SMALLINT,
    age         INTEGER                                 NOT NULL,
    description VARCHAR(255),
    created     TIMESTAMP WITHOUT TIME ZONE,
    updated     TIMESTAMP WITHOUT TIME ZONE,
    is_blocked  BOOLEAN                                 NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE user_job_info
    ADD CONSTRAINT FK_USER_JOB_INFO_ON_COMPANY FOREIGN KEY (company_id) REFERENCES company (id);

ALTER TABLE user_job_info
    ADD CONSTRAINT FK_USER_JOB_INFO_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);