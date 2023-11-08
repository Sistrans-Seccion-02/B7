--REQ 1

SELECT HABITACION, SUM(COSTOTOTAL) AS DINERO_RECOLECTADO
FROM cuentasconsumo
WHERE FECHADELCONSUMO BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE
GROUP BY HABITACION;

SELECT * FROM cuentasconsumo;
CREATE INDEX idx_fechadelconsumo ON CUENTASCONSUMO(FECHADELCONSUMO);

--REQ 2

SELECT 
    SERVICIO_TYPE AS NOMBRESERVICIO,
    COUNT(*) AS VECESSOLICITADO
FROM 
    solicitudes_servicios
WHERE 
    FECHA_SOLICITUD BETWEEN :fechaInicio AND :fechaFin
GROUP BY 
    SERVICIO_TYPE
ORDER BY 
    VECESSOLICITADO DESC
FETCH FIRST 20 ROWS ONLY;

SELECT * FROM solicitudes_servicios; 
CREATE INDEX idx_fecha_solicitud ON solicitudes_servicios(FECHA_SOLICITUD);


---REQ 3
SELECT * FROM reservaciones;

SELECT HABITACION_ID, 
       (COUNT(*) * 100.0 / (SELECT COUNT(*) FROM reservaciones WHERE FECHALLEGADA BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE)) AS PORCENTAJE_OCUPACION
FROM reservaciones 
WHERE FECHALLEGADA BETWEEN ADD_MONTHS(SYSDATE, -12) AND SYSDATE 
GROUP BY HABITACION_ID;

CREATE INDEX idx_fechallegada ON reservaciones(FECHALLEGADA);

--REQ 4

SELECT * FROM solicitudes_servicios
WHERE 
    (COSTO BETWEEN :precio_min AND :precio_max OR (:precio_min IS NULL AND :precio_max IS NULL))
AND 
    (FECHA_SOLICITUD BETWEEN TO_DATE(:fecha_inicio, 'DD-MON-YY') AND TO_DATE(:fecha_fin, 'DD-MON-YY') OR (:fecha_inicio IS NULL AND :fecha_fin IS NULL))
AND 
    (SERVICIO_TYPE LIKE '%' || :nombre_servicio || '%' OR :nombre_servicio IS NULL);

SELECT * FROM solicitudes_servicios; 

CREATE INDEX idx_servicio_type ON solicitudes_servicios(SERVICIO_TYPE);

CREATE INDEX idx_fecha_solicitud ON solicitudes_servicios(FECHA_SOLICITUD);

CREATE INDEX idx_costo ON solicitudes_servicios(COSTO);


--REQ 5

SELECT c.CLIENTE, cl.NOMBRE, c.FECHADELCONSUMO, c.COSTOTOTAL
FROM cuentasconsumo c
JOIN Clientes cl ON c.CLIENTE = cl.CEDULA
WHERE c.CLIENTE = :cedulaUsuario 
AND c.FECHADELCONSUMO BETWEEN TO_DATE(:fechaInicio, 'DD-MON-YY') AND TO_DATE(:fechaFin, 'DD-MON-YY')
ORDER BY c.FECHADELCONSUMO;

--REQ 6

SELECT FECHALLEGADA, COUNT(HABITACION_ID) AS NumeroHabitacionesOcupadas
FROM reservaciones
GROUP BY FECHALLEGADA
ORDER BY NumeroHabitacionesOcupadas DESC;

SELECT FECHALLEGADA, COUNT(HABITACION_ID) AS NumeroHabitacionesOcupadas
FROM reservaciones
GROUP BY FECHALLEGADA
ORDER BY NumeroHabitacionesOcupadas ASC;

SELECT FECHADELCONSUMO, SUM(COSTOTOTAL) AS IngresosTotales
FROM cuentasconsumo
GROUP BY FECHADELCONSUMO
ORDER BY IngresosTotales DESC;


CREATE INDEX idx_fechallegada ON reservaciones(FECHALLEGADA);

SELECT * FROM reservaciones;



--REQ 7

