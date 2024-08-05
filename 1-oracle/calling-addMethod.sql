set serveroutput on;

DECLARE
    first_param_value  NUMBER := 10;
    second_param_value NUMBER := 20;
    l_add_result       NUMBER NOT NULL := 0;
BEGIN
    l_add_result := addmethod(second_number => second_param_value, first_number => first_param_value);
    dbms_output.put_line(l_add_result);
END;