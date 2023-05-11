 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Super
 * Created: 13/11/2022
 */
DROP DATABASE IF EXISTS recursos_humanos_iud;

CREATE DATABASE IF NOT EXISTS recursos_humanos_iud;

USE recursos_humanos_iud;

CREATE TABLE universidades(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE niveles_formacion(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE estados_formacion(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE tipos_identificacion(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE estados_civiles(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE roles_parentescos(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE funcionarios(
    id INT NOT NULL AUTO_INCREMENT,
    numero_identificacion VARCHAR(45) NOT NULL,
    nombres VARCHAR(45) NOT NULL,
    apellidos VARCHAR(45) NOT NULL,
    sexo CHAR(2) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    telefono VARCHAR(45) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_creacion DATETIME DEFAULT NOW(),
    fecha_actualizacion DATETIME DEFAULT NOW(),
    tipos_identificacion_id INT NOT NULL,
    estados_civiles_id INT NOT NULL,
    PRIMARY KEY(id),
    UNIQUE(numero_identificacion),
    FOREIGN KEY(tipos_identificacion_id) REFERENCES tipos_identificacion(id),
    FOREIGN KEY(estados_civiles_id) REFERENCES estados_civiles(id)
);

CREATE TABLE grupo_familiar(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(45) NOT NULL,
    apellido VARCHAR(45) NOT NULL,
    direccion VARCHAR(45) NOT NULL,
    fecha_creacion DATETIME DEFAULT NOW(),
    fecha_actualizacion DATETIME DEFAULT NOW(),
    funcionarios_id INT NOT NULL,
    roles_parentescos_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(funcionarios_id) REFERENCES funcionarios(id),
    FOREIGN KEY(roles_parentescos_id) REFERENCES roles_parentescos(id)
);

CREATE TABLE formaciones_academicas(
    id INT NOT NULL AUTO_INCREMENT,
    fecha_inicio DATE NOT NULL,
    fecha_final DATE,
    fecha_creacion DATETIME DEFAULT NOW(),
    fecha_actualizacion DATETIME DEFAULT NOW(),
    funcionarios_id INT NOT NULL,
    estados_formacion_id INT NOT NULL,
    niveles_formacion_id INT NOT NULL,
    universidades_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(funcionarios_id) REFERENCES funcionarios(id),
    FOREIGN KEY(estados_formacion_id) REFERENCES estados_formacion(id),
    FOREIGN KEY(niveles_formacion_id) REFERENCES niveles_formacion(id),
    FOREIGN KEY(universidades_id) REFERENCES universidades(id)
);

INSERT INTO universidades(nombre)
VALUES ('Universidad de Antioquia');
INSERT INTO universidades(nombre)
VALUES ('Institución Universitaria Digital de Antioquia');
INSERT INTO universidades(nombre)
VALUES ('Universidad Nacional de Colombia');
INSERT INTO universidades(nombre)
VALUES ('Universidad de Caldas');
INSERT INTO universidades(nombre)
VALUES ('Universidad de La Sabana');
INSERT INTO universidades(nombre)
VALUES ('Universidad Autónoma de Bucaramanga');

INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Bachillerato','Secundaria');
INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Técnica','Primer nivel');
INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Tecnología','Segundo nivel');
INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Profesional','Universidad');
INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Maestría', 'Magister');
INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Doctorado','Doctor');
INSERT INTO niveles_formacion(nombre,descripcion)
VALUES ('Especialización','Especialista');

INSERT INTO estados_formacion(nombre,descripcion)
VALUES ('En curso','Aún en proceso');
INSERT INTO estados_formacion(nombre,descripcion)
VALUES ('Finalizado','Ya está graduado');
INSERT INTO estados_formacion(nombre,descripcion)
VALUES ('Suspendido','Por retomar');
INSERT INTO estados_formacion(nombre,descripcion)
VALUES ('Aplazado','COn fecha para retomar');
INSERT INTO estados_formacion(nombre,descripcion)
VALUES ('Reingreso','Retomando de nuevo');

INSERT INTO tipos_identificacion(nombre, descripcion)
VALUES('CC','Cédula de Ciudadanía');
INSERT INTO tipos_identificacion(nombre, descripcion)
VALUES('CE','Cédula de Extranjería');
INSERT INTO tipos_identificacion(nombre, descripcion)
VALUES('TI','Tarjeta de Identidad');
INSERT INTO tipos_identificacion(nombre, descripcion)
VALUES('PE','Pasaporte');
INSERT INTO tipos_identificacion(nombre, descripcion)
VALUES('PT','Permiso de trabajo');

INSERT INTO estados_civiles(nombre,descripcion)
VALUES ('SOL','Soltero');
INSERT INTO estados_civiles(nombre,descripcion)
VALUES ('CAS','Casado');
INSERT INTO estados_civiles(nombre,descripcion)
VALUES ('UL','Unión Libre');
INSERT INTO estados_civiles(nombre,descripcion)
VALUES ('VIU','Viudo');
INSERT INTO estados_civiles(nombre,descripcion)
VALUES ('DIV','Divorciado');

INSERT INTO roles_parentescos(nombre,descripcion)
VALUES('ABU','Abuelo o Abuela');
INSERT INTO roles_parentescos(nombre,descripcion)
VALUES('PAD','Padre');
INSERT INTO roles_parentescos(nombre,descripcion)
VALUES('MAD','Madre');
INSERT INTO roles_parentescos(nombre,descripcion)
VALUES('ESP','Esposa o Esposo');
INSERT INTO roles_parentescos(nombre,descripcion)
VALUES('HIJ','Hijo o Hija');
INSERT INTO roles_parentescos(nombre,descripcion)
VALUES('SUE','Suegra o suegro');

