select * from products where category_id=1;
select * from categories;

create or replace procedure add_product(
pisbn IN products.isbn%type,
pname IN products.product_name%type,
pprice IN products.price%type,
pcid IN products.category_id%type
)
as 
begin
    insert into products(isbn,product_name,price,category_id) values(pisbn,pname,pprice,pcid);
end;

create or replace procedure get_product_count(
    productcount OUT number
)
as 
l_product_count number;
begin
    select count(product_name) into l_product_count from products;
    productcount :=l_product_count;
end;


create or replace function fetch_product_count_for_category(categoryid number) 
return number
as 
l_product_count number;
begin
    select count(product_name) into l_product_count from products where category_id=categoryid;
    return l_product_count;
end;