WITH DiasEstadia AS (
    SELECT r.TITULAR_ID AS CLIENTE, 
           SUM(TO_DATE(e.CHECKOUT, 'DD-MM-YYYY') - TO_DATE(e.CHECKIN, 'DD-MM-YYYY')) AS DIAS 
    FROM reservaciones r 
    JOIN estadias e ON r.ID = e.RESERVA_ID 
    WHERE e.CHECKIN_REALIZADO = 1 AND e.CHECKOUT_REALIZADO = 1 
    GROUP BY r.TITULAR_ID
), 
Consumo AS (
    SELECT c.CLIENTE, 
           SUM(c.COSTOTOTAL) AS TOTALCONSUMO 
    FROM cuentasconsumo c 
    WHERE TO_DATE(c.FECHADELCONSUMO, 'DD-MM-YYYY') > (SYSDATE - INTERVAL '1' YEAR)
    GROUP BY c.CLIENTE
)
SELECT DISTINCT d.CLIENTE 
FROM DiasEstadia d 
LEFT JOIN Consumo co ON d.CLIENTE = co.CLIENTE 
WHERE d.DIAS >= 14 OR co.TOTALCONSUMO > 15000000;

--REQ 8

SELECT NOMBRESERVICIO, VECESSOLICITADO
FROM (
    SELECT SERVICIO_TYPE AS NOMBRESERVICIO, COUNT(*) AS VECESSOLICITADO
    FROM solicitudes_servicios
    WHERE FECHA_SOLICITUD BETWEEN TO_DATE('01-JAN-2023', 'DD-MON-YYYY') AND TO_DATE('31-DEC-2023', 'DD-MON-YYYY')
    GROUP BY SERVICIO_TYPE
    HAVING COUNT(*) < (3 * 52)
    ORDER BY VECESSOLICITADO ASC
)
WHERE ROWNUM <= 3;


--REQ 9

SELECT 
    CLIENTE,
    SERVICIO,
    COUNT(*) AS NUMERO_DE_VECES
FROM 
    cuentasconsumo
WHERE 
    SERVICIO = :servicioSeleccionado
    AND FECHADELCONSUMO BETWEEN :fechaInicio AND :fechaFin
GROUP BY 
    CLIENTE, SERVICIO
ORDER BY 
    NUMERO_DE_VECES DESC;



--REQ 10

SELECT 
    c.CLIENTE,
    c.FECHADELCONSUMO,
    c.SERVICIO
FROM 
    cuentasconsumo c
WHERE 
    NOT EXISTS (
        SELECT 1 
        FROM cuentasconsumo cc 
        WHERE cc.CLIENTE = c.CLIENTE
        AND cc.SERVICIO = :servicioSeleccionado
        AND cc.FECHADELCONSUMO BETWEEN :fechaInicio AND :fechaFin
    )
GROUP BY 
    c.CLIENTE, c.FECHADELCONSUMO, c.SERVICIO
ORDER BY 
    c.CLIENTE, c.FECHADELCONSUMO DESC;



--REQ 11

--Servicio mas y menos consumido
WITH Weeks AS (
    SELECT 
        TRUNC(FECHADELCONSUMO, 'IW') AS inicioSemana,
        TRUNC(FECHADELCONSUMO, 'IW') + 6 AS finSemana,
        SERVICIO,
        COUNT(*) AS consumo
    FROM cuentasconsumo
    GROUP BY 
        TRUNC(FECHADELCONSUMO, 'IW'), 
        SERVICIO
),

MaxMin AS (
    SELECT 
        inicioSemana,
        finSemana,
        SERVICIO,
        consumo,
        ROW_NUMBER() OVER(PARTITION BY inicioSemana ORDER BY consumo DESC) AS rn_max,
        ROW_NUMBER() OVER(PARTITION BY inicioSemana ORDER BY consumo ASC) AS rn_min
    FROM Weeks
)

SELECT 
    inicioSemana,
    finSemana,
    MAX(CASE WHEN rn_max = 1 THEN consumo END) AS ConsumoMax,
    MAX(CASE WHEN rn_max = 1 THEN SERVICIO END) AS TipoConsumoMax,
    MIN(CASE WHEN rn_min = 1 THEN consumo END) AS ConsumoMin,
    MIN(CASE WHEN rn_min = 1 THEN SERVICIO END) AS TipoConsumoMin
FROM MaxMin
GROUP BY inicioSemana, finSemana
ORDER BY inicioSemana;


