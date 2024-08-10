-- Creación de la base de datos 
CREATE DATABASE pruebaraul
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


-- Consultas 
SELECT * FROM EMPLEADO WHERE UPPER(APELLIDO) = 'GARCIA';
UPDATE EMPLEADO SET EMAIL = 'x@x.com' WHERE ID = 5;
