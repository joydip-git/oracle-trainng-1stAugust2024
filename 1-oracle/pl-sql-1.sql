SET SERVEROUTPUT ON;

DECLARE
    l_first  INT;
    l_second INT := 20;
    l_res    INT DEFAULT 0;
    l_count  INT := 0;
    l_str    VARCHAR2(50);
    l_str_concat VARCHAR2(100);
BEGIN
    --l_first := 10;
    l_res := l_first + l_second;
    IF l_res IS NULL THEN
        dbms_output.put_line('NULL');
    ELSE
        dbms_output.put_line(l_res);
    END IF;

   
    
    l_str_concat := l_str + 'hello ';
    dbms_output.put_line(l_str_concat);
END;