WITH Weeks AS (
    SELECT 
        TRUNC(FECHALLEGADA, 'IW') AS inicioSemana,
        TRUNC(FECHALLEGADA, 'IW') + 6 AS finSemana,
        TIPOHABITACION_ID,
        COUNT(*) AS reservas
    FROM reservaciones
    GROUP BY 
        TRUNC(FECHALLEGADA, 'IW'), 
        TIPOHABITACION_ID
),

MaxMin AS (
    SELECT 
        inicioSemana,
        finSemana,
        TIPOHABITACION_ID,
        reservas,
        ROW_NUMBER() OVER(PARTITION BY inicioSemana ORDER BY reservas DESC) AS rn_max,
        ROW_NUMBER() OVER(PARTITION BY inicioSemana ORDER BY reservas ASC) AS rn_min
    FROM Weeks
)

SELECT 
    m.inicioSemana,
    m.finSemana,
    MAX(CASE WHEN m.rn_max = 1 THEN m.reservas END) AS HabitacionMax,
    MAX(CASE WHEN m.rn_max = 1 THEN t.NOMBRE END) AS TipoMax,
    MIN(CASE WHEN m.rn_min = 1 THEN m.reservas END) AS HabitacionMin,
    MIN(CASE WHEN m.rn_min = 1 THEN t.NOMBRE END) AS TipoMin
FROM MaxMin m
JOIN tipohabitaciones t ON m.TIPOHABITACION_ID = t.ID
GROUP BY m.inicioSemana, m.finSemana
ORDER BY m.inicioSemana;


--REQ 12

WITH CheckInOut AS (
  SELECT r.TITULAR_ID
  FROM estadias e
  JOIN reservaciones r ON e.RESERVA_ID = r.ID
  WHERE e.CHECKIN_REALIZADO = 1 AND e.CHECKOUT_REALIZADO = 1
),
ConsumosCostosos AS (
  SELECT c.CLIENTE
  FROM cuentasconsumo c
  WHERE c.COSTOTOTAL > 300000
  GROUP BY c.CLIENTE, TO_CHAR(c.FECHADELCONSUMO, 'YYYY'), TO_CHAR(c.FECHADELCONSUMO, 'Q')
  HAVING COUNT(DISTINCT TO_CHAR(c.FECHADELCONSUMO, 'Q')) >= 1
),
ServiciosLargos AS (
  SELECT sp.TITULAR AS CLIENTE
  FROM reservaspas sp
  WHERE sp.DURACION > 4
  UNION
  SELECT sa.TITULAR AS CLIENTE
  FROM reservasalas sa
  WHERE sa.DURACION > 4
)
SELECT cl.CEDULA, cl.NOMBRE,
  CASE
    WHEN cl.CEDULA IN (SELECT TITULAR_ID FROM CheckInOut) THEN 'Check-in y check-out'
    WHEN cl.CEDULA IN (SELECT CLIENTE FROM ConsumosCostosos) THEN 'Consumo en servicios mayor a 300000'
    WHEN cl.CEDULA IN (SELECT CLIENTE FROM ServiciosLargos) THEN 'Reservas en spa o sala por más de 4 horas'
  END AS RAZON
FROM clientes cl
WHERE cl.CEDULA IN (SELECT TITULAR_ID FROM CheckInOut)
   OR cl.CEDULA IN (SELECT CLIENTE FROM ConsumosCostosos)
   OR cl.CEDULA IN (SELECT CLIENTE FROM ServiciosLargos);


--------------------------------------------------------------------------------------------



--SCRIPT SOLICITUDES SERVICIO
CREATE SEQUENCE solicitud_servicio_seq
  START WITH 1
  INCREMENT BY 1
  NOCACHE
  NOCYCLE;


CREATE OR REPLACE TRIGGER solicitud_servicio_trigger
BEFORE INSERT ON solicitudes_servicios
FOR EACH ROW
BEGIN
  SELECT solicitud_servicio_seq.NEXTVAL INTO :NEW.ID FROM dual;
END;
/

DECLARE
    v_servicio_type VARCHAR2(50);
    v_servicio_id NUMBER;
    v_fecha_solicitud DATE;
    v_costo NUMBER;
