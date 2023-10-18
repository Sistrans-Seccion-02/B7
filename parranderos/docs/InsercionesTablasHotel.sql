-- Insertar registros en la tabla hoteles
INSERT INTO hoteles (id, capacidad) VALUES (1, 100);
INSERT INTO hoteles (id, capacidad) VALUES (2, 150);
INSERT INTO hoteles (id, capacidad) VALUES (3, 200);

-- Insertar registros en la tabla usuarios
INSERT INTO usuarios (id, nombre, correo, rol, hotel_id) VALUES (1, 'Juan Pérez', 'juan@correo.com', 'Administrador', 1);
INSERT INTO usuarios (id, nombre, correo, rol, hotel_id) VALUES (2, 'María García', 'maria@correo.com', 'Recepcionista', 1);
INSERT INTO usuarios (id, nombre, correo, rol, hotel_id) VALUES (3, 'Luis Torres', 'luis@correo.com', 'Empleado', 1);

-- Insertar registros en la tabla planesconsumo
INSERT INTO planesconsumo (id, info, hotel_id) VALUES (1, 'Plan básico', 1);
INSERT INTO planesconsumo (id, info, hotel_id) VALUES (2, 'Plan medio', 1);
INSERT INTO planesconsumo (id, info, hotel_id) VALUES (3, 'Plan completo', 1);

-- Insertar registros en la tabla clientes
INSERT INTO clientes (cedula, rol, nombre, fechanacimiento, nacionalidad, edad, email, telefono) VALUES (100000001, 'Titular', 'Carlos Ruiz', TO_DATE('1985-06-15', 'YYYY-MM-DD'), 'Colombiano', '36', 'carlos@correo.com', '3001234567');
INSERT INTO clientes (cedula, rol, nombre, fechanacimiento, nacionalidad, edad, email, telefono) VALUES (100000002, 'Acompañante', 'Sofía Gómez', TO_DATE('1990-08-10', 'YYYY-MM-DD'), 'Mexicana', '33', 'sofia@correo.com', '3209876543');
INSERT INTO clientes (cedula, rol, nombre, fechanacimiento, nacionalidad, edad, email, telefono) VALUES (100000003, 'Titular', 'Diego Fernández', TO_DATE('1995-02-20', 'YYYY-MM-DD'), 'Argentino', '28', 'diego@correo.com', '3104567891');

-- Insertar registros en la tabla habitaciones
INSERT INTO habitaciones (id, costonoche, tipohabitacion, capacidad, hotel_id) VALUES (1, 100.5, 'Suite', 2, 1);
INSERT INTO habitaciones (id, costonoche, tipohabitacion, capacidad, hotel_id) VALUES (2, 75.0, 'Doble', 2, 1);
INSERT INTO habitaciones (id, costonoche, tipohabitacion, capacidad, hotel_id) VALUES (3, 50.0, 'Sencilla', 1, 1);

-- Insertar registros en la tabla cuentasconsumo
INSERT INTO cuentasconsumo (id, costoTotal, habitacion) VALUES (1, 150.5, 1);
INSERT INTO cuentasconsumo (id, costoTotal, habitacion) VALUES (2, 100.0, 2);
INSERT INTO cuentasconsumo (id, costoTotal, habitacion) VALUES (3, 50.5, 3);

-- Insertar registros en la tabla productos
INSERT INTO productos (id, nombre, valor, cantidad) VALUES (1, 'Cerveza', 3.0, 50);
INSERT INTO productos (id, nombre, valor, cantidad) VALUES (2, 'Refresco', 1.5, 100);
INSERT INTO productos (id, nombre, valor, cantidad) VALUES (3, 'Agua', 1.0, 200);

-- Insertar registros en la tabla restaurantes
INSERT INTO restaurantes (id, capacidad, estilo, pp) VALUES (1, 50, 'Italiano', 'Pasta: $10, Pizza: $8');
INSERT INTO restaurantes (id, capacidad, estilo, pp) VALUES (2, 60, 'Mexicano', 'Taco: $5, Burrito: $7');
INSERT INTO restaurantes (id, capacidad, estilo, pp) VALUES (3, 70, 'Colombiano', 'Bandeja Paisa: $12, Arepa: $2');

