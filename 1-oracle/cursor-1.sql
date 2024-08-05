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

    r_product c_products%rowtype;
BEGIN
    OPEN c_products;
    LOOP
        FETCH c_products INTO r_product;
        EXIT WHEN c_products%notfound;
        dbms_output.put_line(r_product.product_name
                             || ' '
                             || r_product.price);
    END LOOP;

    CLOSE c_products;
END;