BEGIN
    FOR i IN 1..100 LOOP
        -- Asignar un tipo de servicio aleatorio
        SELECT COLUMN_VALUE
        INTO v_servicio_type
        FROM (
            SELECT COLUMN_VALUE
            FROM TABLE(SYS.ODCIVARCHAR2LIST('internet', 'piscina', 'gym', 'restaurante', 'bar', 'supermercado', 'tienda', 
                 'sala conferencia', 'sala reunion', 'limpieza', 'prestamo utencilio', 'spa'))
            ORDER BY DBMS_RANDOM.RANDOM
        )
        WHERE ROWNUM = 1;
        
        -- Asignar un ID de servicio correspondiente al tipo de servicio
        CASE v_servicio_type
            WHEN 'internet' THEN v_servicio_id := 73;
            WHEN 'piscina' THEN v_servicio_id := 5;
            WHEN 'gym' THEN v_servicio_id := 51;
            WHEN 'restaurante' THEN v_servicio_id := 42;
            WHEN 'bar' THEN v_servicio_id := 5;
            WHEN 'supermercado' THEN v_servicio_id := 29;
            WHEN 'tienda' THEN v_servicio_id := 100;
            WHEN 'sala conferencia' THEN v_servicio_id := 51;
            WHEN 'sala reunion' THEN v_servicio_id := 100;
            WHEN 'limpieza' THEN v_servicio_id := 29;
            WHEN 'prestamo utencilio' THEN v_servicio_id := 29;
            WHEN 'spa' THEN v_servicio_id := 42;
        END CASE;
        
        -- Asignar una fecha aleatoria en 2023
        v_fecha_solicitud := TO_DATE('01-JAN-23', 'DD-MON-YY') + DBMS_RANDOM.VALUE(0, 364);
        
        -- Asignar un costo aleatorio entre 1 y 100
        v_costo := ROUND(DBMS_RANDOM.VALUE(1, 100), 2);
        
        -- Insertar el registro en la tabla
        INSERT INTO solicitudes_servicios (SERVICIO_TYPE, SERVICIO_ID, FECHA_SOLICITUD, COSTO)
        VALUES (v_servicio_type, v_servicio_id, v_fecha_solicitud, v_costo);
    END LOOP;
    
    COMMIT;
END;





SELECT * FROM estadias;
DELETE FROM estadias;

SELECT * FROM cuentasconsumo;
DELETE FROM cuentasconsumo;

SELECT * FROM reservaciones;
DELETE FROM reservaciones;

SELECT * FROM habitaciones;
DELETE FROM habitaciones;

SELECT * FROM clientes;
DELETE FROM clientes;



--SCRIPT ESTADIAS
DECLARE
  TYPE IdArray IS TABLE OF NUMBER INDEX BY PLS_INTEGER;
  v_reserva_ids IdArray;
  v_cuentaconsumo_ids IdArray;
  v_id NUMBER(19, 0);
  v_reserva_id NUMBER(19, 0);
  v_cuentaconsumo_id NUMBER(19, 0);
  v_pazysalvo NUMBER(1, 0);
  v_checkin DATE;
  v_checkout DATE;
  v_checkin_realizado NUMBER(1, 0);
  v_checkout_realizado NUMBER(1, 0);
  n_reservas NUMBER;
  n_cuentas NUMBER;
  max_id NUMBER;