-- Insertar registros en la tabla bares2
INSERT INTO bares2 (id, capacidad, estilo, pp) VALUES (1, 50, 'Bar deportivo', 'Cerveza: $3, Refresco: $1.5');
INSERT INTO bares2 (id, capacidad, estilo, pp) VALUES (2, 40, 'Bar temático', 'Cerveza: $3.5, Whisky: $7');
INSERT INTO bares2 (id, capacidad, estilo, pp) VALUES (3, 30, 'Pub', 'Cerveza artesanal: $4, Vino: $5');

-- Insertar registros en la tabla supermercados
INSERT INTO supermercados (id, capacidad, pp) VALUES (1, 50, 'Papas: $1, Refresco: $1.5');
INSERT INTO supermercados (id, capacidad, pp) VALUES (2, 60, 'Pan: $0.5, Leche: $1');
INSERT INTO supermercados (id, capacidad, pp) VALUES (3, 70, 'Arroz: $1, Pollo: $5');

-- Insertar registros en la tabla tiendas
INSERT INTO tiendas (id, tipo, nombre, pp) VALUES (1, 'Ropa', 'ModaEstilo', 'Camisa: $20, Jeans: $30');
INSERT INTO tiendas (id, tipo, nombre, pp) VALUES (2, 'Electrónica', 'TecnoMax', 'Celular: $200, Laptop: $500');
INSERT INTO tiendas (id, tipo, nombre, pp) VALUES (3, 'Juguetes', 'DiversiónKids', 'Muñeca: $10, Auto RC: $25');

-- Insertar registros en la tabla reservasalas
INSERT INTO reservasalas (id, costo, reserva) VALUES (1, 100.5, TO_DATE('2023-11-01', 'YYYY-MM-DD'));
INSERT INTO reservasalas (id, costo, reserva) VALUES (2, 150.0, TO_DATE('2023-12-15', 'YYYY-MM-DD'));
INSERT INTO reservasalas (id, costo, reserva) VALUES (3, 75.5, TO_DATE('2023-10-20', 'YYYY-MM-DD'));

-- Insertar registros en la tabla salasreuniones
INSERT INTO salasreuniones (id, capacidad, costoHora, costoAdicional) VALUES (1, '10', 25.0, 5.0);
INSERT INTO salasreuniones (id, capacidad, costoHora, costoAdicional) VALUES (2, '20', 30.0, 4.0);
INSERT INTO salasreuniones (id, capacidad, costoHora, costoAdicional) VALUES (3, '30', 35.0, 3.0);

-- Insertar registros en la tabla salasconferencias
INSERT INTO salasconferencias (id, capacidad, costoHora) VALUES (1, '50', 50.0);
INSERT INTO salasconferencias (id, capacidad, costoHora) VALUES (2, '100', 60.0);
INSERT INTO salasconferencias (id, capacidad, costoHora) VALUES (3, '150', 70.0);

-- Insertar registros en la tabla reservasextras
INSERT INTO reservasextras (id, costo) VALUES (1, 10.5);
INSERT INTO reservasextras (id, costo) VALUES (2, 15.0);
INSERT INTO reservasextras (id, costo) VALUES (3, 7.5);

-- Insertar registros en la tabla limpiezas
INSERT INTO limpiezas (id, tipoLimpieza, cantidadPrendas, cantidadParZapatos, valorPrenda, valorPorZapato, valorLimpieza) VALUES (1, 'Ropa', 5, 2, 2.0, 3.0, 16.0);
INSERT INTO limpiezas (id, tipoLimpieza, cantidadPrendas, cantidadParZapatos, valorPrenda, valorPorZapato, valorLimpieza) VALUES (2, 'Zapatos', 0, 3, 0.0, 4.0, 12.0);
INSERT INTO limpiezas (id, tipoLimpieza, cantidadPrendas, cantidadParZapatos, valorPrenda, valorPorZapato, valorLimpieza) VALUES (3, 'Ropa y Zapatos', 3, 1, 2.5, 5.0, 12.5);

-- Insertar registros en la tabla prestamosutencilios
INSERT INTO prestamosutencilios (id, cantidadUtencilios, costoPrestamo) VALUES (1, 5, 15.0);
INSERT INTO prestamosutencilios (id, cantidadUtencilios, costoPrestamo) VALUES (2, 3, 10.0);
INSERT INTO prestamosutencilios (id, cantidadUtencilios, costoPrestamo) VALUES (3, 7, 20.0);

