

drop table if exists migrate_MigrateProvider;
create table migrate_MigrateProvider (	migrateProviderId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ,	description VARCHAR(75) ,	factoryClass VARCHAR(75) ,	parameters VARCHAR(75) ,	createdBy VARCHAR(75) ,	modifiedBy VARCHAR(75) ) engine InnoDB;