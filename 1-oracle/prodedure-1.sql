/*
create or replace procedure add_product(
isbn_num IN products.isbn%type,
prod_name IN products.product_name%type,
price IN products.price%type,
prod_desc IN products."description"%type,
category_id IN products.category_id%type
)
is
begin
  insert into products (isbn,product_name,price, "description", category_id)
    values (isbn_num, prod_name,price,prod_desc,category_id);
end;
*/

--calling procedure
--execute ADD_PRODUCT(100,'sample book',1300,'sample book product',3);

DECLARE
    isbn_val   products.isbn%TYPE;
    name_val   products.product_name%TYPE;
    price_val products.price%TYPE;
    desc_val   products."description"%TYPE;
    cat_id_val products.category_id%TYPE;
BEGIN
    isbn_val := 101;
    name_val := 'the alchemist';
    price_val := 799;
    desc_val := 'new book from paul cohelo';
    cat_id_val := 3;
    add_product(isbn_val, name_val, price_val, desc_val, cat_id_val);
END;

SELECT
    *
FROM
    products;