-- Insertar registros en la tabla utencilios
INSERT INTO utencilios (id, nombre, costo) VALUES (1, 'Cuchara', 1.0);
INSERT INTO utencilios (id, nombre, costo) VALUES (2, 'Tenedor', 1.2);
INSERT INTO utencilios (id, nombre, costo) VALUES (3, 'Cuchillo', 1.5);

-- Insertar registros en la tabla reservaspas
INSERT INTO reservaspas (id, costo, reserva) VALUES (1, 50.0, TO_DATE('2023-11-05', 'YYYY-MM-DD'));
INSERT INTO reservaspas (id, costo, reserva) VALUES (2, 55.0, TO_DATE('2023-11-10', 'YYYY-MM-DD'));
INSERT INTO reservaspas (id, costo, reserva) VALUES (3, 60.0, TO_DATE('2023-11-15', 'YYYY-MM-DD'));

-- Insertar registros en la tabla spas
INSERT INTO spas (id, nombre, descripcion, duracion, costo) VALUES (1, 'Spa Relax', 'Masaje relajante', TO_DATE('2000-01-01 01:00:00', 'YYYY-MM-DD HH24:MI:SS'), 50.0);
INSERT INTO spas (id, nombre, descripcion, duracion, costo) VALUES (2, 'Spa Energy', 'Masaje revitalizante', TO_DATE('2000-01-01 01:30:00', 'YYYY-MM-DD HH24:MI:SS'), 55.0);
INSERT INTO spas (id, nombre, descripcion, duracion, costo) VALUES (3, 'Spa Zen', 'Masaje con piedras calientes', TO_DATE('2000-01-01 02:00:00', 'YYYY-MM-DD HH24:MI:SS'), 60.0);

-- Insertar registros en la tabla gyms
INSERT INTO gyms (id, capacidad, maquinas, horario) VALUES (1, '30', 'Trotadoras, Bicicletas', TO_DATE('2000-01-01 09:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO gyms (id, capacidad, maquinas, horario) VALUES (2, '25', 'Pesas, Máquina de remo', TO_DATE('2000-01-01 06:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO gyms (id, capacidad, maquinas, horario) VALUES (3, '20', 'Elípticas, Máquinas de resistencia', TO_DATE('2000-01-01 07:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Insertar registros en la tabla piscinas
INSERT INTO piscinas (id, capacidad, profundidad, horario) VALUES (1, '50', '1.5m', TO_DATE('2000-01-01 10:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO piscinas (id, capacidad, profundidad, horario) VALUES (2, '30', '2.0m', TO_DATE('2000-01-01 09:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO piscinas (id, capacidad, profundidad, horario) VALUES (3, '20', '1.0m', TO_DATE('2000-01-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'));

-- Insertar registros en la tabla internets
INSERT INTO internets (id, capacidadGigas, costoDiario) VALUES (1, 100, 5.0);
INSERT INTO internets (id, capacidadGigas, costoDiario) VALUES (2, 150, 7.0);
INSERT INTO internets (id, capacidadGigas, costoDiario) VALUES (3, 200, 10.0);

-- Insertar registros en la tabla servicios
INSERT INTO servicios (id, nombre, hotel_id) VALUES (1, 'Servicio de Limpieza', 1);
INSERT INTO servicios (id, nombre, hotel_id) VALUES (2, 'Servicio de Comida', 2);
INSERT INTO servicios (id, nombre, hotel_id) VALUES (3, 'Servicio de Gimnasio', 3);

-- Insertar registros en la tabla reservaciones
INSERT INTO reservaciones (id, fechallegada, fechasalida, pazYsalvo, cantidadpersonas, hotel_id, planconsumo_id) 
VALUES (1, TO_DATE('2023-11-01', 'YYYY-MM-DD'), TO_DATE('2023-11-10', 'YYYY-MM-DD'), 1, 2, 1, 1);

INSERT INTO reservaciones (id, fechallegada, fechasalida, pazYsalvo, cantidadpersonas, hotel_id, planconsumo_id) 
VALUES (2, TO_DATE('2023-11-05', 'YYYY-MM-DD'), TO_DATE('2023-11-15', 'YYYY-MM-DD'), 0, 4, 2, 2);

INSERT INTO reservaciones (id, fechallegada, fechasalida, pazYsalvo, cantidadpersonas, hotel_id, planconsumo_id) 
VALUES (3, TO_DATE('2023-11-20', 'YYYY-MM-DD'), TO_DATE('2023-11-30', 'YYYY-MM-DD'), 1, 3, 3, 3);

COMMIT;
