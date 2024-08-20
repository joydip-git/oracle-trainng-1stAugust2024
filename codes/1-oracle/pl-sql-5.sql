set serveroutput on;

DECLARE
    TYPE cat_prod_record IS RECORD (
            categoryname categories.category_name%TYPE,
            productname  products.product_name%TYPE
    );
    TYPE cat_prod_collection IS
        TABLE OF cat_prod_record;
    l_cat_prod_records cat_prod_collection;
    l_count            INT := 0;
    l_record           cat_prod_record;
BEGIN
    SELECT
        c.category_name,
        p.product_name
    BULK COLLECT
    INTO l_cat_prod_records
    FROM
        categories c
        LEFT OUTER JOIN products   p ON c.category_id = p.category_id;

    l_count := l_cat_prod_records.count;
    
    FOR r IN 1..l_count LOOP
        l_record := l_cat_prod_records(r);
        dbms_output.put_line(l_record.categoryname
                             || ':'
                             || l_record.productname);
    END LOOP;

END;