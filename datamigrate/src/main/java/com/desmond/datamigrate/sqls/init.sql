drop database if exists ecommerce;create database ecommerce character set utf8;use ecommerce;

create table migrate_MigrateType (	migrateTypeId INT PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ) engine InnoDB;

create table migrate_MigrateEntry (	sourceId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateTypeId VARCHAR(75) NOT NULL UNIQUE ,	gorupId VARCHAR(75) ,	migrateProviderId VARCHAR(75) ,	classPK VARCHAR(75) ,	properties VARCHAR(75) ,	classnameId VARCHAR(75) UNIQUE ,	address VARCHAR(75) ,	phone VARCHAR(75) ,	question VARCHAR(75) ,	answer VARCHAR(75) ) engine InnoDB;

create table ec_counter (	name varchar(75) not null primary key,	currentId bigint(20)) engine InnoDB;