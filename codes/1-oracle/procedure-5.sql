create or replace procedure fetch_products_implicit_statement (
price_value IN products.price%type
)
as
prods_cursor  sys_refcursor;
begin
open prods_cursor for 
select * from products where price >= price_value;
dbms_sql.return_result(prods_cursor);
end;


execute fetch_products_implicit_statement(11000);

