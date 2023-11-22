DROP TABLE IF EXISTS customers;
CREATE TABLE customers (
                           id uuid primary key default gen_random_uuid(),
                           name VARCHAR(255),
                           gender VARCHAR(16),
                           date_birth DATE,
                           document_number VARCHAR(32) UNIQUE,
                           address VARCHAR(255),
                           phone VARCHAR(32),
                           password VARCHAR(32),
                           state VARCHAR(32)
);

DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
                          id uuid primary key default gen_random_uuid(),
                          customer_id uuid,
                          account_type VARCHAR(16),
                          balance DECIMAL(15,2),
                          state VARCHAR(32)
);

DROP TABLE IF EXISTS transactions;
CREATE TABLE transactions (
                              id uuid primary key default gen_random_uuid(),
                              account_id uuid,
                              transaction_date TIMESTAMP,
                              transaction_type VARCHAR(16),
                              transaction_value DECIMAL(15,2),
                              account_initial_balance DECIMAL(15,2),
                              account_ending_balance DECIMAL(15,2)
);