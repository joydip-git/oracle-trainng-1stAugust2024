set serveroutput on;
--just cursor variable declaration...
DECLARE
--strong typed cursor
    type c_product_strong_cursor is ref cursor return products%rowtype;
    c_product_1 c_product_strong_cursor;
    
--weak typed cursor
     type c_product_weak_cursor is ref cursor;
     c_product_2 c_product_weak_cursor;
     
--since Oracle 9i to declare weak typed cursor
    c_product_3 SYS_REFCURSOR;

BEGIN
   
END;