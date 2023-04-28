DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS user_seq;

CREATE SEQUENCE user_seq START WITH 100000;

CREATE TABLE users
(
    id                 INTEGER PRIMARY KEY NOT NULL,
    username           VARCHAR             NOT NULL,
    email              VARCHAR             NOT NULL,
    password           VARCHAR             NOT NULL,
    mobile_number      VARCHAR,
    roles              VARCHAR,
    created_time       TIMESTAMP           DEFAULT CURRENT_TIMESTAMP,
    last_updated_at    TIMESTAMP           DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE users
    ALTER COLUMN id SET DEFAULT nextval('user_seq');
