create or replace function get_products_by_category
return SYS_REFCURSOR
as
l_records SYS_REFCURSOR;
begin
open l_records for select c.category_name, p.isbn, p.product_id, p.product_name, p.description, p.price
from categories c
left outer join products p
on c.category_id = p.category_id
group by c.category_name, p.isbn, p.product_id, p.product_name, p.description, p.price
order by c.category_name;
return l_records;
end;


