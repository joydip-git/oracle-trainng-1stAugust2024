--create or replace view category_products_count as
--SELECT
--    c.category_name,
--    replace(COUNT(p.product_name),
--            0,
--            'NA') AS product_count
--FROM
--    categories c
--    LEFT OUTER JOIN products   p ON c.category_id = p.category_id
--GROUP BY
--    c.category_name
--ORDER BY
--    c.category_name;
--    
--drop view category_products_count;
--select * from category_products_count;
CREATE OR REPLACE VIEW select_products_view AS
    SELECT
        product_name,
        price
    FROM
        products
    WHERE
        price > 11000
WITH CHECK OPTION;

SELECT
    *
FROM
    select_products_view;
    
    UPDATE select_products_view
SET
    price = 10000
WHERE
    product_name = 'hp probook';

INSERT INTO select_products_view VALUES (
    'abcd',
    13000
);

CREATE OR REPLACE VIEW select_some_products_view AS
    SELECT
        product_name,
        price
    FROM
        products
    WHERE
        price > 12000;

UPDATE select_some_products_view
SET
    price = 10000
WHERE
    product_name = 'dell xps';

SELECT
    *
FROM
    select_some_products_view;
    
select * from products;

INSERT INTO select_some_products_view VALUES (
    123,
    'abcd',
    13000
);

