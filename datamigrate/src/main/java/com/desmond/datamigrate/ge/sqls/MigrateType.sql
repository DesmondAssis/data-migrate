

drop table if exists migrate_MigrateType;
create table migrate_MigrateType (	migrateTypeId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ) engine InnoDB;