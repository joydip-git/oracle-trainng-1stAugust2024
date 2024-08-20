set serveroutput on;

DECLARE
    l_product_name products.product_name%TYPE;
BEGIN
    SELECT
        p.product_name
    INTO l_product_name
    FROM
        products p
    WHERE
        product_id = 1;

    dbms_output.put_line(l_product_name);
END;