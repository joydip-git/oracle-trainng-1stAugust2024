--create or replace function get_single_product_record (isbn_number products.isbn%type)
--return sys_refcursor
--as
--r_product_record_cursor sys_refcursor;
--begin
--    open r_product_record_cursor for 
--    select product_id, product_name, price, category_id 
--    from products where isbn=isbn_number;
--    
--    return r_product_record_cursor;
--end;

set serveroutput on;

DECLARE
    r_prod_rec_result SYS_REFCURSOR;
    prod_id           products.product_id%TYPE;
    prod_name         products.product_name%TYPE;
    prod_price       products.price%TYPE;
    cat_id            products.category_id%TYPE;
BEGIN
    r_prod_rec_result := get_single_product_record(1);
    FETCH r_prod_rec_result INTO
        prod_id,
        prod_name,
        prod_price,
        cat_id;
    dbms_output.put_line(prod_id
                         || ', '
                         || prod_name
                         || ', '
                         || prod_price
                         || ', '
                         || cat_id);

    CLOSE r_prod_rec_result;
END;