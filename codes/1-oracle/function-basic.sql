CREATE OR REPLACE FUNCTION addmethod (
    first_number  IN NUMBER,
    second_number IN NUMBER
) RETURN NUMBER IS
    l_result NUMBER NOT NULL := 0;
BEGIN
    dbms_output.put_line(first_number);
    dbms_output.put_line(second_number);
    l_result := first_number + second_number;
    RETURN l_result;
END;