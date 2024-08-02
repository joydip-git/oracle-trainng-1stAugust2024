CREATE TABLE locations (
    location_id INT PRIMARY KEY NOT NULL,
    address     VARCHAR2(255),
    postal_code INT NOT NULL,
    city        VARCHAR2(50) NOT NULL,
    state       VARCHAR2(50),
    country_id  VARCHAR2(3) NOT NULL
);

INSERT INTO locations VALUES (
    1,
    'VCity',
    122133,
    'Roma',
    NULL,
    'IT'
);

INSERT INTO locations VALUES (
    2,
    '1 Canal Street',
    111222,
    'Venice',
    NULL,
    'AUS'
);

INSERT INTO locations VALUES (
    3,
    'Whitefield',
    560034,
    'Bangalore',
    'KA',
    'IN'
);

INSERT INTO locations VALUES (
    4,
    'Mayfair',
    233123,
    'London',
    NULL,
    'UK'
);

INSERT INTO locations VALUES (
    5,
    'E City',
    560100,
    'Bangalore',
    'KA',
    'IN'
);

UPDATE locations
SET
    state = 'Roma'
WHERE
    country_id = 'IT';

SELECT
    *
FROM
    locations;

--1. sorting rows with NULL values first
SELECT
    country_id,
    city,
    state
FROM
    locations
ORDER BY
    state ASC NULLS FIRST;
    
    --2. sorting rows with NULL values last 
SELECT
    country_id,
    city,
    state
FROM
    locations
ORDER BY
    state ASC NULLS LAST;
    
--3. sorting rows by the result of a function or expression
SELECT
    country_id,
    state
FROM
    locations
ORDER BY
    lower(city);
    
--4. select distinct
--select distinct column_name from table;
SELECT DISTINCT
    country_id,
    COUNT(city)
FROM
    locations
GROUP BY
    country_id
ORDER BY
    country_id;

SELECT DISTINCT
    state
FROM
    locations
ORDER BY
    state NULLS FIRST;
    
    -- inner join, left join, right join, full outer join and cross join

SELECT
    *
FROM
    products;

SELECT
    *
FROM
    categories;

SELECT
    c.category_name,
    nvl(p.product_name, 'NA')
FROM
    categories c
    FULL OUTER JOIN products   p ON c.category_id = p.category_id
ORDER BY
    c.category_name;

SELECT
    c.category_name,
    replace(COUNT(p.product_name),
            0,
            'NA') AS product_count
FROM
    categories c
    FULL OUTER JOIN products   p ON c.category_id = p.category_id
GROUP BY
    c.category_name
ORDER BY
    c.category_name;

SELECT
    c.category_name,
    replace(COUNT(p.product_name),
            0,
            'NA') AS product_count
FROM
    categories c
    LEFT OUTER JOIN products   p ON c.category_id = p.category_id
GROUP BY
    c.category_name
ORDER BY
    c.category_name;

SELECT    
    p.product_name,
    c.category_name
FROM
    products   p
    LEFT OUTER JOIN categories c ON p.category_id = c.category_id
ORDER BY
    c.category_name;