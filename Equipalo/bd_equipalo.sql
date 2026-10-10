drop database prestamos;
CREATE DATABASE prestamos;
USE prestamos;

CREATE TABLE estado_solicitud (
    id_estado_solicitud INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_solicitud VARCHAR(25) NOT NULL
);
CREATE TABLE estado_dispositivo (
    id_estado_dispositivo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    estado_dispositivo VARCHAR(20) NOT NULL
);
CREATE TABLE tipo_documento (
    id_tipo_documento INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    tipo_documento VARCHAR(150) NOT NULL,
    abreviatura VARCHAR(5),
    descripcion VARCHAR(50)
);

CREATE TABLE dispositivos (
    id_dispositivo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cod_dispositivo VARCHAR(20) NOT NULL,
    nombre_dispositivo VARCHAR(200) NOT NULL
);

CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fk_tipo_documento INT,
    cod_empleado VARCHAR(10) NOT NULL,
    numero_documento VARCHAR(10) NOT NULL,
    primer_nombre VARCHAR(100) NOT NULL,
    segundo_nombre VARCHAR(100),
    primer_apellido VARCHAR(100) NOT NULL,
    segundo_apellido VARCHAR(100),
    CONSTRAINT FOREIGN KEY (fk_tipo_documento)
        REFERENCES prestamos.tipo_documento (id_tipo_documento)
);

CREATE TABLE solicitudes (
    id_solicitudes INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cod_solicitud VARCHAR(20) NOT NULL,
    fk_empleado_solicita INT,
    fk_dispositivo_solicitado INT,
    fecha_creacion_solicitud DATETIME,
    fecha_solicitada DATETIME,
    estado_solicitud INT,
    CONSTRAINT FOREIGN KEY (fk_empleado_solicita)
        REFERENCES prestamos.empleados (id_empleado),
    CONSTRAINT FOREIGN KEY (fk_dispositivo_solicitado)
        REFERENCES prestamos.dispositivos (id_dispositivo),
    CONSTRAINT FOREIGN KEY (estado_solicitud)
        REFERENCES prestamos.estado_solicitud (id_estado_solicitud)
);

CREATE TABLE devolucion (
    id_solicitud_estado_equipo INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    fk_solicitud INT,
    fk_dispositivo INT,
    fk_estado_dispositivo INT,
    CONSTRAINT FOREIGN KEY (fk_solicitud)
        REFERENCES prestamos.solicitudes (id_solicitudes),
    CONSTRAINT FOREIGN KEY (fk_dispositivo)
        REFERENCES prestamos.dispositivos (id_dispositivo),
    CONSTRAINT FOREIGN KEY (fk_estado_dispositivo)
        REFERENCES prestamos.estado_dispositivo (id_estado_dispositivo)
);


insert into estado_solicitud(id_estado_solicitud,estado_solicitud)
values(1,"PENDIENTE"),(2,"EN REVISION"),(3,"ENTREGADO"),(4,"REVISADA"),(5,"APROBADA");

insert into estado_dispositivo(id_estado_dispositivo,estado_dispositivo)
values(1,"DISPONIBLE"),(2,"AVERIADO"),(3,"EXTRAVIADO"),(4,"EN MANTENIMIENTO");

insert into tipo_documento(id_tipo_documento,tipo_documento,abreviatura,descripcion)
values(1,"CEDULA DE CIUDADANIA","CC",""),(2,"CEDULA DE EXTRANJERIA","CE",""),(3,"PERMISO ESPECIAL DE PERMANENCIA","PEP",""),(4,"PERMISO POR PROTECCION TEMPORAL","PPT","");

insert into dispositivos(id_dispositivo,cod_dispositivo,nombre_dispositivo)
values(1,"PC-1","COMPUTADOR #1"),(2,"PC-2","COMPUTADOR #2"),(3,"PC-3","COMPUTADOR #3"),(4,"PC-4","COMPUTADOR #4")
,(5,"PR-1","PROYECTOR #1");

INSERT INTO empleados (fk_tipo_documento, cod_empleado, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido)
VALUES 
    (1, 'EMP001', '1010101011', 'Carlos', 'Andrés', 'García', 'López'),
    (1, 'EMP002', '1020202022', 'María', 'Fernanda', 'Rodríguez', 'Pérez'),
    (2, 'EMP003', '1030303033', 'Luis', NULL, 'Martínez', 'Gómez'),
    (1, 'EMP004', '1040404044', 'Ana', 'Lucía', 'Hernández', NULL),
    (3, 'EMP005', '1050505055', 'Jorge', 'Eduardo', 'Díaz', 'Sánchez'),
    (1, 'EMP006', '1060606066', 'Laura', 'Camila', 'Ramírez', 'Torres'),
    (2, 'EMP007', '1070707077', 'Diego', 'Alejandro', 'Rojas', 'Vargas'),
    (1, 'EMP008', '1080808088', 'Marta', 'Elena', 'Castro', 'Gutiérrez'),
    (4, 'EMP009', '1090909099', 'Pedro', 'Pablo', 'Ortiz', 'Navarro'),
    (1, 'EMP010', '1100101010', 'Valeria', NULL, 'Silva', 'Mendoza');
    

insert into solicitudes(id_solicitudes,cod_solicitud,fk_empleado_solicita,fk_dispositivo_solicitado,fecha_creacion_solicitud,fecha_solicitada,estado_solicitud)
values(1,"RDS-1",1,1,current_timestamp(),'2026-10-01 08:00:00',5);


insert into devolucion(id_solicitud_estado_equipo,fk_solicitud,fk_dispositivo,fk_estado_dispositivo)
values(1,1,1,1);