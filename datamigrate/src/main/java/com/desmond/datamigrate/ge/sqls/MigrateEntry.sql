

drop table if exists migrate_MigrateEntry;
create table migrate_MigrateEntry (	sourceId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	migrateTypeId VARCHAR(75) NOT NULL UNIQUE ,	gorupId VARCHAR(75) ,	migrateProviderId VARCHAR(75) ,	classPK VARCHAR(75) ,	properties VARCHAR(75) ,	classnameId VARCHAR(75) UNIQUE ,	address VARCHAR(75) ,	phone VARCHAR(75) ,	question VARCHAR(75) ,	answer VARCHAR(75) ) engine InnoDB;