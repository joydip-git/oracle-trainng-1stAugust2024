set serveroutput on;

DECLARE
    TYPE cat_prod_record IS RECORD (
            categoryname categories.category_name%TYPE,
            productname  products.product_name%TYPE
    );
    TYPE cat_prod_collection IS
        TABLE OF cat_prod_record;
    l_cat_prod_records cat_prod_collection;
--    l_counter          INT := 0;
BEGIN
    SELECT
        c.category_name,
        p.product_name
    INTO l_cat_prod_records
    FROM
        categories c
        LEFT OUTER JOIN products   p ON c.category_id = p.category_id;

    FOR r IN l_cat_prod_records LOOP
        dbms_output.put_line(r.categoryname
                             || ':'
                             || r.productname);
    END LOOP;

END;