set serveroutput on;

DECLARE
    TYPE product_names IS
        TABLE OF VARCHAR2(10);
    product_name_collection product_names;
    l_count                 INT := 0;
    product_name            VARCHAR2(10);
    l_index                 INT := 2;
BEGIN
    product_name_collection := product_names('dell xps', 'lenovo', 'hp probook');
    l_count := product_name_collection.count;
    --delete from the end
    --product_name_collection.trim();
    
    --delete nth element
    product_name_collection.DELETE(l_index);
    --l_count := product_name_collection.count;
    dbms_output.put_line(l_count);
    FOR i IN 1..l_count LOOP
        IF ( i != l_index ) THEN
            product_name := product_name_collection(i);
        ELSE
            dbms_output.put_line(l_index || ' is empty');
        END IF;
    END LOOP;
--    FOR i IN 2..(l_count+1) LOOP
--        product_name := product_name_collection(i);
--        dbms_output.put_line(product_name);
--    END LOOP;

END;