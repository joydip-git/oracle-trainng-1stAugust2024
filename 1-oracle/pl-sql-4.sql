set serveroutput on;

--DECLARE
--    TYPE cat_prod_record IS RECORD (
--            categoryname categories.category_name%TYPE,
--            productname  products.product_name%TYPE
--    );
--    l_cat_prod_record cat_prod_record;
--BEGIN
--    SELECT
--        c.category_name,
--        p.product_name
--    INTO
--        l_cat_prod_record.categoryname,
--        l_cat_prod_record.productname
--    FROM
--        categories c
--        LEFT OUTER JOIN products   p ON c.category_id = p.category_id
--    WHERE
--        p.product_id = 1;
--
--    dbms_output.put_line(l_cat_prod_record.categoryname
--                         || ':'
--                         || l_cat_prod_record.productname);
--END;

DECLARE
    TYPE cat_prod_record IS RECORD (
            categoryname categories.category_name%TYPE,
            productname  products.product_name%TYPE
    );
    l_cat_prod_record cat_prod_record;
BEGIN
    SELECT
        c.category_name,
        p.product_name
    INTO l_cat_prod_record
    FROM
        categories c
        LEFT OUTER JOIN products   p ON c.category_id = p.category_id
    WHERE
        p.product_id = 1;

    dbms_output.put_line(l_cat_prod_record.categoryname
                         || ':'
                         || l_cat_prod_record.productname);
END;