create database courier;

use courier;

create table users (username varchar(50) primary key not null, password varchar(50), role varchar(50), name varchar(50), phoneno varchar(12));

insert into users values('admin','admin','admin', 'admin', '12345656');

-- ordertaker

create table companyinfo (companyid int(6) primary key not null, billrate int(8), bonus int(8), phoneno int(12), basebillamount int(6), address varchar(100));

insert into companyinfo values(1, 12,10,123466788, 12, 'CST');

create table customer (customerno varchar(50) primary key not null, name varchar(50), phoneno varchar(12), custaddress varchar(100), custemail varchar(50));