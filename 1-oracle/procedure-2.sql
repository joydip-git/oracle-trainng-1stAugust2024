/*
create or replace procedure fetch_product (
isbn_value IN products.isbn%type,
prod_name OUT products.product_name%type
)
as
begin
select product_name into prod_name from products where isbn = isbn_value;
end;
*/

declare
    product_name_return products.product_name%type;
begin
    fetch_product(2, product_name_return);
    dbms_output.put_line(product_name_return);
end;

