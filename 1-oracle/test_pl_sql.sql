-- Structured Query Language
-- Procedural Language Extension for SQL (PL/SQL)
/*
CREATE TABLE products (
    product_id   INT PRIMARY KEY NOT NULL,
    product_name VARCHAR(50) NOT NULL,
    price        DECIMAL DEFAULT 0
);

-- drop table products;

INSERT INTO products (
    product_id,
    product_name,
    price
) VALUES (
    100,
    'dell xps',
    100000.00
);
*/

set SERVEROUTPUT ON;
declare
   l_computed_price DECIMAL := 0; 
   l_price DECIMAL :=0;
begin
    select price into l_price from products where product_id=100;
    if l_price>=100000 then
    l_computed_price := l_price*2;
    end if;

   dbms_output.put_line('calculated price is: ' || l_computed_price);     
   
end;


