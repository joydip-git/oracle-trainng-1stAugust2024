
CREATE OR REPLACE FUNCTION get_product_statistics (
    isbn_number NUMBER
) RETURN NUMBER IS
    l_product_price NUMBER;
BEGIN
    SELECT
        price
    INTO l_product_price
    FROM
        products
    WHERE
        isbn = isbn_number;

    RETURN l_product_price;
END;

/*
set serveroutput on;

DECLARE
    v_return NUMBER;
BEGIN
    v_return := get_product_statistics(1);
    dbms_output.put_line(v_return);
END;
*/