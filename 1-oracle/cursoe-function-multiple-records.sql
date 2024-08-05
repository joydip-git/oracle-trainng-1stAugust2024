--create or replace function get_products_filtered_by_price (price_value products.price%type)
--return SYS_REFCURSOR
--as
--r_products_cursor sys_refcursor;
--begin
--open r_products_cursor for
--select product_id, product_name, price, category_id
--from products
--where price >= price_value;
--
--return r_products_cursor;
--end;

DECLARE
    product_rows SYS_REFCURSOR;
    prod_id      products.product_id%TYPE;
    prod_name    products.product_name%TYPE;
    prod_price   products.price%TYPE;
    cat_id       products.category_id%TYPE;
BEGIN
    product_rows := get_products_filtered_by_price(11000);
    LOOP
        FETCH product_rows INTO
            prod_id,
            prod_name,
            prod_price,
            cat_id;
        EXIT WHEN product_rows%notfound;
        dbms_output.put_line(prod_id
                             || ', '
                             || prod_name
                             || ', '
                             || prod_price
                             || ', '
                             || cat_id);

    END LOOP;

    CLOSE product_rows;
END;

DECLARE
    product_rows   SYS_REFCURSOR;
    TYPE product_record_type IS RECORD (
            prod_id    products.product_id%TYPE,
            prod_name  products.product_name%TYPE,
            prod_price products.price%TYPE,
            cat_id     products.category_id%TYPE
    );
    product_record product_record_type;
BEGIN
    product_rows := get_products_filtered_by_price(11000);
    LOOP
        FETCH product_rows INTO product_record;
        EXIT WHEN product_rows%notfound;
        dbms_output.put_line(product_record.prod_id
                             || ', '
                             || product_record.prod_name
                             || ', '
                             || product_record.prod_price
                             || ', '
                             || product_record.cat_id);

    END LOOP;

    CLOSE product_rows;
END;