INSERT INTO customers (id, name, grade, created_at)
SELECT
    gs,
    'customer-' || gs,
    CASE
        WHEN random() < 0.03 THEN 'VIP'
        WHEN random() < 0.20 THEN 'GOLD'
        ELSE 'NORMAL'
    END,
    TIMESTAMP '2023-01-01'
        + ((random() * 1100)::INT || ' days')::INTERVAL
FROM generate_series(1, 100000) gs;

INSERT INTO products (id, category_id, name, price)
SELECT
    gs,
    (random() * 50)::INT + 1,
    'product-' || gs,
    ROUND((random() * 100000)::NUMERIC, 2)
FROM generate_series(1, 10000) gs;

INSERT INTO orders2 (id, customer_id, status, created_at, amount)
SELECT
    gs,
    (random() * 100000)::BIGINT + 1,
    CASE
        WHEN random() < 0.65 THEN 'CREATED'
        WHEN random() < 0.88 THEN 'CONFIRMED'
        WHEN random() < 0.97 THEN 'SHIPPED'
        ELSE 'CANCELLED'
    END,
    TIMESTAMP '2024-01-01'
        + ((random() * 730)::INT || ' days')::INTERVAL
        + ((random() * 86400)::INT || ' seconds')::INTERVAL,
    ROUND((random() * 300000)::NUMERIC, 2)
FROM generate_series(1, 500000) gs;

INSERT INTO order_items (id, order_id, product_id, quantity, unit_price)
SELECT
    gs,
    (random() * 500000)::BIGINT + 1,
    (random() * 10000)::BIGINT + 1,
    (random() * 4)::INT + 1,
    ROUND((random() * 50000)::NUMERIC, 2)
FROM generate_series(1, 1500000) gs;

ANALYZE customers;
ANALYZE products;
ANALYZE orders2;
ANALYZE order_items;