BEGIN
  -- Encontrar el ID máximo actual en la tabla estadias y comenzar a partir del siguiente
  SELECT COALESCE(MAX(ID), 0) INTO max_id FROM estadias;
  v_id := max_id;
  
  -- Cargar IDs existentes de las tablas relacionadas
  SELECT ID BULK COLLECT INTO v_reserva_ids FROM reservaciones;
  SELECT ID BULK COLLECT INTO v_cuentaconsumo_ids FROM cuentasconsumo;
  
  -- Contar el número de IDs disponibles
  n_reservas := v_reserva_ids.COUNT;
  n_cuentas := v_cuentaconsumo_ids.COUNT;
  
  -- Iniciar el bucle para insertar los registros
  FOR i IN 1..4000 LOOP
    BEGIN
      v_id := v_id + 1; -- Incrementar el ID basado en el máximo actual
      -- Seleccionar un ID aleatorio de las colecciones
      v_reserva_id := v_reserva_ids(TRUNC(DBMS_RANDOM.VALUE(1, n_reservas)));
      v_cuentaconsumo_id := v_cuentaconsumo_ids(TRUNC(DBMS_RANDOM.VALUE(1, n_cuentas)));
      -- Generar valores aleatorios para las columnas restantes
      v_pazysalvo := TRUNC(DBMS_RANDOM.VALUE(0, 2)); -- genera 0 o 1 de forma aleatoria
      v_checkin_realizado := TRUNC(DBMS_RANDOM.VALUE(0, 2)); -- genera 0 o 1 de forma aleatoria
      v_checkout_realizado := TRUNC(DBMS_RANDOM.VALUE(0, 2)); -- genera 0 o 1 de forma aleatoria
      -- Generar fechas de checkin y checkout
      v_checkin := TRUNC(SYSDATE + DBMS_RANDOM.VALUE(-365, 365)); -- fecha de checkin aleatoria en el rango de -365 a 365 días desde hoy
      v_checkout := v_checkin + TRUNC(DBMS_RANDOM.VALUE(1, 15)); -- fecha de checkout entre 1 y 14 días después del checkin
      -- Insertar el registro en la tabla estadias
      INSERT INTO estadias
        (ID, RESERVA_ID, CUENTACONSUMO_ID, PAZYSALVO, CHECKIN, CHECKOUT, CHECKIN_REALIZADO, CHECKOUT_REALIZADO)
      VALUES
        (v_id, v_reserva_id, v_cuentaconsumo_id, v_pazysalvo, v_checkin, v_checkout, v_checkin_realizado, v_checkout_realizado);
    EXCEPTION
      WHEN DUP_VAL_ON_INDEX THEN
        -- Manejar la excepción de valor duplicado
        NULL; -- Aquí se puede manejar el error o registrar en un log
    END;
  END LOOP;
  
  COMMIT;
END;
/








--SCRIPT CUENTASCONSUMO
BEGIN
    FOR i IN 1..750000 LOOP
        INSERT INTO cuentasconsumo (
            ID,
            COSTOTOTAL,
            SERVICIO,
            HABITACION,
            CLIENTE,
            FECHADELCONSUMO
        ) VALUES (
            i,
            ROUND(DBMS_RANDOM.VALUE(50, 1000), 2), -- Costo total con dos decimales
            CASE TRUNC(DBMS_RANDOM.VALUE(1, 4)) -- Generar 1, 2 o 3 de manera equitativa
                WHEN 1 THEN 'Spa'
                WHEN 2 THEN 'Salas'
                WHEN 3 THEN 'Extra'
            END,
            TRUNC(DBMS_RANDOM.VALUE(1, 500)), -- Número de habitación
            TRUNC(DBMS_RANDOM.VALUE(100040457, 100041581)), -- Número de cédula (cliente)
            TRUNC(SYSDATE - DBMS_RANDOM.VALUE(0, 365)) -- Fecha de consumo hasta un año atrás
        );
    END LOOP;
    COMMIT;
END;
/



--SCRIPT RESERVACIONES

-- Asegurarse de que la secuencia existe
CREATE SEQUENCE reserva_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

-- Iniciar el script para insertar los registros
DECLARE
    TYPE t_habitacion_id IS TABLE OF habitaciones.ID%TYPE INDEX BY PLS_INTEGER;
    v_habitaciones t_habitacion_id;
    v_fechallegada DATE;
    v_fechasalida DATE;
    v_hotel_id NUMBER;
    v_planconsumo_id NUMBER;
    v_habitacion_id NUMBER;
    v_count NUMBER;
