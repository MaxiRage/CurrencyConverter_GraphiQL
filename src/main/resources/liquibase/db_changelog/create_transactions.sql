CREATE TABLE transactions
(
    id                  SERIAL PRIMARY KEY NOT NULL,
    initial_currency    VARCHAR(50) NOT NULL,
    initial_value       DECIMAL(15,4),
    rate                DECIMAL(15,4),
    final_currency      VARCHAR(50) NOT NULL,
    final_value         DECIMAL(15,4),
    volume              DECIMAL(15,4),
    result              DECIMAL(15,2),
    timestamp           TIMESTAMP,

    FOREIGN KEY (initial_currency) REFERENCES currency (char_code),
    FOREIGN KEY (final_currency) REFERENCES currency (char_code)
);