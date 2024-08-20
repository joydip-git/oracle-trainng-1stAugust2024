--create or replace procedure fetch_products (
--price_value IN products.price%type,
--prods_cursor OUT sys_refcursor
--)
--as
--begin
--open prods_cursor for 
--select * from products where price>=price_value;
--end;

declare
    product_records_return sys_refcursor;
    product_record_return products%rowtype;
begin
    fetch_products(11000, product_records_return);
    loop
    fetch product_records_return into product_record_return;
    exit when product_records_return%notfound;
     dbms_output.put_line(product_record_return.product_name|| ' '|| product_record_return.price);
    end loop;
    close product_records_return;
end;
