SELECT
    p.isbn,
    p.product_name,
    p.price,
    p."description"
FROM
    products p;

--select * from dual;
--select 
--dummy,
--LOWER('WELCOME'),
--UPPER('welcome')
--from dual;

SELECT
    p.product_name,
    p.price
FROM
    products p
WHERE
    p.price >= 11000
ORDER BY
    p.price DESC;

SELECT
    p.product_name,
    p.price
FROM
    products p
WHERE
    p.product_name LIKE 'l%';

SELECT
    p.product_name,
    p.price
FROM
    products p
WHERE
    p.product_name LIKE '%k';

SELECT
    p.product_name,
    p.price
FROM
    products p
WHERE
    p.product_name LIKE '%o%';

SELECT
    p.product_name,
    p.price
FROM
    products p
WHERE
    p.product_name LIKE '__l%';

SELECT
    p.product_name,
    p.price
FROM
    products p
WHERE
    p.product_name LIKE '%o__';

SELECT
    p.product_name,
    COUNT(p.product_name) AS numofproducts
FROM
    products p
GROUP BY
    p.product_name
HAVING
    AVG(p.price) > 12000;

UPDATE products
SET
    price = 12500
WHERE
    isbn = 1;

INSERT INTO products (
    isbn,
    product_name,
    price,
    "description",
    category_id
) VALUES (
    5,
    'dell xps',
    13000,
    'new laptop',
    1
);