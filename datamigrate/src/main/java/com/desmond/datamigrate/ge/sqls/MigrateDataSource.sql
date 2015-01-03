

drop table if exists migrate_MigrateDataSource;
create table migrate_MigrateDataSource (	dataSourceId BIGINT(25) PRIMARY KEY ,	serverName VARCHAR(75) ,	jdbcURL VARCHAR(75) ,	userName VARCHAR(75) ,	password VARCHAR(75) ) engine InnoDB;