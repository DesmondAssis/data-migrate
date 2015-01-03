drop database if exists ecommerce;create database ecommerce character set utf8;use ecommerce;

drop table if exists migrate_MigrateType;
create table migrate_MigrateType (	migrateTypeId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ) engine InnoDB;

drop table if exists migrate_MigrateEntry;
create table migrate_MigrateEntry (	sourceId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateTypeId VARCHAR(75) NOT NULL UNIQUE ,	gorupId VARCHAR(75) ,	migrateProviderId VARCHAR(75) ,	classPK VARCHAR(75) ,	properties VARCHAR(75) ,	classnameId VARCHAR(75) UNIQUE ,	address VARCHAR(75) ,	phone VARCHAR(75) ,	question VARCHAR(75) ,	answer VARCHAR(75) ) engine InnoDB;

drop table if exists migrate_MigrateStatus;
create table migrate_MigrateStatus (	migrateStatusId INT PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ) engine InnoDB;

drop table if exists migrate_MigrateServer;
create table migrate_MigrateServer (	serverId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ,	workerCount INT ,	enabled TINYINT ) engine InnoDB;

drop table if exists migrate_MigrateProvider;
create table migrate_MigrateProvider (	migrateProviderId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ,	description VARCHAR(75) ,	factoryClass VARCHAR(75) ,	parameters VARCHAR(75) ,	createdBy VARCHAR(75) ,	modifiedBy VARCHAR(75) ) engine InnoDB;

drop table if exists migrate_MigrateBatch;
create table migrate_MigrateBatch (	migrateBatchId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateProviderId BIGINT(25) ,	groupId BIGINT(25) ,	groupName VARCHAR(75) ,	migrateStatusId INT ,	name VARCHAR(75) ,	parameters VARCHAR(75) ,	server VARCHAR(75) ,	totalCount BIGINT(25) ,	successCount BIGINT(25) ,	failureCount BIGINT(25) ,	note VARCHAR(75) ,	createdBy BIGINT(25) ,	modifiedBy BIGINT(25) ) engine InnoDB;

drop table if exists migrate_MigrateTask;
create table migrate_MigrateTask (	migrateTaskId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateBatchId BIGINT(25) ,	sourceId BIGINT(25) ,	migrateTypeId INT ,	name VARCHAR(75) ,	priority INT ,	migrateStatusId INT ,	elapsedMillisec BIGINT(25) ,	result VARCHAR(75) ,	server VARCHAR(75) ,	successCount INT ,	failureCount INT ,	createdBy BIGINT(25) ,	modifiedBy BIGINT(25) ) engine InnoDB;

drop table if exists migrate_MigrateTaskLog;
create table migrate_MigrateTaskLog (	migrateTaskLogId BIGINT(25) PRIMARY KEY ,	migrateTaskId BIGINT(25) ,	sourceId BIGINT(25) ,	type_ INT ,	statusId INT ,	elapsedMillisec BIGINT(25) ,	successCount INT ,	failureCount INT ,	result VARCHAR(75) ) engine InnoDB;

drop table if exists migrate_MigrateDataSource;
create table migrate_MigrateDataSource (	dataSourceId BIGINT(25) PRIMARY KEY ,	serverName VARCHAR(75) ,	jdbcURL VARCHAR(75) ,	userName VARCHAR(75) ,	password VARCHAR(75) ) engine InnoDB;

create table ec_counter (	name varchar(75) not null primary key,	currentId bigint(20)) engine InnoDB;