BEGIN
    -- Cargar todos los IDs de habitación en la colección
    SELECT ID BULK COLLECT INTO v_habitaciones FROM habitaciones;

    v_count := v_habitaciones.COUNT;

    FOR i IN 1..40000 LOOP
        -- Generar fechas aleatorias para llegada y salida
        v_fechallegada := TRUNC(SYSDATE) + DBMS_RANDOM.VALUE(0, 365);
        v_fechasalida := v_fechallegada + DBMS_RANDOM.VALUE(1, 15);

        -- Asignar HOTEL_ID de manera aleatoria
        v_hotel_id := TRUNC(DBMS_RANDOM.VALUE(1, 4));

        -- Asignar PLANCONSUMO_ID basado en HOTEL_ID
        IF v_hotel_id = 1 THEN
            v_planconsumo_id := TRUNC(DBMS_RANDOM.VALUE(1, 4));
        ELSIF v_hotel_id = 2 THEN
            v_planconsumo_id := 3;
        ELSE
            v_planconsumo_id := TRUNC(DBMS_RANDOM.VALUE(1, 3));
        END IF;

        -- Seleccionar un HABITACION_ID aleatorio de la colección precargada
        v_habitacion_id := v_habitaciones(TRUNC(DBMS_RANDOM.VALUE(1, v_count)));

        INSERT INTO reservaciones (ID, FECHALLEGADA, FECHASALIDA, TIPOHABITACION_ID, CANTIDADPERSONAS, HOTEL_ID, PLANCONSUMO_ID, TITULAR_ID, HABITACION_ID)
        VALUES (reserva_seq.NEXTVAL,
                v_fechallegada,
                v_fechasalida,
                TRUNC(DBMS_RANDOM.VALUE(1, 4)), -- Tipo de habitación
                TRUNC(DBMS_RANDOM.VALUE(1, 4)), -- Cantidad de personas
                v_hotel_id,
                v_planconsumo_id,
                TRUNC(DBMS_RANDOM.VALUE(100040457, 100041581)), -- Titular ID
                v_habitacion_id -- HABITACION_ID seleccionado de la colección
               );
    END LOOP;
    COMMIT; -- Asegurarse de confirmar las transacciones
END;
/





--SCRIPT HABITACIONES
-- Asegurarse de que la secuencia existe
CREATE SEQUENCE habitacion_seq
    START WITH 1
    INCREMENT BY 1
    NOMAXVALUE;

-- Iniciar el script para insertar los registros
BEGIN
    FOR i IN 1..730000 LOOP
        INSERT INTO habitaciones (ID, COSTONOCHE, HOTEL_ID, TIPO_HABITACION_ID)
        VALUES (habitacion_seq.NEXTVAL, -- Genera el siguiente ID de la secuencia
                TRUNC(dbms_random.value(50, 200), 2), -- Genera un costo por noche aleatorio entre 50 y 200
                MOD(i-1,3)+1, -- Asigna HOTEL_ID de manera cíclica (1, 2, 3, 1, ...)
                MOD(i-1,3)+1  -- Asigna TIPO_HABITACION_ID de manera cíclica (1, 2, 3, 1, ...)
               );
    END LOOP;
    COMMIT; -- Asegurarse de confirmar las transacciones
END;
/


--SCRIPT CLIENTES
DECLARE
  v_cedula NUMBER := 100000001; -- Empieza después del último valor conocido
  v_rol VARCHAR2(12);
  v_nombre VARCHAR2(100);
  v_fechaNacimiento DATE;
  v_nacionalidad VARCHAR2(20);
  v_edad NUMBER;
  v_email VARCHAR2(100);
  v_telefono VARCHAR2(20);
BEGIN
  FOR i IN 1..730000 LOOP -- Ya tienes 10, entonces agregas 99990 más
    v_cedula := v_cedula + 1;

    IF MOD(i, 2) = 0 THEN
      v_rol := 'Acompañante';
    ELSE
      v_rol := 'Titular';
    END IF;

    -- Aquí tendrías que definir cómo generar nombres, fechas de nacimiento, etc.
    -- Por ejemplo, puedes usar DBMS_RANDOM para generar valores aleatorios.
    v_nombre := 'Nombre' || TO_CHAR(v_cedula);
    v_fechaNacimiento := TO_DATE('01-JAN-1990','DD-MON-YYYY') + DBMS_RANDOM.VALUE(-3650, 3650);
    v_nacionalidad := 'Nacionalidad';
    v_edad := FLOOR(MONTHS_BETWEEN(SYSDATE, v_fechaNacimiento) / 12);
    v_email := 'correo' || TO_CHAR(v_cedula) || '@correo.com';
    v_telefono := '300' || LPAD(TO_CHAR(v_cedula), 7, '0');

    INSERT INTO clientes (CEDULA, ROL, NOMBRE, FECHANACIMIENTO, NACIONALIDAD, EDAD, EMAIL, TELEFONO)
    VALUES (v_cedula, v_rol, v_nombre, v_fechaNacimiento, v_nacionalidad, v_edad, v_email, v_telefono);
  END LOOP;
  COMMIT;
END;



