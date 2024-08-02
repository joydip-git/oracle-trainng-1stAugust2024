set serveroutput on;

DECLARE
    l_product_record products%rowtype;
BEGIN
    SELECT
        *
    INTO l_product_record
    FROM
        products p
    WHERE
        product_id = 1;

    dbms_output.put_line(l_product_record.product_name
                         || ' '
                         || l_product_record.price);
END;