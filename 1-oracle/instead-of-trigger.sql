--view
create or replace view view_products_categories as
select category_name, isbn, product_name, price, "description"
from categories inner join products using (category_id);

--instead of trigger
create or replace trigger categories_products_insteadof_trg
instead of insert
on view_products_categories
for each row
declare
l_cat_id categories.category_id%type;
begin
    insert into categories(category_name) values(:new.category_name)
    returning category_id into l_cat_id;
    
    insert into products(isbn,product_name,price,"description",category_id) 
    values(:new.isbn, :new.product_name,:new.price,:new."description",l_cat_id);
end;

--actual insert query
insert into view_products_categories (category_name, isbn,product_name, price, "description")
values ('headphone',111,'boat head phone',1200,'brand new head phone');

--getting the values from the view
select * from view_products_categories;