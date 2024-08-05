set serveroutput on;

DECLARE
    CURSOR c_products (
        price_criteria NUMBER := 1000
    ) IS
    SELECT
        "A1"."ISBN"         "ISBN",
        "A1"."PRODUCT_ID"   "PRODUCT_ID",
        "A1"."PRODUCT_NAME" "PRODUCT_NAME",
        "A1"."PRICE"        "PRICE"
    FROM
        "SYSTEM"."PRODUCTS" "A1"
    WHERE
        "A1"."PRICE" >= price_criteria
    ORDER BY
        "A1"."PRICE";

    r_product c_products%rowtype;
BEGIN
    dbms_output.put_line('first query');
--1.
    OPEN c_products(11500);
    LOOP
        FETCH c_products INTO r_product;
        EXIT WHEN c_products%notfound;
        dbms_output.put_line(r_product.product_name
                             || ' '
                             || r_product.price);
    END LOOP;

    CLOSE c_products;
    dbms_output.put_line('second query');
--2.
    --OPEN c_products(1000);
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