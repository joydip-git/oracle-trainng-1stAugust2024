--create or replace procedure fetch_a_product (
--isbn_value IN products.isbn%type,
--prod_record OUT products%rowtype
--)
--as
--begin
--select * into prod_record from products where isbn = isbn_value;
--end;

declare
    product_record_return products%rowtype;
begin
    fetch_a_product(2, product_record_return);
    dbms_output.put_line(product_record_return.product_name|| ' '|| product_record_return.price);
end;
