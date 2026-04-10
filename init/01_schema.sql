CREATE TABLE orders (
    id BIGINT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    delete_yn CHAR(1) NOT NULL,
    created_at TIMESTAMP NOT NULL,
    amount NUMERIC(10,2) NOT NULL
);

CREATE INDEX idx_orders_customer_created
    ON orders (customer_id, created_at DESC);

CREATE INDEX idx_orders_status
    ON orders (status);

CREATE INDEX idx_orders_delete_yn
    ON orders (delete_yn);

CREATE INDEX idx_orders_created_at
    ON orders (created_at DESC);
