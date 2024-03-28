create database bd_sistema_ventas;

use bd_sistema_ventas;

-- tabla usuario
create table usuario (
idUsuario int (11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
usuario varchar(15) not null,
password varchar(15) not null,
telefono varchar(15) not null,
estado int(1) not null
);

insert into usuario(nombre, apellido, usuario, password, telefono, estado)
values("Samuel", "Linares","samuel", "12345", "8098645478",1);

select * from usuario;

select usuario, password from usuario where usuario = "samuel" and password = "12345";

-- tabla cliente
create table cliente (
idCliente int (11) auto_increment primary key,
nombre varchar(30) not null,
apellido varchar(30) not null,
cedula varchar(15) not null,
telefono varchar(15) not null,
direccion varchar(100) not null,
estado int(1) not null
);

-- tabla categoria
create table categoria (
idCategoria int (11) auto_increment primary key,
descripcion varchar(200) not null,
estado int(1) not null
);

-- tabla producto
create table producto (
idProducto int (11) auto_increment primary key,
nombre varchar(100) not null,
cantidad int(11) not null,
precio double(10,2) not null,
descripcion varchar(200) not null,
itbis int(2) not null,
idCategoria int(11) not null,
estado int(1) not null
);

-- tabla cabecera Venta
create table cabecera_venta (
idCabeceraVenta int (11) auto_increment primary key,
idCliente varchar(100) not null,
valorPagar double(10,2) not null,
fechaVenta date not null,
estado int(1) not null
);

-- tabla detalle Venta
create table detalle_venta (
idDetalleVenta int (11) auto_increment primary key,
idCabeceraVenta int (11) not null,
idProducto int(11) not null,
cantidad int (11) not null,
precioUnitario double(10,2) not null,
subTotal double(10,2) not null,
descuento double(10,2) not null,
itbis double(10,2) not null,
totalPagar double(10,2) not null,
estado int(1) not null
);

select*from cliente;
 show tables;