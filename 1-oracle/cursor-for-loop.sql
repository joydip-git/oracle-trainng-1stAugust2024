set serveroutput on;

DECLARE
    CURSOR c_products IS
    SELECT
        "A1"."ISBN"         "ISBN",
        "A1"."PRODUCT_ID"   "PRODUCT_ID",
        "A1"."PRODUCT_NAME" "PRODUCT_NAME",
        "A1"."PRICE"        "PRICE"
    FROM
        "SYSTEM"."PRODUCTS" "A1"
    WHERE
        "A1"."PRICE" >= 11000
    ORDER BY
        "A1"."PRICE";

BEGIN
    FOR r_product IN c_products LOOP
        dbms_output.put_line(r_product.product_name
                             || ' '
                             || r_product.price);
    END LOOP;
END;