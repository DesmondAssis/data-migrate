

drop table if exists migrate_MigrateStatus;
create table migrate_MigrateStatus (	migrateStatusId INT PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ) engine InnoDB;