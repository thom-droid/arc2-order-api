INSERT INTO orders (
    id,
    customer_id,
    status,
    delete_yn,
    created_at,
    amount
)
SELECT
    gs AS id,
    (random() * 50000)::BIGINT + 1 AS customer_id,
    CASE
        WHEN random() < 0.70 THEN 'CREATED'
        WHEN random() < 0.90 THEN 'CONFIRMED'
        WHEN random() < 0.98 THEN 'SHIPPED'
        ELSE 'CANCELLED'
    END AS status,
    CASE
        WHEN random() < 0.95 THEN 'N'
        ELSE 'Y'
    END AS delete_yn,
    TIMESTAMP '2024-01-01'
        + ((random() * 730)::INT || ' days')::INTERVAL
        + ((random() * 86400)::INT || ' seconds')::INTERVAL AS created_at,
    ROUND((random() * 100000)::NUMERIC, 2) AS amount
FROM generate_series(1, 500000) gs;

ANALYZE orders;
