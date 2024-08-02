set serveroutput on;

DECLARE
    TYPE product_names IS
        TABLE OF VARCHAR2(10);
    product_name_collection product_names;
    product_name            VARCHAR2(10);
    l_index                 INT;
BEGIN
    product_name_collection := product_names('dell xps', 'lenovo', 'hp probook');
    product_name_collection.DELETE(2);
    product_name_collection(2) := 'sub';
    l_index := product_name_collection.first;
    LOOP
        EXIT WHEN l_index IS NULL;
        dbms_output.put_line(l_index
                             || ':'
                             || product_name_collection(l_index));
        l_index := product_name_collection.next(l_index);
    END LOOP;

END;