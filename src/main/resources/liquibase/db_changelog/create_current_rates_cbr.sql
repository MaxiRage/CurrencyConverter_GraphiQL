CREATE TABLE currency
(
    id          BIGINT generated always as identity NOT NULL,
    num_code    BIGINT NOT NULL UNIQUE,
    char_code   VARCHAR(50) PRIMARY KEY NOT NULL UNIQUE,
    nominal     BIGINT NOT NULL,
    name        VARCHAR(50) NOT NULL UNIQUE,
    "value"     DECIMAL(15,4) NOT NULL,
    timestamp   TIMESTAMP NOT NULL
);