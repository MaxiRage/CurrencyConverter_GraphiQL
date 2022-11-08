CREATE TABLE transactions
(
    id          BIGINT PRIMARY KEY NOT NULL,
    initial_currency    VARCHAR(50) NOT NULL UNIQUE,
    initial_value       DECIMAL(15,2),
    rate                DECIMAL(15,2),
    final_currency      VARCHAR(50) NOT NULL UNIQUE,
    final_value         DECIMAL(15,2),
    timestamp           TIMESTAMP,

    FOREIGN KEY (initial_currency) REFERENCES currency (char_code),
    FOREIGN KEY (final_currency) REFERENCES currency (char_code)
);