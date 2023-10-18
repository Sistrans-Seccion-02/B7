-- Tabla Hotel
CREATE TABLE hoteles (
    id NUMBER(19) PRIMARY KEY,
    capacidad NUMBER(10)
);

-- Tabla Usuario
CREATE TABLE usuarios (
    id NUMBER(19) PRIMARY KEY,
    nombre VARCHAR2(255),
    correo VARCHAR2(255),
    rol VARCHAR2(50),
    hotel_id NUMBER(19),
    CONSTRAINT fk_usuario_hotel FOREIGN KEY (hotel_id) REFERENCES hoteles(id)
);

-- Tabla PlanConsumo
CREATE TABLE planesconsumo (
    id NUMBER(19) PRIMARY KEY,
    info VARCHAR2(255),
    hotel_id NUMBER(19),
    CONSTRAINT fk_planconsumo_hotel FOREIGN KEY (hotel_id) REFERENCES hoteles(id)
);

-- Tabla Cliente
CREATE TABLE clientes (
    cedula NUMBER(19) PRIMARY KEY,
    rol VARCHAR2(50),
    nombre VARCHAR2(255),
    fechanacimiento DATE,
    nacionalidad VARCHAR2(255),
    edad VARCHAR2(255),
    email VARCHAR2(255),
    telefono VARCHAR2(255)
);

-- Tabla Habitacion
CREATE TABLE habitaciones (
    id NUMBER(10) PRIMARY KEY,
    costonoche FLOAT(126),
    tipohabitacion VARCHAR2(255),
    capacidad NUMBER(10),
    hotel_id NUMBER(19),
    CONSTRAINT fk_habitacion_hotel FOREIGN KEY (hotel_id) REFERENCES hoteles(id)
);

-- Tabla CuentaConsumo
CREATE TABLE cuentasconsumo (
    id NUMBER(19) PRIMARY KEY,
    costoTotal FLOAT(126),
    habitacion NUMBER(10)
);

-- Tabla Producto
CREATE TABLE productos (
    id NUMBER(19) PRIMARY KEY,
    nombre VARCHAR2(255),
    valor FLOAT(126),
    cantidad NUMBER(10)
);

-- Tabla Restaurante
CREATE TABLE restaurantes (
    id NUMBER(19) PRIMARY KEY,
    capacidad NUMBER(10),
    estilo VARCHAR2(255),
    pp VARCHAR2(255)
);

-- Tabla Bares2
CREATE TABLE bares2 (
    id NUMBER(19) PRIMARY KEY,
    capacidad NUMBER(10),
    estilo VARCHAR2(255),
    pp VARCHAR2(255)
);


-- Tabla Supermercado
CREATE TABLE supermercados (
    id NUMBER(19) PRIMARY KEY,
    capacidad NUMBER(10),
    pp VARCHAR2(255)
);

-- Tabla Tienda
CREATE TABLE tiendas (
    id NUMBER(19) PRIMARY KEY,
    tipo VARCHAR2(255),
    nombre VARCHAR2(255),
    pp VARCHAR2(255)
);

-- Tabla ReservaSala
CREATE TABLE reservasalas (
    id NUMBER(19) PRIMARY KEY,
    costo FLOAT(126),
    reserva DATE
);

-- Tabla SalaReuniones
CREATE TABLE salasreuniones (
    id NUMBER(19) PRIMARY KEY,
    capacidad VARCHAR2(255),
    costoHora FLOAT(126),
    costoAdicional FLOAT(126)
);

-- Tabla SalaConferencias
CREATE TABLE salasconferencias (
    id NUMBER(19) PRIMARY KEY,
    capacidad VARCHAR2(255),
    costoHora FLOAT(126)
);

-- Tabla ReservaExtra
CREATE TABLE reservasextras (
    id NUMBER(19) PRIMARY KEY,
    costo FLOAT(126)
);

-- Tabla Limpieza
CREATE TABLE limpiezas (
    id NUMBER(19) PRIMARY KEY,
    tipoLimpieza VARCHAR2(255),
    cantidadPrendas NUMBER(10),
    cantidadParZapatos NUMBER(10),
    valorPrenda FLOAT(126),
    valorPorZapato FLOAT(126),
    valorLimpieza FLOAT(126)
);

-- Tabla PrestamoUtencilios
CREATE TABLE prestamosutencilios (
    id NUMBER(19) PRIMARY KEY,
    cantidadUtencilios NUMBER(10),
    costoPrestamo FLOAT(126)
);

-- Tabla Utencilio
CREATE TABLE utencilios (
    id NUMBER(19) PRIMARY KEY,
    nombre VARCHAR2(255),
    costo FLOAT(126)
);

-- Tabla ReservaSpa
CREATE TABLE reservaspas (
    id NUMBER(19) PRIMARY KEY,
    costo FLOAT(126),
    reserva DATE
);

-- Tabla Spa
CREATE TABLE spas (
    id NUMBER(19) PRIMARY KEY,
    nombre VARCHAR2(255),
    descripcion VARCHAR2(255),
    duracion DATE,
    costo FLOAT(126)
);

-- Tabla Gym
CREATE TABLE gyms (
    id NUMBER(19) PRIMARY KEY,
    capacidad VARCHAR2(255),
    maquinas VARCHAR2(255),
    horario DATE
);

-- Tabla Piscina
CREATE TABLE piscinas (
    id NUMBER(19) PRIMARY KEY,
    capacidad VARCHAR2(255),
    profundidad VARCHAR2(255),
    horario DATE
);

-- Tabla Internet
CREATE TABLE internets (
    id NUMBER(19) PRIMARY KEY,
    capacidadGigas NUMBER(10),
    costoDiario FLOAT(126)
);

-- Tabla Servicio
CREATE TABLE servicios (
    id NUMBER(19) PRIMARY KEY,
    nombre VARCHAR2(255),
    hotel_id NUMBER(19),
    CONSTRAINT fk_servicio_hotel FOREIGN KEY (hotel_id) REFERENCES hoteles(id)
);

-- Tabla Reservaciones
CREATE TABLE reservaciones (
    id NUMBER(19) PRIMARY KEY,
    fechallegada DATE,
    fechasalida DATE,
    pazYsalvo NUMBER(1) CHECK (pazYsalvo IN (0,1)), -- Booleano representado como 0 o 1
    cantidadpersonas NUMBER(10),
    hotel_id NUMBER(19),
    planconsumo_id NUMBER(19),
    CONSTRAINT fk_reservacion_hotel FOREIGN KEY (hotel_id) REFERENCES hoteles(id),
    CONSTRAINT fk_reservacion_planconsumo FOREIGN KEY (planconsumo_id) REFERENCES planesconsumo(id)
);



COMMIT;

