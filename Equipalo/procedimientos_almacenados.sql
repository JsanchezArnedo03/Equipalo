delimiter $$
create trigger CrearCredendialesEmpleados before insert on empleado
for each row begin
insert into usuario(usuario, password_,Tipo_Persona) values 
(new.Ndocumento,concat(ucase(left(new.Primer_Nombre,3)),
left(new.Ndocumento,3),lcase(left(new.Primer_Apellido,2))),3);
end;$$

CREATE PROCEDURE crearEmpleado(
  tipo_documento int,
  codigo_empleado varchar(10),
  numero_documento varchar(12),
  primer_nombre varchar(150),
  segundo_nombre varchar(150),
  primer_apellido varchar(150),
  segundo_apellido varchar(150)
  )
BEGIN
  insert into empleados(tipo_documento,codigo_empleado, numero_documento,primer_nombre,
  segundo_nombre, primer_apellido,segundo_apellido)values(tipo_documento,codigo_empleado, numero_documento,primer_nombre,
  segundo_nombre, primer_apellido,segundo_apellido);
END;

$$
CREATE PROCEDURE crearDispositivo(
	id_dispositivo INT,
    cod_dispositivo VARCHAR(20) ,
    nombre_dispositivo VARCHAR(200)
  )
BEGIN
 insert into dispostivos(id_dispositivo,cod_dispositivo,nombre_dispositivo)values(id_dispositivo,
    cod_dispositivo ,
    nombre_dispositivo );
END;

$$
CREATE PROCEDURE crearDispositivo(
	id_dispositivo INT,
    cod_dispositivo VARCHAR(20) ,
    nombre_dispositivo VARCHAR(200)
  )
BEGIN
 insert into dispostivos(id_dispositivo,cod_dispositivo,nombre_dispositivo)values(id_dispositivo,
    cod_dispositivo ,
    nombre_dispositivo );
END;

$$