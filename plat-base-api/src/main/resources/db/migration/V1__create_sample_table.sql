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

CREATE
OR REPLACE FUNCTION trigger_set_updated_at()
    RETURNS TRIGGER AS $$
BEGIN
        NEW.last_updated_at
= NOW();
RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER set_updated_ad
    BEFORE UPDATE
    ON users
    FOR EACH ROW
    EXECUTE PROCEDURE trigger_set_updated_at();
