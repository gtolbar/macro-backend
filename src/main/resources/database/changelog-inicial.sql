-- liquibase formatted sql

-- changeset Gustavo:1
-- comment: Se crea tabla de alimentos
CREATE TABLE alimento(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    proteina INT NOT NULL,
	carbohidrato INT NOT NULL,
    grasa INT NOT NULL
);

-- changeset Gustavo:2
-- comment: Se crea tabla de roles
CREATE TABLE rol(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL UNIQUE,
	descripcion VARCHAR(50) NOT NULL
);

-- changeset Gustavo:3
-- comment: Se crea tabla de periodo
CREATE TABLE periodo(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre  VARCHAR(50) NOT NULL,
    descripcion VARCHAR(50) NOT NULL
);

-- changeset Gustavo:4
-- comment: Se crea tabla de usuarios
CREATE TABLE usuario(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
	clave VARCHAR(50) NOT NULL,
    estado BOOLEAN NOT NULL,
    id_rol INT NOT NULL,
		FOREIGN KEY (id_rol) REFERENCES rol(id)
);

-- changeset Gustavo:5
-- comment: Se crea tabla de persona
CREATE TABLE persona(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL UNIQUE,
	edad INT UNSIGNED NOT NULL,
    altura INT UNSIGNED NOT NULL,
    peso INT UNSIGNED NOT NULL,
    id_usuario INT NOT NULL,
		FOREIGN KEY(id_usuario) REFERENCES usuario(id),
	id_periodo INT NOT NULL,
		FOREIGN KEY (id_periodo) REFERENCES periodo(id)
);

-- changeset Gustavo:6
-- comment: Se crea tabla dieta
CREATE TABLE dieta(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_alimento INT NOT NULL,
		FOREIGN KEY (id_alimento) REFERENCES alimento(id),
	id_persona INT NOT NULL,
		FOREIGN KEY (id_persona) REFERENCES persona(id)
);

-- changeset Gustavo:7
-- comment: Se crea registros periodo
INSERT INTO periodo(nombre,descripcion) VALUES 
("Deficit calorico","Bajar de peso"),
("Matenimiento calorico","Mantener de peso"),
("Superplus calorico","Subir de peso");

-- changeset Gustavo:8
-- comment: Se crea registros rol
INSERT INTO rol(nombre,descripcion) VALUES 
("Administrador","Control de todo"),
("Usuario","Permisos basicos");

-- changeset Gustavo:9
-- comment: Se crea registro usuarios prueba
INSERT INTO usuario(nombre,clave,estado,id_rol) VALUES 
("tolbar","pepito123",true,"1"),
("pepito","pepito123",true,"2");

-- changeset Gustavo:10
-- comment: Se crea registro personas prueba
INSERT INTO persona(nombre,edad,altura,peso,id_usuario,id_periodo) VALUES 
("Gustavo admin","24","1.70","56","1","2"),
("Gustavo user","24","1.70","56","2","2");

-- changeset Gustavo:11
-- comment: Se crea registro personas prueba
INSERT INTO alimento(nombre,proteina,carbohidrato,grasa) VALUES ("BiPro","22","0","0");
