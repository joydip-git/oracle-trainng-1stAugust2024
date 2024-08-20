set serveroutput on;

DECLARE
    TYPE product_names IS
        TABLE OF VARCHAR2(10);
    product_name_collection product_names;
    l_count                 INT := 0;
    product_name            VARCHAR2(10);
    l_choice                CHAR(1) := 'A';
BEGIN
    product_name_collection := product_names('dell xps', 'lenovo');
    l_count := product_name_collection.count;
    CASE l_choice
        WHEN 'A' THEN
            product_name_collection.extend(1);
            product_name_collection(l_count + 1) := 'hp probook';
        WHEN 'D' THEN
            product_name_collection.trim();
        ELSE
            dbms_output.put_line('something wrong'
                                 || ' '
                                 || l_choice);
    END CASE;

    l_count := product_name_collection.count;
    FOR i IN 1..l_count LOOP
        product_name := product_name_collection(i);
        dbms_output.put_line(product_name);
    END LOOP;

END;