

drop table if exists migrate_MigrateServer;
create table migrate_MigrateServer (	serverId BIGINT(25) PRIMARY KEY ,	createdDate TIMESTAMP ,	modifiedDate TIMESTAMP ,	name VARCHAR(75) ,	workerCount INT ,	enabled TINYINT ) engine InnoDB;